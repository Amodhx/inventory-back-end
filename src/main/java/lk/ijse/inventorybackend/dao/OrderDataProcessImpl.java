package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.db.DBConnection;
import lk.ijse.inventorybackend.entity.Orders;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDataProcessImpl implements OrderDataProcess{

    String SAVE_ORDER = "INSERT INTO ORDERS VALUES(?,?,?,?,?,?)";
    String GET_ALL_ORDERS = "SELECT * FROM ORDERS";
    @Override
    public boolean saveOrder(Orders orders) throws SQLException, NamingException {

        boolean b = SQLUtil.databaseConnect(SAVE_ORDER,orders.getId(),orders.getCustomer_id(),orders.getCustomer_name(),orders.getDate(),orders.getAmount(),orders.getType());

        return b;
    }

    @Override
    public ArrayList<Orders> getALlOrders() throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.databaseConnect(GET_ALL_ORDERS);
        ArrayList<Orders> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Orders(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return arrayList;
    }
}
