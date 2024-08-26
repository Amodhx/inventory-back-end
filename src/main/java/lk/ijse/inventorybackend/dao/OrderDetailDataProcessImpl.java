package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.db.DBConnection;
import lk.ijse.inventorybackend.dto.Order_detailDTO;
import lk.ijse.inventorybackend.entity.Order_detail;
import lk.ijse.inventorybackend.service.OrderDetailService;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailDataProcessImpl implements OrderDetailDataProcess {
    String SAVE_ORDER_DETAIL = "INSERT INTO order_detail VALUES(?,?)";


    @Override
    public boolean saveOrderDetail(Order_detail orderDetail) throws SQLException, NamingException {
        boolean b = SQLUtil.databaseConnect(SAVE_ORDER_DETAIL,orderDetail.getOrder_id(),orderDetail.getItem_id());
        return b;
    }
}
