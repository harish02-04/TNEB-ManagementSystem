import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Scanner;

public class PrintBillReceipt {
    int check=0;
    String paystatus;
    //constructor is created to call disp()
    Scanner sc=new Scanner(System.in);
    PrintBillReceipt(String u, String name, String cusno){
        disp(u,name,cusno);
    }
    //this method will print the bill receipt
    void disp(String u,String n,String c){
        try{
            //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d=new DatabaseConnection();
            Connection con=d.get_conn();
            String query="select * from billreceipt";
            PreparedStatement p=con.prepareStatement(query);
            ResultSet rs=p.executeQuery();
            //the data is accessed one by one in each row of table in the database "tnebdb"
            while(rs.next()){
                //checking whether the username,name,customernumber is matched with data in database
                if(Objects.equals(rs.getString("username"), u) && Objects.equals(rs.getString("cusno"), c) && Objects.equals(rs.getString("name"), n)){
                    this.check=1;
                    this.paystatus=rs.getString("paystatus");
                    //printing all details
                    System.out.println("\nTAMILNADU ELECTRICITY BOARD LIMITED");
                    System.out.println("          BILL RECEIPT              ");
                    System.out.println("     Username:"+rs.getString("username"));
                    System.out.println("Name                     :"+rs.getString("name"));
                    System.out.println("CustomerNumber           :"+rs.getString("cusno"));
                    System.out.println("ReceiptNumber            :"+rs.getString("Recno"));
                    System.out.println("BillDate                 :"+rs.getString("billdate"));
                    System.out.println("Units                    :"+rs.getString("units"));
                    System.out.println("ConnectionType           :"+rs.getString("type"));
                    System.out.println("TotalAmount              :Rs."+rs.getString("amount"));
                    System.out.println("PaymentStatus            :"+rs.getString("paystatus"));
                    System.out.println("");
                }
            }
            con.close();
            //if the details doesn't match the check will become 0 or else 1
            if(check==0){

                System.out.println("Invalid details");
            }

        }
        //to handle exceptions
        catch(Exception ex){
            System.out.println("NOT APPLICABLE");
            ex.printStackTrace();
        }
    }
}
