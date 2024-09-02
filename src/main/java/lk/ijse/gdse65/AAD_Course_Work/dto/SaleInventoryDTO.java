package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleInventoryDTO {
    private String orderDetailId;
    private String item_code;
    private String item_desc;
    private int size;
    private double unit_price;
    private int item_qty;
    private double total_price;
    private InventoryDTO inventory;
}
