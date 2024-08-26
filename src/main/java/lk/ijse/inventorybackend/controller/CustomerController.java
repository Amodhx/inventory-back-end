package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.dto.CustomerDTO;
import lk.ijse.inventorybackend.service.CustomerService;
import lk.ijse.inventorybackend.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer",loadOnStartup = 1)
public class CustomerController extends HttpServlet {

    static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Override
    public void init(ServletConfig config) throws ServletException {

        logger.info("Initializing StudentController with call init method");
    }

    CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null){
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        CustomerDTO customerDTO = JsonbBuilder.create().fromJson(req.getReader(), CustomerDTO.class);
        try (var writer = resp.getWriter()){
            boolean b = customerService.saveCustomer(customerDTO);
            if (b){
                writer.write("Customer Saved");
            }else {
                writer.write("Cant save Customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = JsonbBuilder.create().fromJson(req.getReader(), CustomerDTO.class);
        try (var writer = resp.getWriter()){
            if (customerService.updateCustomer(customerDTO)) {
                writer.write("Customer Updated");
            }else {
                writer.write("Cant Update Customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer i = JsonbBuilder.create().fromJson(req.getReader(), Integer.class);
        try (var writer = resp.getWriter()){
            boolean b = customerService.deleteCustomer(i);
            if (b){
                writer.write("Customer Deleted");
            }else {
                writer.write("Cant Delete Customer");
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
            ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
            JsonbBuilder.create().toJson(allCustomers,writer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
