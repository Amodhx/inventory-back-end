package lk.ijse.inventorybackend.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    static DBConnection dbConnection ;
    Connection connection;
    private DBConnection() throws NamingException, SQLException {
        InitialContext ctx = new InitialContext();
        DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/itemTesting");
        this.connection = pool.getConnection();
    }
    public static DBConnection getInstance() throws SQLException, NamingException {
        return dbConnection==null ? dbConnection=new DBConnection() : dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}

