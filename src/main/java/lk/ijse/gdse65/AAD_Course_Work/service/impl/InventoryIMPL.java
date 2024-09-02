package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.InventoryDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.InventoryEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.InventoryDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.InventoryService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryIMPL implements InventoryService {
    private final InventoryDAO inventoryDAO;
    private final Mapping mapping;

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventory) {
//        inventory.setItem_code(UUID.randomUUID().toString());
        return mapping.toInventoryDTO(inventoryDAO.save(mapping.toIventoryEntity(inventory)));
    }

    @Override
    public void deleteInventory(String id) {
        inventoryDAO.deleteById(id);
    }

    @Override
    public void updateInventory(String id, InventoryDTO inventoryDTO) {
        Optional<InventoryEntity> inventory = inventoryDAO.findById(id);
            inventory.get().setItem_desc(inventoryDTO.getItem_desc());
            inventory.get().setItem_qty(inventoryDTO.getItem_qty());
            inventory.get().setItem_pic(inventoryDTO.getItem_pic());
            inventory.get().setCategory(inventoryDTO.getCategory());
            inventory.get().setSize(inventoryDTO.getSize());
            inventory.get().setUnit_price_sale(inventoryDTO.getUnit_price_sale());
            inventory.get().setUnit_price_buy(inventoryDTO.getUnit_price_buy());
            inventory.get().setExpected_profit(inventoryDTO.getExpected_profit());
            inventory.get().setProfit_margin(inventoryDTO.getProfit_margin());
            inventory.get().setStatus(inventoryDTO.getStatus());

    }


    public void updateInventoryQuantity(String itemId, int quantity) throws NotFoundException {
        InventoryEntity item = inventoryDAO.findById(itemId).orElseThrow(() -> new NotFoundException("Item not found"));
        item.setItem_qty(item.getItem_qty() + quantity);
        inventoryDAO.save(item);
    }

    @Override
    public List<InventoryDTO> getAllInventory() {

        return mapping.toInventoryDTOList(inventoryDAO.findAll());
    }

    @Override
    public long count() {
        return inventoryDAO.count();
    }

    @Override
    public double calculateTotalProfit() {
        return inventoryDAO.findAll().stream()
                .mapToDouble(InventoryEntity::getExpected_profit)
                .sum();
    }

    @Override
    public Double getTotalSales() {
        return inventoryDAO.findTotalSales();
    }

    @Override
    public Optional<String> getMostSoldItemName() {
        return inventoryDAO.findTopSoldItem().stream()
                .findFirst()
                .map(InventoryEntity::getItem_desc);
    }

    @Override
    public Optional<Integer> getMostSoldItemQty() {
        return inventoryDAO.findTopSoldItem().stream()
                .findFirst()
                .map(InventoryEntity::getItem_qty);
    }
}
