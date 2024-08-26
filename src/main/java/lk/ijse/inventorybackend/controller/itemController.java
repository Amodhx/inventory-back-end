package lk.ijse.inventorybackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.inventorybackend.dto.ItemDTO;
import lk.ijse.inventorybackend.service.ItemService;
import lk.ijse.inventorybackend.service.ItemServiceImpl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/item")
public class itemController extends HttpServlet {
    ItemService itemService = new ItemServiceImpl();


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDTO itemDTO = JsonbBuilder.create().fromJson(req.getReader(), ItemDTO.class);
        try(var writer = resp.getWriter()) {
            if (itemService.updateItem(itemDTO)) {
                writer.write("Item Values Updated");
            }else {
                writer.write("Cant update Item Values");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (var writer = resp.getWriter()){
            ArrayList<ItemDTO> allItems = itemService.getAllItems();
            JsonbBuilder.create().toJson(allItems,writer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null){
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        String id = JsonbBuilder.create().fromJson(req.getReader(), String.class);
        try (var writer = resp.getWriter()){
            if (itemService.deleteItem(id)) {
                writer.write("Item Deleted");
            }else {
                writer.write("Cant delete item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null){
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        BufferedReader reader = req.getReader();
        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO itemDTO = jsonb.fromJson(reader, ItemDTO.class);

        try(Writer writer =resp.getWriter()) {
            boolean b = itemService.saveItem(itemDTO);
            if (b){
                writer.write("Saved");
            }else {
                writer.write("Unsaved");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
