package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginDataProcess {
    ArrayList<User> getAllUsers() throws SQLException, NamingException;
}
