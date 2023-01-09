import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    Connection get_conn() {
        Connection con = null;
        try {
            //creating connection between java and database "tnebdb" in mysql
            String url = "jdbc:mysql://localhost:3306/tnebdb";
            String useree = "root";
            String pass = "Harish@123";
            con = DriverManager.getConnection(url, useree, pass);

        }
        //to handle exceptions
        catch (Exception ex) {
            System.out.println("Error");
        }
        return con;
    }
}
