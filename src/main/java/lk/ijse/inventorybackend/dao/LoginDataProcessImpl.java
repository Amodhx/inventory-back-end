package lk.ijse.inventorybackend.dao;

import lk.ijse.inventorybackend.entity.User;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.inventorybackend.dao.SQLUtil.databaseConnect;

public class LoginDataProcessImpl implements LoginDataProcess {

    String GET_ALL_USERS ="SELECT * FROM USER";
    @Override
    public ArrayList<User> getAllUsers() throws SQLException, NamingException {
        ResultSet results = SQLUtil.databaseConnect(GET_ALL_USERS);
        ArrayList<User> users= new ArrayList<>();
        while (results.next()){
            users.add(new User(results.getString(1),results.getString(2),results.getString(3)));
        }
        return users;
    }
}
