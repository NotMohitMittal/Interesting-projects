package in.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection_Login {

    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/BankManagementGUI";
    private static final String _user = "root";
    private static final String _password = "new_password";

    public boolean readFromDB(String cardNumber, String pinNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null; // to store the output from the DB

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String insertSQL = "select * from Login where Card_Number = ? and Pin_Number = ?";
            statement = connection.prepareStatement(insertSQL);

            statement.setString(1, cardNumber);
            statement.setString(2, pinNumber);

            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("Database connection or Query Error");
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception except) {
                except.getMessage();
            }
        }

        return false;
    }
    
}
