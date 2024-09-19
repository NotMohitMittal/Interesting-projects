package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {
    
    // Database connection details
    private static final String jdbcUrl = "jdbc:mariadb://localhost:3306/BankManagement";
    private static final String username = "root";
    private static final String password = "new_password";

    // Method to insert data into the database
    public void insertStudentData(String name, int salery) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Prepare the SQL insert query
            String insertSQL = "INSERT INTO BankEmployee (name, salery) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);

            // Set the values in the prepared statement
            preparedStatement.setString(1, name); // 1st parameter is name
            preparedStatement.setInt(2, salery);  // 2nd parameter is salery

            // Execute the insert query
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully for " + name);

        } catch (SQLException e) {
            System.out.println("Database connection or query error: " + e.getMessage());
        } finally {
            // Close the preparedStatement and connection
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to check if a person exists in the database
    public boolean doesPersonExist(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean exists = false;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Prepare the SQL select query
            String selectSQL = "SELECT COUNT(*) FROM BankEmployee WHERE name = ?";
            preparedStatement = connection.prepareStatement(selectSQL);

            // Set the value in the prepared statement
            preparedStatement.setString(1, name);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if the person exists
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                exists = (count > 0);
            }

        } catch (SQLException e) {
            System.out.println("Database connection or query error: " + e.getMessage());
        } finally {
            // Close the ResultSet, PreparedStatement, and Connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 

        return exists;
    }
}
