package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.SaleEntity;
import lk.ijse.gdse65.AAD_Course_Work.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Sale {
    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO saleDTO) {
        saleService.createSale(saleDTO);
        return ResponseEntity.ok().build();
    }
}


