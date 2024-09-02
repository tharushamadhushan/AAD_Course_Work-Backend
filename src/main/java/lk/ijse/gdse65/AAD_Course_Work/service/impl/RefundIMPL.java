package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundedItemDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.InventoryEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.RefundEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.SaleEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.SaleInventoryDetails;
import lk.ijse.gdse65.AAD_Course_Work.repo.InventoryDAO;
import lk.ijse.gdse65.AAD_Course_Work.repo.RefundDAO;
import lk.ijse.gdse65.AAD_Course_Work.repo.SaleDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.RefundService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RefundIMPL implements RefundService {
    private final RefundDAO refundRepository;
    private final InventoryDAO inventoryDAO;
    private final Mapping mapping;

//    public RefundService(RefundDAO refundRepository, InventoryDAO inventoryDAO, Mapping mapping) {
//        this.refundRepository = refundRepository;
//        this.inventoryDAO = inventoryDAO;
//        this.mapping = mapping;
//    }

    public RefundEntity processRefund(RefundDTO refundDTO) throws NotFoundException {
        // Convert DTO to entity
        RefundEntity refundEntity = mapping.torRefundEntity(refundDTO);
        RefundEntity savedRefund = refundRepository.save(refundEntity);

        // Ensure refundedItems is not null
        List<RefundedItemDTO> refundedItems = refundDTO.getRefundedItems() != null ? refundDTO.getRefundedItems() : new ArrayList<>();

        List<InventoryEntity> itemListToUpdate = new ArrayList<>();
        for (RefundedItemDTO refundedItem : refundedItems) {
            String inventoryId = refundedItem.getInventoryId();
            int refundedQty = refundedItem.getRefundedQuantity();
            InventoryEntity inventoryEntity = inventoryDAO.findById(inventoryId).get();
            int currentQty = inventoryEntity.getItem_qty();
            inventoryEntity.setItem_qty(currentQty + refundedQty); // Update inventory quantity
            itemListToUpdate.add(inventoryEntity);
        }

        // Save updated inventory quantities
        inventoryDAO.saveAll(itemListToUpdate);

        return savedRefund;
    }
}
