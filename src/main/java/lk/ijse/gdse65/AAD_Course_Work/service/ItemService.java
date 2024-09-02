package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO saveItem(ItemDTO item);
    ItemDTO getSelectedItem(String id);
    boolean deleteItem(String id) throws NotFoundException;
    boolean updateItem(String id,ItemDTO Item)throws NotFoundException;
    List<ItemDTO> getAllItems();
}
