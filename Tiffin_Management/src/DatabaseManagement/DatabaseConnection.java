package DatabaseManagement;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DatabaseConnection {

    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/TiffinService";
    private static final String _user = "root";
    private static final String _password = "new_password";

    public void insertIntoDatabase(String reason, String time, String date, int amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);
            
            String SQLQuery = "insert into MealLeave (Reason, Time, Date, Amount) values (?, ?, ?, ?)";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, reason);
            statement.setString(2, time);
            statement.setString(3, date);
            statement.setInt(4, amount);

            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Database Connection or Query error " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception e) {
                System.out.println("Error while closing the resources " + e.getMessage());
            }
        }
    }

    public int getTotalCost() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int totalSum = 0;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "select sum(Amount) as Total_sum from MealLeave";

            statement = connection.prepareStatement(SQLQuery);

            result = statement.executeQuery();
            
            if(result.next()) {
                totalSum = result.getInt("Total_sum");
            }

        } catch(SQLException exception) {
            System.out.println("Database Connection or Query Error " + exception.getMessage());
        } finally {
            try {
                if(result != null) result.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                System.out.println("Error while closing Resource " + e.getMessage());
            }
        }
        return totalSum;
    }
}
    