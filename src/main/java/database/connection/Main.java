package database.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBconnection.getConnection();
        if (!connection.isClosed()) {
            System.out.println("Connection is established");
        }
        CRUD crud = new CRUD(connection);
        crud.addEmployee(new Employee.Builder()
                .setName("Alex")
                .setAddress("Lviv")
                .setSalary(1000)
                .setPosition("Developer")
                .build());
        crud.updateEmployee(new Employee.Builder()
                .setId(1)
                .setName("Tom")
                .setAddress("Kyiv")
                .setSalary(8000)
                .setPosition("Manager")
                .build());
        crud.deleteEmployee(6);
        crud.getAllEmployees("SELECT * FROM employee").forEach(System.out::println);
        System.out.println("Employees with salary more than 1000 :");
        crud.getEmployeesWithSalaryMoreThan1000().forEach(System.out::println);
        System.out.println("Employees with salary more than 1000 and sorted by name :");
        crud.getEmployeesWithSalaryMoreThan1000SortedByName().forEach(System.out::println);
        CreateTable createTable = new CreateTable(connection);
        createTable.SQL_CREATE_TABLE_PRODUCTS();
        createTable.SQL_CREATE_TABLE_PRODUCTCATEGORIES();
        createTable.SQL_CREATE_TABLE_SHOP();
        createTable.SQL_CREATE_TABLE_OWNER();
        crud.closeConnection();
        if (connection.isClosed()) {
            System.out.println("Connection is closed");
        }
    }
}
