import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dataBaseConnection {
        Connection c;
        Statement s;

        dataBaseConnection() {
            try {
                
                c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root", "Hello");
                s = c.createStatement();
            } catch(Exception e) {
                System.out.println(e);
            }
        }
  
}
