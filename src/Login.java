import java.util.*;
import java.sql.*;

public class Login {
    String un;
    String auth;
    private String password;
    //constructor to call get_details()
    Login(Scanner sc) throws SQLException {
        get_details(sc);
    }
    //method to get the username and password from user
    void get_details(Scanner sc) {
    try{
        System.out.println("Enter the details");
        System.out.print("UserName:");
        String username = sc.nextLine();
        System.out.print("Password:");
        /*Console cs=System.console();
        if(cs==null){
        System.out.println("Error");
        return;
        }
        char[] ch=cs.readPassword("Password: ");
        this.password=Arrays.toString(ch);
        */
        this.password = sc.nextLine();
        this.un=username;
        //creating connection between java and database "tnebdb" in mysql
        DatabaseConnection d=new DatabaseConnection();
        Connection con=d.get_conn();
        String query="select * from details";
        PreparedStatement p=con.prepareStatement(query);
        ResultSet rs=p.executeQuery();
        //the data is accessed one by one in each row of table in the database "tnebdb"
        while(rs.next()){
            String us=rs.getString("username");
            String ps=rs.getString("password");
            //checking whether the username and password exists in database
            if(Objects.equals(us, username) && Objects.equals(ps, password)){
                this.auth="Success";
                break;
            }
        }
        //if the username exists ,then auth=Success
        if(!Objects.equals(auth, "Success")){
            auth="Failure";
        }
        con.close();
    }
    //to handle exceptions
    catch(Exception ex){
        System.out.println("Error");
    }
}}
