package in.ATM_Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection_Transaction {
    
    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/BankManagementGUI";
    private static final String _user = "root";
    private static final String _password = "new_password";

    public void insertDeposite(String CardNumber, String PinNumber, String transationType, String amountToDeposite, String date) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);
            
            String insertSQL = "Insert into TransactionDetails (Card_Number, Pin_Number, Transaction_Type, Transaction_amount, Transaction_Date) values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(insertSQL);

            statement.setString(1, CardNumber);
            statement.setString(2, PinNumber);
            statement.setString(3, transationType);
            statement.setString(4, amountToDeposite);
            statement.setString(5, date);

            statement.executeUpdate();
        } catch (SQLException except) {
            System.out.println("Database connection of Query Error " + except.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception e) {
                System.out.println("DataBase closing Error " + e.getMessage());
            }
        }
    }

    public void insertDeposite(String CardNumber, String PinNumber, String amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "insert into CustomerBankBalance (Card_Number, Pin_Number, Total_Balance) values (?, ?, ?)";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, CardNumber);
            statement.setString(2, PinNumber);
            statement.setString(3, amount);

            statement.executeUpdate();
        } catch(SQLException exception) {
            System.out.println("Database connection or Query Error: " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception except) {
                System.out.println("Error while closing the resources");
            }
        }
    }

    public String getCustomerBalance(String CardNumber, String PinNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String CustomerBalance = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "select Total_Balance from CustomerBankBalance where Card_Number = ? and Pin_Number = ?";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, CardNumber);
            statement.setString(2, PinNumber);

            result = statement.executeQuery();
            
            if(result.next()) {
                CustomerBalance = result.getString("Total_Balance");
            }
            
        } catch(SQLException exception) {
            System.out.println("Database connection or query error " + exception.getMessage());
        } finally {
            try {
                if(result != null) result.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception except) {
                System.out.println("Error while closing the resources");
            }
        }
        return CustomerBalance;
    }


    public boolean updateBalance(String CardNumber, String PinNumber, String newTransaction, String process) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            int currentBalance = Integer.parseInt(getCustomerBalance(CardNumber, PinNumber));
            String updatedBalance = process.equals("deposite") 
            ? String.valueOf(currentBalance + Integer.parseInt(newTransaction)) : String.valueOf(currentBalance - Integer.parseInt(newTransaction));
            
            if(Integer.parseInt(updatedBalance) < 0 && process.equals("withdraw")) {
                return false;
            }
            
            String SQLQuery = "Update CustomerBankBalance set Total_Balance = ? where Card_Number = ? and Pin_Number = ?";

            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, updatedBalance);
            statement.setString(2, CardNumber);
            statement.setString(3, PinNumber);

            statement.executeUpdate();
        } catch(SQLException except) {
            System.out.println("Database connection or Query Error " + except.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                System.out.println("Error while closing Resources " + e.getMessage());
            }
        }
        return true;
    }

    public boolean matchPassword(String CardNumber, String passwordToCheck) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "select Pin_Number from Login where Card_Number = ?";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, CardNumber);

            result = statement.executeQuery();

            if(result.next()) {
                if(passwordToCheck.equals(result.getString("Pin_Number"))) {
                    return true;
                }
            }
        } catch(SQLException exception) {
            System.out.println("Database connectivity or Query Error " + exception.getMessage());
        } finally {
            try {
                if(result != null) result.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception except) {
                System.out.println("Error while clsing the resources " + except.getMessage());
            }
        }
        return false;
    }

    public void changePassword(String CardNumber, String PinNumber, String newPinNumber) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "update Login set Pin_Number = ? where Card_Number = ? and Pin_Number = ?";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, newPinNumber);
            statement.setString(2, CardNumber);
            statement.setString(3, PinNumber);

            statement.executeUpdate();
        } catch(SQLException exception) {
            System.out.println("Database connection of Query Error: " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (Exception e) {
                System.out.println("Error while Closing the Resources" + e.getMessage());
            }
        }
    }
    
}
