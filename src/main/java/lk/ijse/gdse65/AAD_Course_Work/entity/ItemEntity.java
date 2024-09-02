package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String item_code;
    private String item_name;
    private String item_description;
//    private Double item_price;
//    private int item_qty;

    @ManyToOne
    private SupplierEntity supplier;

}
