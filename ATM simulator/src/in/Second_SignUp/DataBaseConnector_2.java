package in.Second_SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;


public class DataBaseConnector_2 {
    
    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/BankManagementGUI";
    private static final String _userName = "root";
    private static final String _password = "new_password";

    public void insertAdditionalDetail(String _formNumber, String _userReligion, String _userCategory, 
    String _userIncome, String _userEducation, String _userOccupation, String _userPanNumber, 
    String _userAadharNumber, String _userAgeCategory, String _userOldCustomer) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _userName, _password);

            String insertSQL = "INSERT INTO AdditionalDetails (Form_Number, Religion, Category, Income, Educational_Qualification, Occupation, Pan_Number, Aadhar_Number, Senior_Citizen, Existing_Account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(insertSQL);
            
            statement.setString(1, _formNumber);
            statement.setString(2, _userReligion);
            statement.setString(3, _userCategory);
            statement.setString(4, _userIncome);
            statement.setString(5, _userEducation);
            statement.setString(6, _userOccupation);
            statement.setString(7, _userPanNumber);
            statement.setString(8, _userAadharNumber);
            statement.setString(9, _userAgeCategory);
            statement.setString(10, _userOldCustomer);


            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Database Connection of Query Error " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) statement.close();
            } catch(Exception except) {
                System.out.println("Error closing the resource " + except.getMessage());
            }
        }
    }

}
