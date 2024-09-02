package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
//    String addUser(UserDTO userDTO);
//
//    LoginResponse loginUser(LoginDTO loginDTO);


    UserDetailsService userDetailService();
    void save(UserDTO user);
}
