package lk.ijse.gdse65.AAD_Course_Work.util;

import lk.ijse.gdse65.AAD_Course_Work.dto.*;
import lk.ijse.gdse65.AAD_Course_Work.entity.*;
import lk.ijse.gdse65.AAD_Course_Work.repo.CustomerDAO;
import lk.ijse.gdse65.AAD_Course_Work.repo.InventoryDAO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    //////Customer
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }

    //////Supplier
    public SupplierDTO toSupplierDTO(SupplierEntity supplier) {
        return  mapper.map(supplier, SupplierDTO.class);
    }

    public SupplierEntity toSupplierEntity(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }

    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> suppliers) {
        return mapper.map(suppliers, List.class);
    }

    ////////Employee
    public EmployeeDTO toEmployeeDTO(EmployeeEntity employee) {
        return  mapper.map(employee, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employee) {
        return mapper.map(employee, List.class);
    }
    //****************** Inventory ******************
    public InventoryDTO toInventoryDTO(InventoryEntity inventory){
        return mapper.map(inventory,InventoryDTO.class);
    }
    public InventoryEntity toIventoryEntity(InventoryDTO inventoryDTO){
        return mapper.map(inventoryDTO,InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventories){
        return mapper.map(inventories,List.class);
    }

    //****************** Item ******************
    public ItemDTO toItemDTO(ItemEntity item){
        return mapper.map(item,ItemDTO.class);
    }
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return mapper.map(itemDTO,ItemEntity.class);
    }
    public List<ItemDTO>toItemDTOList(List<ItemEntity>items){
        return mapper.map(items,List.class);
    }

    //****************** sale ******************
    public SaleDTO toSaleDTO(SaleEntity saleEntity) {
        return  mapper.map(saleEntity, SaleDTO.class);
    }
    public SaleEntity toSaleEntity(SaleDTO saleDTO) {
        return  mapper.map(saleDTO, SaleEntity.class);
    }
    public List<SaleDTO> toSaleDTOList(List<SaleEntity> saleEntities) {
        return saleEntities.stream()
                .map(saleEntity -> mapper.map(saleEntity, SaleDTO.class))
                .collect(Collectors.toList());
    }

    public SaleInventoryDTO toSaleInventoryDetaisDTO(SaleInventoryDetails saleInventoryDetails) {
        return  mapper.map(saleInventoryDetails, SaleInventoryDTO.class);
    }
    public SaleInventoryDetails toSaleInventoryDetaisEntity(SaleInventoryDTO saleInventoryDTO) {
        return  mapper.map(saleInventoryDTO, SaleInventoryDetails.class);
    }




    //****************** Refund ******************
    public RefundDTO toRefundDTO (RefundEntity refund){
        return mapper.map(refund,RefundDTO.class);
    }
    public RefundEntity torRefundEntity (RefundDTO refundDTO){
        return mapper.map(refundDTO,RefundEntity.class);
    }
    public List<RefundDTO> toRefundDTOList (List<RefundEntity> refunds){
        return mapper.map(refunds,List.class);
    }

    //user
    public UserDTO toUserDTO(UserEntity user) {
        return  mapper.map(user, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO userDTO){
        return  mapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> users) {
        return mapper.map(users, List.class);

    }
}
