package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
//@PreAuthorize("hasAuthority('ROLE ADMIN')")
public class Customer {

    private final CustomerService customerService;

    @GetMapping("/count")
    public ResponseEntity<Long> countCustomers() {
        long totalCustomers = customerService.count();
        return ResponseEntity.ok(totalCustomers);
    }

    @GetMapping("/health")
    public String healthTest(){
        return "Customer Health Test AAD course work";
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(value = "/{customer_code}")
    public void deleteCustomer(@PathVariable ("customer_code") String id){
        customerService.deleteCustomer(id);
    }

    @PatchMapping
    public void update(@RequestBody CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {
        customerService.updateCustomer(customerDTO.getCustomer_code(),customerDTO);
    }
}
