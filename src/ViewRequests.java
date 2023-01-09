import javax.swing.text.View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class ViewRequests {
    //constructor to call get_tot(),view_req()
    ViewRequests(String us){
        get_tot(us);
        view_req(us);
    }
    void view_req(String us){
        try {
            //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d = new DatabaseConnection();
            Connection con = d.get_conn();
            String query = "select * from request";
            PreparedStatement p = con.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            int count = 0;
            //the data is accessed one by one in each row of table in the database "tnebdb"
            while (rs.next()) {
                //checking whether the username,name,customernumber is matched with data in database
                if (Objects.equals(rs.getString("username"), us)) {
                    count += 1;
                    System.out.println("REQUEST:" + count);
                    System.out.println("Name                    :" + rs.getString("name"));
                    System.out.println("Address                 :" + rs.getString("address"));
                    System.out.println("Type                    :" + rs.getString("tartype"));
                    System.out.println("Status                  :" + rs.getString("status") + "\n");
                }
            }
            con.close();
        }
        catch(Exception ex){
            System.out.println("NOT APPLICABLE");
        }}
    void get_tot(String us) {
        int count = 0;
        try {
            DatabaseConnection d = new DatabaseConnection();
            Connection con = d.get_conn();
            String query = "select * from request";
            PreparedStatement p = con.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            //the data is accessed one by one in each row of table in the database "tnebdb"
            while (rs.next()) {
                if (Objects.equals(rs.getString("username"), us)) {
                    //counting number of requests
                    count += 1;
                }

            }
            con.close();
        }
        //to handle exceptions
        catch (Exception ex) {
            System.out.println("NOT APPLICABLE");
        }
        System.out.println("NumberOfRequests:" + count+"\n");
    }
}
