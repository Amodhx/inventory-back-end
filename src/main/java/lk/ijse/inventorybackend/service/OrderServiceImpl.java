package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dao.OrderDataProcess;
import lk.ijse.inventorybackend.dao.OrderDataProcessImpl;
import lk.ijse.inventorybackend.dto.OrderDTO;
import lk.ijse.inventorybackend.entity.Orders;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderServiceImpl implements OrderService{

    OrderDataProcess orderDataProcess = new OrderDataProcessImpl();
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, NamingException {
        return orderDataProcess.saveOrder(new Orders(orderDTO.getId(),orderDTO.getCustomer_id(),orderDTO.getCustomer_name(),orderDTO.getDate(),orderDTO.getAmount(),orderDTO.getType()));
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, NamingException {
        ArrayList<Orders> aLlOrders = orderDataProcess.getALlOrders();
        ArrayList<OrderDTO> arrayList = new ArrayList<>();
        for (int i = 0; i < aLlOrders.size(); i++) {
            arrayList.add(new OrderDTO(aLlOrders.get(i).getId(),aLlOrders.get(i).getCustomer_id(),aLlOrders.get(i).getCustomer_name(),aLlOrders.get(i).getDate(),aLlOrders.get(i).getAmount(),aLlOrders.get(i).getType()));
        }
        return arrayList;
    }
}
