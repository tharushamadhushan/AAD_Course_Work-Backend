package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.InventoryDTO;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO inventory);
    void deleteInventory(String id);
    void updateInventory(String id,InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllInventory();
    long count();
    double calculateTotalProfit();
    Double getTotalSales();
    Optional<String> getMostSoldItemName();
    Optional<Integer> getMostSoldItemQty();
}
