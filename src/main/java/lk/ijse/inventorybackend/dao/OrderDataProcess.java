package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Orders;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDataProcess {
    boolean saveOrder(Orders orders) throws SQLException, NamingException;
    ArrayList<Orders> getALlOrders() throws SQLException, NamingException;
}
