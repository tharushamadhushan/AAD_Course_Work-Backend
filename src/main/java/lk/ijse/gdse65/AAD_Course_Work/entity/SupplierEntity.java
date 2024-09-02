package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity implements SuperEntity {
    @Id
    private String supplier_id;
    private String supplier_name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address_line_01;
    private String address_line_02;
    private String address_line_03;
    private String address_line_04;
    private String address_line_05;
    private String address_line_06;
    private String contact_no_1;
    private String contact_no_2;
    private String email;

//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "item_code")
//    private InventoryEntity inventory;
}
