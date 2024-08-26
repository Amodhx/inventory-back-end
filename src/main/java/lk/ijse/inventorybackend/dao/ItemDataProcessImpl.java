package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Item;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDataProcessImpl implements ItemDataProcess {


    String SAVE_ITEM = "INSERT INTO ITEM VALUES(?,?,?,?,?,?,?)";
    String GET_ALL = "SELECT * FROM ITEM";
    String DELETE_ITEM  = "DELETE FROM ITEM WHERE ID=?";
    String UPDATE_ITEM = "UPDATE ITEM SET product_name = ? , buy_price = ? , sel_price = ? , expire_date = ? ,qty = ? ,brand = ? WHERE ID = ?";
    @Override
    public boolean saveItem(Item item) throws SQLException, NamingException {
        return SQLUtil.databaseConnect(SAVE_ITEM, item.getId(), item.getProduct_name(),item.getBuy_price(),item.getSel_price(),item.getExpire_date(),item.getQty(),item.getBrand());
    }

    @Override
    public ArrayList<Item> getAllItems() throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.databaseConnect(GET_ALL);
        ArrayList<Item> arrayList =  new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Item(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
        }
        return arrayList;
    }



    @Override
    public boolean deleteItem(String id) throws SQLException, NamingException {
        boolean b = SQLUtil.databaseConnect(DELETE_ITEM,id);
        return b;
    }

    @Override
    public boolean updateItem(Item item) throws SQLException, NamingException {
       boolean b = SQLUtil.databaseConnect(UPDATE_ITEM,item.getProduct_name(),item.getBuy_price(),item.getSel_price(),item.getExpire_date(),item.getQty(),item.getBrand(),item.getId());
        return b;
    }
}
