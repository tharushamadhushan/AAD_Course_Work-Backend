package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employee);
    void deleteEmployee(String id);
    void updateEmployee(String id,EmployeeDTO employee);
    List<EmployeeDTO> getAllEmployees();
    long count();
}
