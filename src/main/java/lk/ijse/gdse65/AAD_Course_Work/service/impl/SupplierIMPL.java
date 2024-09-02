package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.SupplierEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.SupplierDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.SupplierService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierIMPL implements SupplierService {
    private final SupplierDAO supplierDAO;
    private final Mapping mapping;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setSupplier_id(UUID.randomUUID().toString());
        return mapping.toSupplierDTO(supplierDAO.save(mapping.toSupplierEntity(supplierDTO)));
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return mapping.toSupplierDTOList(supplierDAO.findAll());
    }

    @Override
    public SupplierDTO getSelectedSupplier(String id) {
        return null;
    }


    @Override
    public void deleteSupplier(String id) {
        supplierDAO.deleteById(id);
    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {
        Optional<SupplierEntity> supplier = supplierDAO.findById(id);
            supplier.get().setSupplier_name(supplierDTO.getSupplier_name());
            supplier.get().setCategory(supplierDTO.getCategory());
            supplier.get().setAddress_line_01(supplierDTO.getAddress_line_01());
            supplier.get().setAddress_line_02(supplierDTO.getAddress_line_02());
            supplier.get().setAddress_line_03(supplierDTO.getAddress_line_03());
            supplier.get().setAddress_line_04(supplierDTO.getAddress_line_04());
            supplier.get().setAddress_line_05(supplierDTO.getAddress_line_05());
            supplier.get().setAddress_line_06(supplierDTO.getAddress_line_06());
            supplier.get().setContact_no_1(supplierDTO.getContact_no_1());
            supplier.get().setContact_no_2(supplierDTO.getContact_no_2());
            supplier.get().setEmail(supplierDTO.getEmail());
    }

    @Override
    public long count() {
        return supplierDAO.count();
    }
}
