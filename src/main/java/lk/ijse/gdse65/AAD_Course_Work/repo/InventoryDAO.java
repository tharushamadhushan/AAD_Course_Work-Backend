package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity ,String> {
    @Query("SELECT SUM(i.unit_price_sale * i.item_qty) FROM InventoryEntity i")
    Double findTotalSales();

    @Query("SELECT i FROM InventoryEntity i ORDER BY i.item_qty DESC")
    List<InventoryEntity> findTopSoldItem();

    Optional<InventoryEntity> findById(String item);
}
