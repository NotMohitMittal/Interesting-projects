package in.Third_SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseConnector_Three {

    private static final String _JdbcUrl = "jdbc:mariadb://localhost:3306/BankManagementGUI";
    private static final String _userName = "root";
    private static final String _password = "new_password";

    public void insertAccountDetails(String FormNumber, String accountType, String cardNumber, String pinNumber, String userServies) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_JdbcUrl, _userName, _password);
            
            String insertSQL = "INSERT INTO AccountDetails (Form_Number, Account_Type, Card_Number, Pin_Number, User_services) values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(insertSQL);
            
            statement.setString(1, FormNumber);
            statement.setString(2, accountType);
            statement.setString(3, cardNumber);
            statement.setString(4, pinNumber);
            statement.setString(5, userServies);
            
            statement.executeUpdate();
            
        } catch(SQLException except) {
            System.out.println("Database connection or Query Error " + except.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception except) {
                System.out.println("Error closing the resources");
            }
        }
    }
    
    public void insertCardDetails(String formNumber, String cardNumber, String pinNumber) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection(_JdbcUrl, _userName, _password);

            String insertSQL = "insert into Login (Form_Number, Card_Number, Pin_Number) values (?, ?, ?)";
            statement = connection.prepareStatement(insertSQL);

            statement.setString(1, formNumber);
            statement.setString(2, cardNumber);
            statement.setString(3, pinNumber);

            statement.executeUpdate();
        } catch(SQLException exception) {
            System.out.println("Database connection or Query Error: " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception except) {
                except.getMessage();
            }
        }
    }
}
