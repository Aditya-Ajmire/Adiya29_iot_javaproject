# User Management JDBC Project
This is a simple banking system implemented in Java using JDBC and MySQL.

## Project Overview
The application allows users to:

Register and login

Open bank accounts

Credit, debit, and transfer money

Check account balance

Database Setup
Since the original database is not included, you need to create the MySQL database manually before running the application.

## Steps to create the database:
Install MySQL Server (if not installed):
Download and install from https://dev.mysql.com/downloads/mysql/

Create the database and tables:
Run the following SQL script in your MySQL client (e.g., MySQL Workbench, command line):


CREATE DATABASE bank_db;
USE bank_db;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Accounts (
    account_number BIGINT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    balance DOUBLE DEFAULT 0,
    security_pin VARCHAR(10) NOT NULL,
    FOREIGN KEY (email) REFERENCES user(email)
);
Optional: Add sample data to test the application.

Running the Application
Update your MySQL username and password in the BankingApp.java file (or relevant config):


private static final String url = "jdbc:mysql://localhost:3306/bank_db";
private static final String username = "yourUserName";
private static final String password = "yourPassWord";
Build and run the Java program using your IDE or command line.

Notes
This project demonstrates JDBC integration with MySQL for database operations.

All database schema and relations are derived from the application code.

