package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.RefundEntity;
import lk.ijse.gdse65.AAD_Course_Work.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/refund")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Refund {
    private final RefundService refundService;

    @GetMapping("/health")
    public String healthTest(){
        return "Refund Health Test AAD course work";
    }


    @PostMapping("/refunds")
    public ResponseEntity<?> createRefund(@RequestBody RefundDTO refundDTO) {
        try {
            RefundEntity createdRefund = refundService.processRefund(refundDTO);
            return ResponseEntity.ok(createdRefund);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Refund processing failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
        }
    }

}
