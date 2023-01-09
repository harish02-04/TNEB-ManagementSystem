import java.sql.*;
import java.util.Objects;
public class CalculateBill {
    int unit;
    String type;
    int amount;
    //constructor is created to call get_type(),cal_bill(),enter_data()
    CalculateBill(String username,String name,String cusno){
        get_type(username,name,cusno);
        cal_bill(unit,type);
        enter_data(amount,username,cusno);
    }
    //this method is used to get the type of connection domestic or commercial
    void get_type(String user,String n,String c){

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
                if(Objects.equals(rs.getString("username"), user) && Objects.equals(rs.getString("cusno"), c) && Objects.equals(rs.getString("name"), n)){
                    this.type=rs.getString("type");
                    this.unit=Integer.parseInt(rs.getString("units"));
                }
            }
        con.close();
        }
        //to handle exceptions
        catch(Exception ex){
            System.out.println("Error");
        }
    }
    //method to calculate the bill amount as per given creteria
    void cal_bill(int u,String t){
        int a=0;
        if(Objects.equals(t, "Domestic")){
            if(u<=100){
                a=(u-50)*2;
            }
            else if(u<150){
                a=(50*2) + ((u-100)*3);
            }
            else if(u<=300){
                a=(50*2) + (49*3) + ((u-149)*4);
            }
            else if(u<400){
                a=(50*2) + (49*3) +(151*4) +((u-300)*5);
            }
            else if(u>=400){
                a=(50*2) + (49*3) +(151*4) +(99*5)+((u-399)*6);
            }

        }
        else if(Objects.equals(t, "Commercial")){
            if(u<=100){
                a=(u-20)*4;
            }
            else if(u<=200){
                a=(80*4) + ((u-100)*6);
            }
            else if(u<300){
                a=(80*4) + (100*6) + ((u-200)*7);
            }
            else if(u>=300){
                a=(80*4) + (100*6) +((u-299)*8);
            }
        }
        this.amount=a;
    }
    //method to enter the amount into the database
    void enter_data(int a,String u,String c){
        try{
            //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d=new DatabaseConnection();
            Connection con=d.get_conn();
            String query="update billreceipt set amount=? where cusno=?";
            PreparedStatement ps=con.prepareStatement(query);
            String am=Integer.toString(a);
            ps.setString(1,am);
            ps.setString(2,c);
            ps.executeUpdate();
            con.close();
        }
        //to handle exceptions
        catch(Exception ex){
            System.out.println("NOT APPLICABLE");
            ex.printStackTrace();
        }
    }
}
