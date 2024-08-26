package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dao.OrderDataProcess;
import lk.ijse.inventorybackend.dao.OrderDataProcessImpl;
import lk.ijse.inventorybackend.dao.OrderDetailDataProcess;
import lk.ijse.inventorybackend.dao.OrderDetailDataProcessImpl;
import lk.ijse.inventorybackend.dto.Order_detailDTO;
import lk.ijse.inventorybackend.entity.Order_detail;
import lk.ijse.inventorybackend.entity.Orders;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailServiceImpl implements OrderDetailService{

    OrderDetailDataProcess orderDetailDataProcess = new OrderDetailDataProcessImpl();
    OrderDataProcess orderDataProcess = new OrderDataProcessImpl();

    @Override
    public boolean saveOrderDetail(Order_detailDTO orderDetailDTO) throws SQLException, NamingException {
        ArrayList<Orders> aLlOrders = orderDataProcess.getALlOrders();
        return orderDetailDataProcess.saveOrderDetail(new Order_detail(orderDetailDTO.getOrder_id(),orderDetailDTO.getItem_id()));
    }
}
