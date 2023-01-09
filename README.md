# TNEB Management System
This is a protype of website for TNEB(TAMILNADU ELECTRICITY BOARD) management.

It lets User perform multiple operations like,...

1- User can Create his Personal login for security purposes.

2- User can Request Connection and Calculate their Electricity Bill.

3- User can Pay Electricity Bills.

4- User can Generate Bill.

# About Project

This Java application was created using Intelli J . Additional library was added for the support of JDBC (Required to setup the connection between the Database and Java Application). It contains 9 different classes which works together to create a better user experience .

->𝐋𝐨𝐠𝐢𝐧 class

->𝐒𝐢𝐠𝐧𝐔𝐩 class

->𝐌𝐚𝐢𝐧 class

->𝐑𝐞𝐪𝐮𝐞𝐬𝐭𝐄𝐁𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 class

->𝐏𝐚𝐲𝐦𝐞𝐧𝐭 class

->𝐏𝐫𝐢𝐧𝐭𝐁𝐢𝐥𝐥𝐑𝐞𝐜𝐞𝐢𝐩𝐭 class

->𝐂𝐚𝐥𝐜𝐮𝐥𝐚𝐭𝐞𝐁𝐢𝐥𝐥 class

->𝐕𝐢𝐞𝐰𝐑𝐞𝐪𝐮𝐞𝐬𝐭𝐬 class

->𝐃𝐚𝐭𝐚𝐛𝐚𝐬𝐞𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 class(JDBC - MySQL)

# Database (My SQL)

Database for this project contains 3 Tables,..

->𝐋𝐨𝐠𝐢𝐧 Table (UserName,Password)

->𝐁𝐢𝐥𝐥𝐑𝐞𝐜𝐞𝐢𝐩𝐭 Table(Name,CustomerNumber,ReceiptNumber,Units,BillDate,Type,Amount,PaymentStatus)

->𝐑𝐞𝐪𝐮𝐞𝐬𝐭 Table(Name,Address,Phone,Adhar,PAN,Email,CommunicationAdd,
SupplyAdd,TariffType,SubcatOfTariff,SupplyType,GstNo,Ownership,Adhardoc,Rationdoc,Propertydoc,PropertyTaxdoc,Status)

Java communicates with MySQL tables using JDBC which stands for Java Database Connectivity.
