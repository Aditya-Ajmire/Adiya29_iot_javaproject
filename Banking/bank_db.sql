CREATE DATABASE IF NOT EXISTS bank_db;
USE bank_db;

CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Accounts (
  account_number BIGINT PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  balance DOUBLE NOT NULL,
  security_pin VARCHAR(10) NOT NULL,
  FOREIGN KEY (email) REFERENCES user(email)
);

INSERT INTO user (full_name, email, password) VALUES
('Adi Ajmire', 'adi@example.com', 'password123');

INSERT INTO Accounts (account_number, full_name, email, balance, security_pin) VALUES
(10000100, 'Adi Ajmire', 'adi@example.com', 10000.0, '1234');
