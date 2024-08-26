package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dto.CustomerDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, NamingException;
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;
    boolean deleteCustomer(int id) throws SQLException, NamingException;
    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;
}
