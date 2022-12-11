package database.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static  String URL = "jdbc:mysql://localhost:3306/shop";
    private static  String USERNAME = "ihorben";
    private static  String PASSWORD = "ihorben";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        }
        catch (SQLException e){
            System.err.println("Connection failed");
        }
        return connection;
    }
}
