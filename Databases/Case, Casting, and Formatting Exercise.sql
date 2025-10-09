DROP DATABASE IF EXISTS ShopSmart;
CREATE DATABASE ShopSmart;
USE ShopSmart;

-- Create Tables 
CREATE TABLE customers (
	customer_id INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50)
);

INSERT INTO customers VALUES
(101,'john','DOE'),
(102,'SARAH','smith');

CREATE TABLE orders (
	order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATETIME,
    order_total VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO orders VALUES
(1,101,'2025-07-01 14:33:00','1234.5'),
(2,102,'2025-07-03 10:15:22','8899.99');

SELECT DATABASE() AS current_db;
SHOW TABLES;
SELECT * FROM customers;

-- Part 1 : Case & Casing
-- Title Case full customer name 
SELECT
	CONCAT(
		UPPER(LEFT(First_Name,1)), LOWER(SUBSTRING(First_Name,2)),
        ' ',
        UPPER(LEFT(Last_Name,1)), LOWER(SUBSTRING(Last_Name,2))
        ) AS customer_name
        FROM customers;
        
-- 2. Case-sensitivity check
SELECT *
FROM customers
WHERE First_Name = 'John';

-- Part 2 : Casting
-- order_total is VARCHAR, cast to DECIMAL(10,2)
SELECT
	order_id,
    order_total				AS raw_total,
    CAST(order_total AS DECIMAL(10,2)) AS formatted_total
FROM orders;

-- Part 3: Formatting 
-- 1. Format date as "Month DD, YYYY"
SELECT
	order_id,
    DATE_FORMAT(order_date, '%M %d, %Y') AS formatted_order_date
FROM orders;

-- 2. Format money: commas + 2 decimals
SELECT
	order_id,
    FORMAT(CAST(order_total AS DECIMAL(10,2)), 2) AS formated_order_total
FROM orders;

-- Part 4: Combined Report 
-- Final Business Report 
-- Columns: customer_name | formatted_order_date | formatted_order_total
SELECT
	CONCAT(
		UPPER(LEFT(c.First_Name,1)), LOWER(SUBSTRING(c.First_Name,2)),
        ' ',
        UPPER(LEFT(c.Last_Name,1)), LOWER(SUBSTRING(c.Last_Name,2))
        ) AS customer_name,
        DATE_FORMAT(o.order_date, '%M %d, %Y') 			AS formatted_order_date,
        FORMAT(CAST(o.order_total AS DECIMAL(10,2)), 2) AS formatted_order_total
	FROM customers c
    JOIN orders o ON o.customer_id = c.customer_id
    ORDER BY c.customer_id;
    
-- Optional 
-- Pad customer_id to 6 digits
SELECT LPAD(customer_id, 6, '0') AS padded_id
FROM customers;

-- Trim whitespace from names 
SELECT 
	customer_id,
    TRIM(First_Name) AS first_name_clean,
    TRIM(Last_Name) AS last_name_clean
FROM customers;
    






        




