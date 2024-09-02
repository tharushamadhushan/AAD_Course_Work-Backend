package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lk.ijse.gdse65.AAD_Course_Work.controller.Sale;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity{
    @Id
    private String customer_code;
    private String customer_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date join_date;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int total_points;
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<SaleEntity> sales = new ArrayList<>();
}
