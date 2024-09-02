package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import lk.ijse.gdse65.AAD_Course_Work.repo.UserDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.UserService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserIMPL implements UserService {


    private final UserDAO userRepo;
    private final Mapping mapping;
    @Override
    public UserDetailsService userDetailService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("USER NOT FOUND"));
    }

    @Override
    public void save(UserDTO user) {
        userRepo.save(mapping.toUserEntity(user));

    }



}
