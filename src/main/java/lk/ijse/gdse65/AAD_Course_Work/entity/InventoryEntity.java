package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity implements SuperEntity {
    @Id
    private String item_code;
    private String item_desc;
    private int item_qty;
    @Column(columnDefinition = "LONGTEXT")
    private String item_pic;
    private String category;
    private int size;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private double profit_margin;
    private String status;

    @ManyToOne
    private ItemEntity item;

//    @OneToMany(mappedBy = "refundId.inventory", cascade = CascadeType.ALL)
//    private List<RefundEntity> resupplyItems;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SaleInventoryDetails> saleDetails = new HashSet<>();

}
