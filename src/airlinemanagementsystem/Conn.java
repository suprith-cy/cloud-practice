package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;
    
    public Conn() {
        try {
            // Load the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "suprith");
            
            // Create the Statement object
            s = c.createStatement();  // This is where the Statement object is initialized
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
}

