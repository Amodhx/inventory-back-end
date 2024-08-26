package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDataProcessImpl implements CustomerDataProcess{

    String CUSTOMER_SAVE = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?)";
    String GET_ALL_CUSTOMER = "SELECT * FROM CUSTOMER";
    String DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE id = ?";
    String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET name=?, address =? , contact_number =? WHERE ID=?";
    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException, NamingException {
        ResultSet resultSet = SQLUtil.databaseConnect(GET_ALL_CUSTOMER);
        ArrayList<Customer> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Customer((Integer) resultSet.getObject(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, NamingException {
        boolean o = SQLUtil.databaseConnect(CUSTOMER_SAVE, customer.getId(), customer.getName(), customer.getAddress(), customer.getContact_number(),customer.getDate());
        return o;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException, NamingException {
        boolean b = SQLUtil.databaseConnect(DELETE_CUSTOMER,id);
        return b;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, NamingException {
       boolean b =  SQLUtil.databaseConnect(UPDATE_CUSTOMER,customer.getName(),customer.getAddress(),customer.getAddress(),customer.getId());
        return b;
    }

}
