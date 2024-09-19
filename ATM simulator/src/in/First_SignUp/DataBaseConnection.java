package in.First_SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;


public class DataBaseConnection {

    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/BankManagementGUI";
    private static final String _userName = "root";
    private static final String _password = "new_password";
    
    
    public void insertCustomerData(String FormNumber, String name, String fathersName, String DateOfBirth, String gender, String email, String maritalStatus, String address, String city, String state, String pinCode) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _userName, _password);
            

            String insertSQL = "INSERT INTO BankCustomers (Form_Number, Customer_Name, Father_Name, DateOfBirth, Gender, EmailAddress, MaritalStatus, Address, City, State, PinCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(insertSQL);

            statement.setString(1, FormNumber);
            statement.setString(2, name);
            statement.setString(3, fathersName);
            statement.setString(4, DateOfBirth);
            statement.setString(5, gender);
            statement.setString(6, email);
            statement.setString(7, maritalStatus);
            statement.setString(8, address);
            statement.setString(9, city);
            statement.setString(10, state);
            statement.setString(11, pinCode);
            

            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Database Connection or Query Error " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception except) {
                System.out.println("Error closing the resources " + except.getMessage());
            }
        }
    }
}
