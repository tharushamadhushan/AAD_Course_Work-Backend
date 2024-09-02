package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;

import java.util.List;

public interface SaleService {
//    SaleDTO saveSale(SaleDTO sale);
//    List<SaleDTO> getAllSales();
//    SaleDTO getSaleById(String orderNo);
//    void deleteSale(String orderNo);
    void createSale(SaleDTO saleDTO);
    SaleDTO getSaleByOrderNo(String orderNo);
    void updateSale(String orderNo, SaleDTO saleDTO);
    void deleteSale(String orderNo);

}
