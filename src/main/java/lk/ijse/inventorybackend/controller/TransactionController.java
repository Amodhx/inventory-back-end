package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.db.DBConnection;
import lk.ijse.inventorybackend.dto.OrderDTO;
import lk.ijse.inventorybackend.dto.Order_detailDTO;
import lk.ijse.inventorybackend.service.OrderDetailService;
import lk.ijse.inventorybackend.service.OrderDetailServiceImpl;
import lk.ijse.inventorybackend.service.OrderService;
import lk.ijse.inventorybackend.service.OrderServiceImpl;
import lombok.SneakyThrows;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/transaction")
public class TransactionController extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDTO orderDTO = JsonbBuilder.create().fromJson(req.getHeader("obj1"), OrderDTO.class);
        ArrayList<Order_detailDTO> arrayList = JsonbBuilder.create().fromJson(req.getReader(), new ArrayList<Order_detailDTO>() {
        }.getClass().getGenericSuperclass());


        try ( var Writer= resp.getWriter()){
            Connection connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (orderService.saveOrder(orderDTO)) {
                for (int i = 0; i < arrayList.size(); i++) {
                    orderDetailService.saveOrderDetail(arrayList.get(i));
                }
                connection.commit();
            }

            connection.close();
            Writer.write("ORDER PLACED SUCCESSFULLY !!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {

            e.printStackTrace();
        }


    }
}
