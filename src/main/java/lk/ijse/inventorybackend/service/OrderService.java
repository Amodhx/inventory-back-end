package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dto.OrderDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderService {
    boolean saveOrder(OrderDTO orderDTO) throws SQLException, NamingException;
    ArrayList<OrderDTO> getAllOrders() throws SQLException, NamingException;
}
