package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleInventoryDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.SaleInventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleInventoryDAO extends JpaRepository<SaleInventoryDetails, String> {

}
