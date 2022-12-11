package database.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTable {
    private Connection connection;

    public CreateTable(Connection connection) {
        this.connection = connection;
    }

    public void SQL_CREATE_TABLE_PRODUCTS() throws SQLException {
        String SQL_CREATE_TABLE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL, price INT NOT NULL, quantity INT NOT NULL, PRIMARY KEY (id))";
        connection.createStatement().executeUpdate(SQL_CREATE_TABLE_PRODUCTS);
    }

    public void SQL_CREATE_TABLE_PRODUCTCATEGORIES() throws SQLException {
        String SQL_CREATE_TABLE_PRODUCTCATEGORIES = "CREATE TABLE IF NOT EXISTS productcategories (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL,description VARCHAR(65) NOT NULL ,PRIMARY KEY (id))";
        connection.createStatement().executeUpdate(SQL_CREATE_TABLE_PRODUCTCATEGORIES);
    }

    public void SQL_CREATE_TABLE_SHOP() throws SQLException {
        String SQL_CREATE_TABLE_SHOP = "CREATE TABLE IF NOT EXISTS shop (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL,address VARCHAR(65) NOT NULL , phone INT NOT NULL ,email VARCHAR(65), PRIMARY KEY (id))";
        connection.createStatement().executeUpdate(SQL_CREATE_TABLE_SHOP);
    }

    public void SQL_CREATE_TABLE_OWNER() throws SQLException {
        String SQL_CREATE_TABLE_OWNER = "CREATE TABLE IF NOT EXISTS owner (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL,address VARCHAR(65) NOT NULL , phone INT NOT NULL ,email VARCHAR(65) NOT NULL, shopName VARCHAR(45) NOT NULL, age INT NOT NULL,  PRIMARY KEY (id))";
        connection.createStatement().executeUpdate(SQL_CREATE_TABLE_OWNER);
    }
}
