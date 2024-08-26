package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.dto.OrderDTO;
import lk.ijse.inventorybackend.service.OrderService;
import lk.ijse.inventorybackend.service.OrderServiceImpl;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDTO orderDTO = JsonbBuilder.create().fromJson(req.getReader(), OrderDTO.class);
        try(var writer = resp.getWriter()) {
            boolean b = orderService.saveOrder(orderDTO);
            if (b){
                writer.write("Order Saved");
            }else {
                writer.write("Cant save Order");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()){
            ArrayList<OrderDTO> allOrders = orderService.getAllOrders();
            JsonbBuilder.create().toJson(allOrders,writer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
