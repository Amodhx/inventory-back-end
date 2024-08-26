package lk.ijse.inventorybackend.service;

import lk.ijse.inventorybackend.dao.LoginDataProcess;
import lk.ijse.inventorybackend.dao.LoginDataProcessImpl;
import lk.ijse.inventorybackend.dto.UserDTO;
import lk.ijse.inventorybackend.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServiceImpl implements LoginService{

    LoginDataProcess loginDataProcess = new LoginDataProcessImpl();
    @Override
    public ArrayList<UserDTO> getAllUsers() throws SQLException, NamingException {
        ArrayList<User> allUsers = loginDataProcess.getAllUsers();
        ArrayList<UserDTO> arrayList = new ArrayList<>();
        for (User u : allUsers){
            arrayList.add(new UserDTO(u.getId(),u.getUser_name(), u.getPassword()));
        }
        return arrayList;
    }
}
