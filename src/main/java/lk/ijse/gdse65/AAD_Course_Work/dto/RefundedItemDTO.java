package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefundedItemDTO {
    private String inventoryId; // Assuming you need the ID of the inventory item
    private int refundedQuantity;
}
