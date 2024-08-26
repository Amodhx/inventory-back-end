package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDataProcess {
    ArrayList<Customer> getAllCustomers() throws SQLException, NamingException;
    boolean saveCustomer(Customer customer) throws SQLException, NamingException;
    boolean deleteCustomer(int id) throws SQLException, NamingException;
    boolean updateCustomer(Customer customer) throws SQLException, NamingException;
}
