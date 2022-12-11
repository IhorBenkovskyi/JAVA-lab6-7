package database.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import comparator.EmployeeComparator;

public class CRUD {
    private Connection connection;

    public CRUD(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public List<Employee> getAllEmployees(String sql) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = DBconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Employee employee = new Employee.Builder()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setAddress(resultSet.getString("address"))
                        .setSalary(resultSet.getInt("salary"))
                        .setPosition(resultSet.getString("position"))
                        .build();
                employees.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (name, address, salary, position) VALUES (?, ?, ?, ?)";
        try(Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setInt(3, employee.getSalary());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET name = ?, address = ?, salary = ?, position = ? WHERE id = ?";
        try(Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setInt(3, employee.getSalary());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id = ?";
        try(Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Employees with salary more than 1000
    public List<Employee> getEmployeesWithSalaryMoreThan1000() throws SQLException {
        String sql = "SELECT * FROM employee WHERE salary > 1000";
        return getAllEmployees(sql);
    }

    //Employees with salary more than 1000 and sorted by name
    public List<Employee> getEmployeesWithSalaryMoreThan1000SortedByName() throws SQLException {
        String sql = "SELECT * FROM employee WHERE salary > 1000 ORDER BY name";
        return getAllEmployees(sql);
    }
}
