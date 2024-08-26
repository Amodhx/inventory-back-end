package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dto.ItemDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemService {
    boolean saveItem(ItemDTO itemDTO) throws SQLException, NamingException;
    ArrayList<ItemDTO> getAllItems() throws SQLException,NamingException;
    boolean deleteItem(String id) throws SQLException,NamingException;
    boolean updateItem(ItemDTO itemDTO) throws SQLException, NamingException;
}
