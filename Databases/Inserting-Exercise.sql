-- create database
DROP DATABASE IF EXISTS RetailDB;
CREATE DATABASE RetailDB;
USE RETAILDB;

SELECT DATABASE() AS current_db;

-- setup Tables: Customer, CustomerOrder, PaymentMethod, Payment
CREATE TABLE Customer (
	CustomerId INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(100)
);

CREATE TABLE CustomerOrder (
	OrderId INT AUTO_INCREMENT PRIMARY KEY,
    CustomerId INT,
    OrderDate DATE,
    FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId)
);

CREATE TABLE PaymentMethod (
	PaymentMethodId INT PRIMARY KEY,
    MethodName VARCHAR(50)
);

CREATE TABLE Payment (
	PaymentId 		INT AUTO_INCREMENT PRIMARY KEY,
    OrderId   		INT,
    PaymentMethodId INT, 
    Amount			DECIMAL(10,2),
	FOREIGN KEY (OrderId) REFERENCES CustomerOrder(OrderId),
	FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)
);

-- seed payment methods
INSERT INTO PaymentMethod VALUES
  (1,'Credit Card'),
  (2,'Cash'),
  (3,'Mobile Payment');
  
  -- check
  SELECT * FROM PaymentMethod ORDER BY PaymentMethodId;
  
  -- Part 1: Insert Single Records
  -- 1) Add customers: Emma Rivera, Noah Gray
  -- 2) Create one order for each (today’s date)
  
  -- 1. Customers
  INSERT INTO Customer (CustomerName) VALUES ('Emma Rivera');
  SET @emma_id = LAST_INSERT_ID();
  INSERT INTO Customer (CustomerName) VALUES ('Noah Gray');
  SET @noah_id = LAST_INSERT_ID();
  
  -- Orders for today
  INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES (@emma_id, CURDATE());
  SET @emma_order_id = LAST_INSERT_ID();
  
  INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES (@noah_id, CURDATE());
  SET @noah_order_id = LAST_INSERT_ID();
  
  -- verify
  SELECT 	@emma_id   AS emma_id,   @emma_order_id AS emma_order_id,
			@noah_id   AS noah_id,   @noah_order_id AS noah_order_id;
  
  
  SELECT * FROM Customer ORDER BY CustomerId;
  SELECT * FROM CustomerOrder ORDER BY OrderId;
  
  -- Part 2: Insert with AUTO-Increment Key
SELECT CustomerId INTO @emma_id
FROM Customer
WHERE CustomerName = 'Emma Rivera'
ORDER BY CustomerId DESC
LIMIT 1;

SELECT OrderId INTO @emma_order_id
FROM CustomerOrder
WHERE CustomerId = @emma_id
ORDER BY OrderId DESC
LIMIT 1;

-- insert payment for Emma's latest order using PaymentMethodId = 1
INSERT INTO Payment (OrderId, PaymentMethodId, Amount)
VALUES (@emma_order_id, 1, 49.99);

-- verify
SELECT * FROM Payment ORDER BY PaymentId;

-- Part 3 : Handle Forign Keys
-- (Expected FK failure – only runninb to demo the error, then comment out 
-- INSERT INTO Payment (OrderId, PaymentMethodId, Amount)
-- VALUES (@emma_order_id, 999, 10.00)

-- correct example
INSERT INTO Payment (OrderId, PaymentMethodId, Amount)
VALUES (@emma_order_id, 2, 10.00);

-- verify
SELECT * FROM Payment ORDER BY PaymentId;

-- Part 4: Bulk Insert 
-- 3 new customers in one statement
INSERT INTO Customer (CustomerName) VALUES
	('Liam Davis'),
	('Olivia Brooks'),
	('Sophia Martinez');
    
-- capture ids
SELECT CustomerId INTO @liam_id
FROM Customer WHERE CustomerName = 'Liam Davis'
ORDER BY CustomerId DESC LIMIT 1;

SELECT CustomerId INTO @olivia_id
FROM Customer WHERE CustomerName = 'Olivia Brooks'
ORDER BY CustomerId DESC LIMIT 1;

SELECT CustomerId INTO @sophia_id
FROM Customer WHERE CustomerName = 'Sophia Martinez'
ORDER BY CustomerId DESC LIMIT 1;

-- two orders for today 
INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES
	(@liam_id, 	 CURDATE()),
    (@olivia_id, CURDATE());
    
-- verify
SELECT * FROM Customer ORDER BY CustomerId;
SELECT * FROM CustomerOrder ORDER BY OrderId;
    
    
    
    
    
    





	



  
  
  

  
  
  
  

  
  

		


