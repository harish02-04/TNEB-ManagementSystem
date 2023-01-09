# TNEB Management System
This is a protype of website for TNEB(TAMILNADU ELECTRICITY BOARD) management.

It lets User perform multiple operations like,...

1- User can Create his Personal login for security purposes.

2- User can Request Connection and Calculate their Electricity Bill.

3- User can Pay Electricity Bills.

4- User can Generate Bill.

# About Project

This Java application was created using Intelli J . Additional library was added for the support of JDBC (Required to setup the connection between the Database and Java Application). It contains 9 different classes which works together to create a better user experience .

->Login class

->SignUp class

->Main class

->RequestConnection class

->Payment class

->BillReceipt class

->CalculateBill class

->ViewRequests class

->DatabaseConnection class(JDBC - MySQL)

# Database (My SQL)

Database for this project contains 3 Tables,..

->Login Table (UserName,Password)

->BillReceipt Table(Name,CustomerNumber,ReceiptNumber,Units,BillDate,Type,Amount,PaymentStatus)

->Request Table(Name,Address,Phone,Adhar,PAN,Email,CommunicationAdd,
SupplyAdd,TariffType,SubcatOfTariff,SupplyType,GstNo,Ownership,Adhardoc,Rationdoc,Propertydoc,PropertyTaxdoc,Status)

Java communicates with MySQL tables using JDBC which stands for Java Database Connectivity.
