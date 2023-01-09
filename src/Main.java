import java.sql.*;
import java.util.*;


//main program
public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc=new Scanner(System.in);
        System.out.println("TAMILNADU ELECTRICITY BOARD LIMITED");
        int status=0;
        String username="";
        int in;
        //creating a menu_driven approach
        while(true){
        if(status==0){
        //Menu is shown below
        System.out.println("1.login or 2.signup or 3.exit");
        //getting the choise from user
        in=Integer.parseInt(sc.nextLine());
        //1.Login (ie) existing user
        if(in==1){
            //instantiating the object for ExistingUser
            Login ex=new Login(sc);
            //if the user successfully signed up,the status will become 1
            if(Objects.equals(ex.auth, "Success")){
                System.out.println("Successfully logged in.....");
                username=ex.un;
                status=1;
            }
            else{
                System.out.println("Invalid username or password,kindly log in again....");
            }
        }
        //1.Signup (ie) New user
        else if(in==2){
            //instantiating the object for NewUser
            SignUp ns=new SignUp(sc);
            if(Objects.equals(ns.auth, "Success")){
            System.out.println("New Account is created,kindly login again......");
            Login ne=new Login(sc);
            //if the user successfully logged in ,the status will become 1
            if(Objects.equals(ne.auth, "Success")){
                System.out.println("Successfully logged in.....");
                username=ne.un;
                status=1;
            }}
        }
        //3.Exit , the program gets terminated using System.exit()
        else if(in==3){
            System.exit(0);
        }}
        // if the status is 1 (ie) successfully logged in or signed up,then another menu will be shown
        if(status==1){
            while(true){
                //the menu after log in or sign up.....
                System.out.println("1.RequestNewConnection or 2.BillReceipt or 3.Payment or 4.ViewRequestsStatus or 5.Exit");
                in=Integer.parseInt(sc.nextLine());
                if(in==1){
                    RequestEBConnection r1=new RequestEBConnection(username);
                }
                //2.Print the bill receipt
                else if(in==2){
                    System.out.println("Enter the details");
                    System.out.print("Name          : ");
                    String name=sc.nextLine();
                    System.out.print("CustomerNumber: ");
                    String cusno=sc.nextLine();
                    //the object is created for CalculateBill and PrintReceipt with various parameters
                    CalculateBill c1=new CalculateBill(username,name,cusno);
                    PrintBillReceipt p1=new PrintBillReceipt(username,name,cusno);
                }
                //3.Redirecting to payment gateway
                else if(in==3){
                        new Payment(username).setVisible(true);

                }
                //4.Exit , the program gets terminated using System.exit()
                else if(in==4){
                    ViewRequests v1=new ViewRequests(username);
                }

                else if(in==5){
                    System.exit(0);
                }
            }
        }

    }


    }

    }