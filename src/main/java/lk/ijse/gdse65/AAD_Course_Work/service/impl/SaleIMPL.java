package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SaleInventoryDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.*;
import lk.ijse.gdse65.AAD_Course_Work.repo.*;
import lk.ijse.gdse65.AAD_Course_Work.service.SaleService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class  SaleIMPL implements SaleService {

    private final SaleDAO saleDAO;
    private final CustomerDAO customerDAO;
    private final EmployeeDAO employeeDAO;
    private final InventoryDAO inventoryDAO;
    private final SaleInventoryDAO saleInventoryDAO;
    private final Mapping mapping;


    @Override
    public void createSale(SaleDTO saleDTO) {
        Optional<CustomerEntity> customer = customerDAO.findById(saleDTO.getCustomer_code());
        Optional<EmployeeEntity> employee = employeeDAO.findById(saleDTO.getEmployeeId());
        SaleEntity saleEntity = mapping.toSaleEntity(saleDTO);
        saleEntity.setCustomer(customer.get());
        saleEntity.setCashier(employee.get());
//        saleEntity = saleDAO.save(saleEntity);

        List<SaleInventoryDetails> saleInventoryDetailsList = new ArrayList<>();
        List<InventoryEntity> itemListToUpdate = new ArrayList<>();
        for (SaleInventoryDTO saleInventoryDTO: saleDTO.getSaleInventoryDetails()
             ) {
            InventoryEntity item = inventoryDAO.findById(saleInventoryDTO.getItem_code()).get();
            SaleInventoryDetails saleInventoryDetails = mapping.toSaleInventoryDetaisEntity(saleInventoryDTO);
            saleInventoryDetails.setInventory(item);
            saleInventoryDetails.setSale(saleEntity);
            saleInventoryDetailsList.add(saleInventoryDetails);

            item.setItem_qty(item.getItem_qty() - saleInventoryDetails.getItem_qty());
            itemListToUpdate.add(item);
        }
//        saleInventoryDAO.saveAll(saleInventoryDetailsList);
        saleEntity.setSaleInventoryDetails(saleInventoryDetailsList);
        saleDAO.save(saleEntity);
        inventoryDAO.saveAll(itemListToUpdate);
    }

    @Override
    public SaleDTO getSaleByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public void updateSale(String orderNo, SaleDTO saleDTO) {

    }

    @Override
    public void deleteSale(String orderNo) {

    }
}





































































































































































































































































































































































































































