package lk.ijse.gdse65.AAD_Course_Work.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "saleInventory")
public class SaleInventoryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String order_detail_id;
    private String item_desc;
    private int size;
    private double unit_price;
    private int item_qty;
    private double total_price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_no")
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "item_code")
    private InventoryEntity inventory;
}
