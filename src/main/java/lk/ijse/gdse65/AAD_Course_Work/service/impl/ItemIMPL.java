package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.ItemDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.ItemEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.ItemDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.ItemService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemIMPL implements ItemService {
    private final ItemDAO itemDAO;
    private final Mapping mapping;
    @Override
    public ItemDTO saveItem(ItemDTO item) {
       item.setItem_code(UUID.randomUUID().toString());
       return mapping.toItemDTO(itemDAO.save(mapping.toItemEntity(item)));
    }

    @Override
    public ItemDTO getSelectedItem(String id) {
        return null;
    }

    @Override
    public boolean deleteItem(String id) throws NotFoundException {
        Optional<ItemEntity> item = itemDAO.findById(id);
        if (item.isPresent()) {
            itemDAO.deleteById(id);
            return true;
        }else{
            throw new NotFoundException(id+" not found (:");
        }
    }

    @Override
    public boolean updateItem(String id, ItemDTO itemDTO) throws NotFoundException {
        Optional<ItemEntity> optionalItem = itemDAO.findById(id);
        if (optionalItem.isPresent()) {
            ItemEntity item = optionalItem.get();
            item.setItem_name(itemDTO.getItem_name());
            item.setItem_description(itemDTO.getItem_description());
//            item.setItem_price(itemDTO.getItem_price());
//            item.setItem_qty(itemDTO.getItem_qty());

            itemDAO.save(item);

            return true;
        } else {
            throw new NotFoundException(id + " not found :(");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.toItemDTOList(itemDAO.findAll());
    }
}
