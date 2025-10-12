-- Create Database
DROP DATABASE IF EXISTS CustomerDB;
CREATE DATABASE CustomerDB;
USE CustomerDB;

SELECT DATABASE() AS current_db;

-- sample table 
CREATE TABLE Customers (
	CustomerId 		INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName 	VARCHAR(100),
    Email 			VARCHAR(100),
    Status 			VARCHAR(20)
);

-- seed data
INSERT INTO Customers (CustomerName, Email, Status) VALUES
('John Doe',      'john@example.com',  'Active'),
('Jane Smith',    'jane@example.com',  'Inactive'),
('Emily Brown',   'emily@example.com', 'Active'),
('Michael Green', 'mike@example.com',  'Active');

SELECT * FROM Customers;

-- Task 1 : Simple Stored Procedure 
DELIMITER //
CREATE PROCEDURE GetActiveCustomers()
BEGIN
	SELECT * FROM Customers
	WHERE Status = 'Active';
END //
DELIMITER //

-- call procedure
CALL GetActiveCustomers();

-- Task 2 : Stored Procedure with a Single Parameter
DROP PROCEDURE IF EXISTS GetActiveCustomers;
DROP PROCEDURE IF EXISTS GetCustomerDetails;
DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT)
BEGIN
	SELECT * FROM Customers
    WHERE CustomerId = CustomerIdIn;
END //
DELIMITER ;

-- Call procedure 
CALL GetCustomerDetails(1);

-- Task 3 : Procedure with 2 Params 
DROP PROCEDURE IF EXISTS GetCustomerInfo;

-- Create procedure
DELIMITER //
CREATE PROCEDURE GetCustomerInfo(
	IN p_CustomerId   INT,
    IN p_CustomerName VARCHAR(100)
)
BEGIN
	SELECT *
    FROM Customers
    WHERE CustomerId = p_CustomerId
		AND CustomerName = p_CustomerName;
	END //
    DELIMITER ;
    
-- test procedure
CALL GetCustomerInfo(1, 'John Doe');

-- Task 4: Modify a Procedure
-- safety
DROP PROCEDURE IF EXISTS GetCustomerDetails;

DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN p_CustomerId INT)
BEGIN
	SELECT *
    FROM Customers
    WHERE CustomerId = p_CustomerId
		AND Status = 'Active';
END //
DELIMITER ;

-- test 
CALL GetCustomerDetails(1);

-- Task 5: Remove a Procedure
DROP PROCEDURE IF EXISTS GetCustomerInfo;

-- verification
SHOW PROCEDURE STATUS WHERE Db = DATABASE();

-- Optional Task 6: Transaction Demo
DROP PROCEDURE IF EXISTS ToggleCustomerStatus;

DELIMITER //
CREATE PROCEDURE ToggleCustomerStatus(IN p_CustomerId INT)
BEGIN
	DECLARE v_old VARCHAR(20);
    
    START TRANSACTION;
    
    SELECT Status INTO v_old
    FROM Customers
    WHERE CustomerId = p_CustomerId
    FOR UPDATE;
    
    UPDATE Customers
    SET Status = CASE WHEN v_old = 'Active' THEN 'Inactive' ELSE 'ACTIVE' END
    WHERE CustomerId = p_CustomerId;
    
    COMMIT;
END //
DELIMITER ;

-- test
CALL ToggleCustomerStatus(1);
SELECT * FROM Customers WHERE CustomerId = 1;









