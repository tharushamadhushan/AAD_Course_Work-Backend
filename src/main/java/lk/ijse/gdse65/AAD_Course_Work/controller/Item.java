package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.ItemDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Item {

    private final ItemService itemService;
    @GetMapping("/health")
    public String healthCheack(){
        return "Item Ok";
    }

    @PostMapping
    public ItemDTO saveItem(@RequestBody ItemDTO item) {
        return itemService.saveItem(item);
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PreAuthorize("hasAuthority('ROLE ADMIN')")
    @PatchMapping(value = "/{item_code}")
    public boolean updateItem( @RequestBody ItemDTO itemDTO) throws NotFoundException {
        return itemService.updateItem(itemDTO.getItem_code(),itemDTO);
    }

    @PreAuthorize("hasAuthority('ROLE ADMIN')")
    @DeleteMapping(value = "/{item_code}")
    public boolean deleteItem(@PathVariable ("item_code") String id) throws NotFoundException {
        return itemService.deleteItem(id);
    }
}
