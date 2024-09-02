package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.EmployeeEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.EmployeeDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.EmployeeService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeIMPL implements EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final Mapping mapping;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {
        employee.setEmployeeId(UUID.randomUUID().toString());
        return mapping.toEmployeeDTO(employeeDAO.save(mapping.toEmployee(employee)));

    }

    @Override
    public void deleteEmployee(String id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> tmpEmployee = employeeDAO.findById(id);
            tmpEmployee.get().setEmployeeName(employeeDTO.getEmployeeName());
//            tmpEmployee.get().setEmployeeProfilePic(UtilMatters.convertBase64(employeeDTO.getEmployeeProfilePic()));
//            tmpEmployee.get().setGender(employeeDTO.getGender());
//            tmpEmployee.get().setStatus(employeeDTO.getStatus());
//            tmpEmployee.get().setDesignation(employeeDTO.getDesignation());
//            tmpEmployee.get().setRole(employeeDTO.getRole());
//            tmpEmployee.get().setDob(employeeDTO.getDob());
//            tmpEmployee.get().setJoinDate(employeeDTO.getJoinDate());
//            tmpEmployee.get().setAttachedBranch(employeeDTO.getAttachedBranch());
//            tmpEmployee.get().setEmployeeAddress1(employeeDTO.getEmployeeAddress1());
//            tmpEmployee.get().setEmployeeAddress2(employeeDTO.getEmployeeAddress2());
//            tmpEmployee.get().setEmployeeAddress3(employeeDTO.getEmployeeAddress3());
//            tmpEmployee.get().setEmployeeAddress4(employeeDTO.getEmployeeAddress4());
//            tmpEmployee.get().setEmployeeAddress5(employeeDTO.getEmployeeAddress5());
//            tmpEmployee.get().setContactNo(employeeDTO.getContactNo());
//            tmpEmployee.get().setEmail(employeeDTO.getEmail());
//            tmpEmployee.get().setInformInCaseOfEmergency(employeeDTO.getInformInCaseOfEmergency());
//            tmpEmployee.get().setEmergencyContactNo(employeeDTO.getEmergencyContactNo());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapping.toEmployeeDTOList(employeeDAO.findAll());

    }

    @Override
    public long count() {
        return employeeDAO.count();
    }
}
