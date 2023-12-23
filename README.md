# TNEB Management System

A Java application for TNEB (Tamil Nadu Electricity Board) management.

## Overview

The TNEB Management System is a Java command-line application created using IntelliJ IDEA. It facilitates various operations related to TNEB, providing users with features such as user authentication, connection requests, electricity bill calculation and payment, and more.

## Features

1. **User Authentication:**
   - Users can create personal logins for enhanced security.

2. **Connection Management:**
   - Request connections for both commercial and domestic purposes.
   - Calculate electricity bills based on the type of connection.

3. **Bill Management:**
   - Pay electricity bills conveniently through the application.
   - Generate detailed bills for reference.

## Project Structure

The Java application is organized into several classes, each serving a specific purpose:

- `Login`: Manages user authentication.
- `SignUp`: Handles user registration.
- `Main`: The main class that orchestrates the application.
- `RequestEBConnection`: Allows users to request new connections.
- `Payment`: Facilitates electricity bill payments.
- `PrintBillReceipt`: Generates and prints detailed bill receipts.
- `CalculateBill`: Implements the logic for bill calculation.
- `ViewRequests`: Displays connection requests and their status.
- `DatabaseConnection`: Manages the connection to the MySQL database using JDBC.

## Database Structure

The MySQL database is structured with three tables:

1. **Login Table**
   - Columns: UserName, Password

2. **BillReceipt Table**
   - Columns: Name, CustomerNumber, ReceiptNumber, Units, BillDate, Type, Amount, PaymentStatus

3. **Request Table**
   - Columns: Name, Address, Phone, Adhar, PAN, Email, CommunicationAdd, SupplyAdd, TariffType, SubcatOfTariff, SupplyType, GstNo, Ownership, Adhardoc, Rationdoc, Propertydoc, PropertyTaxdoc, Status

