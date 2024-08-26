package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Order_detail;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDetailDataProcess {
    boolean saveOrderDetail(Order_detail orderDetail) throws SQLException, NamingException;
}
