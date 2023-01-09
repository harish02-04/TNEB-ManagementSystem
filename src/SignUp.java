import java.util.*;
import java.sql.*;

public class SignUp {
    String un;
    //variable "password" encapsulated for security purpose
    private String password;
    String auth;
    //constructor to call get_details()
    SignUp(Scanner sc) throws SQLException {
        get_details(sc);
    }
    //method to get the username and password from user
    private void get_details(Scanner sc){
        try{
        System.out.println("Enter the details");
        System.out.print("UserName:");
        String username = sc.nextLine();
        System.out.print("Password:");
        this.password = sc.nextLine();
        /*Console cs=System.console();
        if(cs==null){
        System.out.println("Error");
        return;
        }
        char[] ch=cs.readPassword("Password: ");
        this.password=Arrays.toString(ch);
        */
        this.un=username;
        int check=0;
        //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d=new DatabaseConnection();
            Connection con=d.get_conn();
            String query="select * from details";
            PreparedStatement p=con.prepareStatement(query);
            ResultSet rs=p.executeQuery();
            //the data is accessed one by one in each row of table in the database "tnebdb"
            while(rs.next()){
                String us=rs.getString("username");
                //checking whether the username already exists
                if(Objects.equals(us, username)){
                    check=1;
                    break;
                }
            }
        if(check==1){
            System.out.println("Username already exists....");
        }
        else{
        //insert the data into database
        String query1="insert into details (username,password)"+"values(?,?)";
        PreparedStatement prep=con.prepareStatement(query1);
        prep.setString(1,username);
        prep.setString(2,password);
        prep.execute();
        con.close();
        //after creating new username,the auth=Success
        this.auth="Success";
    }}
    //to handle exceptions
    catch(Exception ex){
        System.out.println("Error");
        ex.printStackTrace();
    }
}}
