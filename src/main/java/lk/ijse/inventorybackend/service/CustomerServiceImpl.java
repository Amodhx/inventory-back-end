package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dao.CustomerDataProcess;
import lk.ijse.inventorybackend.dao.CustomerDataProcessImpl;
import lk.ijse.inventorybackend.dto.CustomerDTO;
import lk.ijse.inventorybackend.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService{

    CustomerDataProcess customerDataProcess = new CustomerDataProcessImpl();
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, NamingException {
        ArrayList<Customer> allCustomers = customerDataProcess.getAllCustomers();
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        for (int i = 0; i < allCustomers.size(); i++) {
            arrayList.add(new CustomerDTO(allCustomers.get(i).getId(),allCustomers.get(i).getName(),allCustomers.get(i).getAddress(),allCustomers.get(i).getContact_number(),allCustomers.get(i).getDate()));
        }
        return arrayList;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDataProcess.saveCustomer(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getContact_number(),customerDTO.getDate()));
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException, NamingException {
        return customerDataProcess.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDataProcess.updateCustomer(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getContact_number(), customerDTO.getDate()));
    }
}
