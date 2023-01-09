import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Scanner;

public class RequestEBConnection {

    //constructor to call get_details()
    RequestEBConnection(String username){
        get_details(username);
    }
    //method to get details from user for request connection
    void get_details(String us){
        String st1,st2,st3,st4;
        Scanner sc=new Scanner(System.in);
        System.out.println("            APPLICATION FOR REQUESTING CONNECTION            ");
        System.out.println("                      Username:"+us+"                        ");
        System.out.print("Name                                        :");
        String name=sc.nextLine();
        System.out.print("Address                                     :");
        String add=sc.nextLine();
        System.out.print("PhoneNumber                                 :");
        String ph=sc.nextLine();
        System.out.print("AdhaarNo                                    :");
        String adh=sc.nextLine();
        System.out.print("Email                                       :");
        String em=sc.nextLine();
        System.out.print("PAN Number                                  :");
        String pan=sc.nextLine();
        System.out.print("Ownership                                   :");
        String own=sc.nextLine();
        System.out.print("CommunicationAddress                        :");
        String comm=sc.nextLine();
        System.out.print("Is communication and supply address same?   :");
        String check=sc.nextLine();
        String supp;
        if(Objects.equals(check, "yes")){
            supp=comm;
        }
        else{
        System.out.print("SupplyAddress                               :");
            supp=sc.nextLine();
        }
        System.out.print("TariffType(Domestic/Commercial)             :");
        String ta=sc.nextLine();
        System.out.print("SupplyType                                  :");
        String st=sc.nextLine();
        System.out.print("SubcategoryOfTariff                         :");
        String sub=sc.nextLine();
        System.out.print("GSTNumber(if applicable)                    :");
        String gst=sc.nextLine();
        System.out.println("\nDOCUMENTS REQUIRED\n");
        System.out.println("1.Adhar card");
        System.out.print("Do you want to upload it?");
        String up1=sc.nextLine();
        if(Objects.equals(up1, "yes")){
            st1="uploaded";
            System.out.println("Status:"+st1);
        }
        else{
            st1="NotUploaded";
            System.out.println("Status:"+st1);
        }
        System.out.println("2.Ration card");
        System.out.print("Do you want to upload it?");
        String up2=sc.nextLine();
        if(Objects.equals(up2, "yes")){
            st2="uploaded";
            System.out.println("Status:"+st2);
        }
        else{
            st2="NotUploaded";
            System.out.println("Status:"+st2);
        }
        System.out.println("3.Property Documents");
        System.out.print("Do you want to upload it?");
        String up3=sc.nextLine();
        if(Objects.equals(up3, "yes")){
            st3="uploaded";
            System.out.println("Status:"+st3);
        }
        else{
            st3="NotUploaded";
            System.out.println("Status:"+st3);
        }
        System.out.println("4.Recent Property Tax Receipt");
        System.out.print("Do you want to upload it?");
        String up4=sc.nextLine();
        if(Objects.equals(up4, "yes")){
            st4="uploaded";
            System.out.println("Status:"+st4);
        }
        else{
            st4="NotUploaded";
            System.out.println("Status:"+st4);
        }
        if(Objects.equals(up1, "yes") && Objects.equals(up2, "yes") && Objects.equals(up3, "yes") && Objects.equals(up4, "yes")){
        try{
            //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d=new DatabaseConnection();
            Connection con=d.get_conn();
            String query="insert into request(username,name,address,phone,adharno,pan,email,commadd,suppadd,tartype,supptype,gstno,subcat,oship,ADdoc,RAdoc,PROdoc,TAXdoc)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep=con.prepareStatement(query);
            prep.setString(1,us);
            prep.setString(2,name);
            prep.setString(3,add);
            prep.setString(4,ph);
            prep.setString(5,adh);
            prep.setString(6,pan);
            prep.setString(7,em);
            prep.setString(8,comm);
            prep.setString(9,supp);
            prep.setString(10,ta);
            prep.setString(11,st);
            prep.setString(12,gst);
            prep.setString(13,sub);
            prep.setString(14,own);
            prep.setString(15,st1);
            prep.setString(16,st2);
            prep.setString(17,st3);
            prep.setString(18,st4);
            prep.execute();
            System.out.println("\nYour Request has been initiated successfully......\n");
            con.close();
        }
        //to handle exceptions
        catch(Exception ex){
            System.out.println("Error");
        }}
        else{
            System.out.println("Some Documents are missing....");
            System.out.println("      Register again!!!       ");
        }


    }
}
