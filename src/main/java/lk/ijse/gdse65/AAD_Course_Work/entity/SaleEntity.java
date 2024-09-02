package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
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
@Table(name = "sale")
public class SaleEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String order_no;
    private Date purchase_date;
    private String payment_method;
    private double added_points;
    private double netTotal;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeeEntity cashier;

    @ManyToOne
    @JoinColumn(name = "customer_code")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleInventoryDetails> saleInventoryDetails = new ArrayList<>();
}
