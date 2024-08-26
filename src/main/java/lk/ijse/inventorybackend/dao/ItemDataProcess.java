package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Item;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDataProcess {

    boolean saveItem(Item item) throws SQLException, NamingException;
    ArrayList<Item> getAllItems() throws SQLException, NamingException;
    boolean deleteItem(String id) throws SQLException, NamingException;
    boolean updateItem(Item item) throws SQLException, NamingException;

}
