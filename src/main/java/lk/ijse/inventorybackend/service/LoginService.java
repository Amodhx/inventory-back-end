package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dto.UserDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginService {
    ArrayList<UserDTO> getAllUsers() throws SQLException, NamingException;
}
