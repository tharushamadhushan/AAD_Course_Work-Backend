package lk.ijse.gdse65.AAD_Course_Work.dto;

import lk.ijse.gdse65.AAD_Course_Work.entity.num.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
}

