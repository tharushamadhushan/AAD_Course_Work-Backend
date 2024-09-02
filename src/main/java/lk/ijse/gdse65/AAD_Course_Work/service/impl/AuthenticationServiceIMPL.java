package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.UserEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Role;
import lk.ijse.gdse65.AAD_Course_Work.repo.UserDAO;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignIn;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignUp;
import lk.ijse.gdse65.AAD_Course_Work.service.AuthenticationService;
import lk.ijse.gdse65.AAD_Course_Work.service.JWTService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDAO userRepo;
    private final JWTService jwtService;
    private final Mapping mapping;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO buildUser = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .name(signUp.getName())
//                .firstName(signUp.getFirstName())
//                .lastName(signUp.getLastName())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        UserEntity savedUser = userRepo.save(mapping.toUserEntity(buildUser));
        String genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).build();

    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUserName(accessToken);
        var userEntity = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}
