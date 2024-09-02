package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.CustomerDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.CustomerService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerIMPL implements CustomerService {

    private final CustomerDAO customerDAO;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        customer.setCustomer_code(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(customerDAO.save(mapping.toCustomer(customer)));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {
        customerDAO.deleteById(id);
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customer) {
        Optional<CustomerEntity> tmpCustomer = customerDAO.findById(id);
        tmpCustomer.get().setCustomer_name(customer.getCustomer_name());
        tmpCustomer.get().setGender(customer.getGender());
        tmpCustomer.get().setJoin_date(customer.getJoin_date());
        tmpCustomer.get().setLevel(customer.getLevel());
        tmpCustomer.get().setTotal_points(customer.getTotal_points());
        tmpCustomer.get().setDob(customer.getDob());
        tmpCustomer.get().setAddress1(customer.getAddress1());
        tmpCustomer.get().setAddress2(customer.getAddress2());
        tmpCustomer.get().setAddress3(customer.getAddress3());
        tmpCustomer.get().setAddress4(customer.getAddress4());
        tmpCustomer.get().setAddress5(customer.getAddress5());
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.findAll().stream()
                .map(mapping::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customerDAO.count();
    }
}
