package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dto.Order_detailDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailService {
    boolean saveOrderDetail(Order_detailDTO orderDetailDTO) throws SQLException, NamingException;

}
