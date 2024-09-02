package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    CustomerDTO getSelectedCustomer(String id);
    void deleteCustomer(String id);
    void updateCustomer(String id,CustomerDTO Customer);
    List<CustomerDTO> getAllCustomers();
    long count();

}
