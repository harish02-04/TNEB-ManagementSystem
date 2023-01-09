import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Scanner;

public class Payment extends JFrame {
    String name;
    String cusno;
    String check2;
    Scanner sc=new Scanner(System.in);
    Payment(String username) {
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        System.out.println("Enter the details");
        System.out.print("Name          : ");
        this.name=sc.nextLine();
        System.out.print("CustomerNumber: ");
        this.cusno=sc.nextLine();
        CalculateBill c1=new CalculateBill(username,name,cusno);
        PrintBillReceipt p1=new PrintBillReceipt(username,name,cusno);
        if(Objects.equals(p1.paystatus, "not paid")){
            System.out.println("        AMOUNT TO BE PAID:"+c1.amount+"           ");
            System.out.print("              Do you want to pay?.....");
            this.check2=sc.nextLine();
        }
        else if(Objects.equals(p1.paystatus, "paid")){
            System.out.println("         You have already paid your bill!!      ");
        }
        if(p1.check==1 && Objects.equals(check2, "yes")) {
            System.out.println("          PAYMENT OPTIONS         ");
            System.out.println("1.Debit Card\n2.Credit Card\n3.UPI\n4.Net Banking\n");
            System.out.print("Your choise:");
            int choise=Integer.parseInt(sc.nextLine());
            System.out.println("Loading.....directing into payment gateway...\n");
        try {
            //For example:redirecting into paytm using JEditorPane
            j.setPage("https://paytm.com/electricity-bill-payment");
            System.out.println("Successfully paid");
            mark_paid(username, name, cusno);
        } catch (Exception ex) {
            j.setContentType("text/html");
            j.setText("<html>could not load</html>");
        }
        JScrollPane scroolPane = new JScrollPane(j);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scroolPane);
        setPreferredSize(new Dimension(800, 600));
        setSize(800, 800);
        setLocation(250, 120);
        setVisible(true);
        System.out.println("Successfully paid");
        mark_paid(username, name, cusno);
    }}

    void mark_paid(String u, String n, String c) {
        try {
            //creating connection between java and database "tnebdb" in mysql
            DatabaseConnection d=new DatabaseConnection();
            Connection con=d.get_conn();
            String query = "select * from billreceipt";
            PreparedStatement p = con.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            //the data is accessed one by one in each row of table in the database "tnebdb"
            while (rs.next()) {
                if (Objects.equals(rs.getString("username"), u) && Objects.equals(rs.getString("cusno"), c) && Objects.equals(rs.getString("name"), n)) {
                    String qury = "update billreceipt set paystatus=? where cusno=?";
                    PreparedStatement ps = con.prepareStatement(qury);
                    ps.setString(1, "paid");
                    ps.setString(2, c);
                    ps.executeUpdate();
                }

            }
            con.close();
        } catch (Exception ex) {
            System.out.println("NOT APPLICABLE");
        }

    }}
