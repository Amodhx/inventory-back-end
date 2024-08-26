package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.dto.UserDTO;
import lk.ijse.inventorybackend.service.LoginService;
import lk.ijse.inventorybackend.service.LoginServiceImpl;

import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        UserDTO userDTO = JsonbBuilder.create().fromJson(req.getReader(), UserDTO.class);

        try (var writer = resp.getWriter()){
            ArrayList<UserDTO> allUsers = loginService.getAllUsers();
            JsonbBuilder.create().toJson(allUsers,writer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
