package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private String order_no;
    private String employeeId;
    private String customer_code;
    private Date purchase_date;
    private String payment_method;
    private double added_points;
    private double netTotal;
    private EmployeeDTO cashier;
    private CustomerDTO customer;
    private List<SaleInventoryDTO> saleInventoryDetails;
}
