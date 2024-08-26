package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.db.DBConnection;
import lk.ijse.inventorybackend.dto.Order_detailDTO;
import lk.ijse.inventorybackend.service.OrderDetailService;
import lk.ijse.inventorybackend.service.OrderDetailServiceImpl;
import lombok.SneakyThrows;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/orderDetail")
public class OrderDetailController extends HttpServlet {

    OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {Order_detailDTO orderDetailDTO = JsonbBuilder.create().fromJson(req.getReader(), Order_detailDTO.class);
        try (var writer = resp.getWriter()){
            boolean b = orderDetailService.saveOrderDetail(orderDetailDTO);
            if (b){
                writer.write("Saved");
            }else {
                writer.write("Cant save OrderDetail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
