package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dao.ItemDataProcess;
import lk.ijse.inventorybackend.dao.ItemDataProcessImpl;
import lk.ijse.inventorybackend.dto.ItemDTO;
import lk.ijse.inventorybackend.entity.Item;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemServiceImpl implements ItemService{
    ItemDataProcess itemDataProcess = new ItemDataProcessImpl();
    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException {
        Item item = new Item(itemDTO.getId(),itemDTO.getProduct_name(),itemDTO.getBuy_price(),itemDTO.getSel_price(),itemDTO.getExpire_date(),itemDTO.getQty(),itemDTO.getBrand());
        return itemDataProcess.saveItem(item);

    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, NamingException {
        ArrayList<Item> allItems = itemDataProcess.getAllItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item i :allItems){
            list.add(new ItemDTO(i.getId(),i.getProduct_name(),i.getBuy_price(),i.getSel_price(),i.getExpire_date(),i.getQty(),i.getBrand()));
        }
        return list;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, NamingException {
        return itemDataProcess.deleteItem(id);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, NamingException {
        return itemDataProcess.updateItem(new Item(itemDTO.getId(),itemDTO.getProduct_name(),itemDTO.getBuy_price(),itemDTO.getSel_price(),itemDTO.getExpire_date(),itemDTO.getQty(),itemDTO.getBrand()));
    }
}
