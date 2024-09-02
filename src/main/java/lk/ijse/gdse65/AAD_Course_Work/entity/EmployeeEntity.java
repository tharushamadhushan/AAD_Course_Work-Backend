package lk.ijse.gdse65.AAD_Course_Work.entity;


import jakarta.persistence.*;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")

public class EmployeeEntity implements SuperEntity {
    @Id
    private String employeeId;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String employeeProfilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Date dob;
    private Date joinDate;
    private String attachedBranch;
    private String employeeAddress1;
    private String employeeAddress2;
    private String employeeAddress3;
    private String employeeAddress4;
    private String employeeAddress5;
    private String contactNo;
    private String email;
    private String informInCaseOfEmergency;
    private String emergencyContactNo;


}
