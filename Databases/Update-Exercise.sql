-- create database
DROP DATABASE IF EXISTS UpdateLab;
CREATE DATABASE UpdateLab;
USE UpdateLab;

SELECT DATABASE() AS current_db;

-- setup
CREATE TABLE ProductCategory (
	CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(50)
);

CREATE TABLE Product (
	ProductId INT PRIMARY KEY,
    ProductName VARCHAR(100),
    CategoryId INT,
    Price DECIMAL(10,2),
    EndDate DATE,
	FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId)
);

INSERT INTO ProductCategory VALUES
(1,'Books'), (2,'Stationery'), (3,'Clearance');

INSERT INTO Product VALUES
(101,'Notebook',        2,  5.00, NULL),
(102,'Pen Set',         2,  7.50, NULL),
(103,'Calendar 2023',   2,  9.99, NULL),
(104,'Mystery Novel',   1, 15.00, NULL),
(105,'Classic Fiction', 1, 12.50, NULL);

-- check 
SELECT * FROM ProductCategory ORDER BY CategoryId;
SELECT * FROM Product ORDER BY ProductId;

-- Part 1 — Update a Single Record
-- 1. Update price of 'Notebook' to $6.25
-- capture PK, then update by PK to satisfy safe-updates mode)

-- capture PKs
SELECT ProductId INTO @notebook_id FROM Product WHERE ProductName='Notebook'        ORDER BY ProductId DESC LIMIT 1;
SELECT ProductId INTO @penset_id   FROM Product WHERE ProductName='Pen Set'         ORDER BY ProductId DESC LIMIT 1;
SELECT ProductId INTO @calendar_id FROM Product WHERE ProductName='Calendar 2023'   ORDER BY ProductId DESC LIMIT 1;
SELECT ProductId INTO @classic_id  FROM Product WHERE ProductName='Classic Fiction' ORDER BY ProductId DESC LIMIT 1;

-- check 
SELECT ProductId, ProductName, Price FROM Product WHERE ProductId=@notebook_id;

-- update
UPDATE Product
SET Price = 6.25
WHERE ProductId = @notebook_id
LIMIT 1;

-- verify
SELECT ProductId, ProductName, Price FROM Product WHERE ProductId=@notebook_id;

-- Part 2: Update Multiple Columns 
--  'Pen Set' → name: 'Executive Pen Set', price: $8.99

-- preview
SELECT ProductId, ProductName, Price FROM Product WHERE ProductId=@openset_id;

-- update both columns in one statement
UPDATE Product 
SET ProductName = 'Executive Pen Set',
    Price       = 8.99
WHERE ProductId = @penset_id
LIMIT 1;

-- verify
SELECT ProductId, ProductName, Price FROM Product WHERE ProductId=@penset_id;

-- Part 3: Update Multiple Records 
-- 3) Set EndDate='2024-12-31' for all products in 'Stationery'
-- (use CategoryId via subquery → assign to a var, then update by key)

SELECT CategoryId INTO @stationery_id
FROM ProductCategory
WHERE CategoryName='Stationery';

-- preview affected rows 
SELECT ProductId, ProductName, EndDate
FROM Product
WHERE CategoryId=@stationery_id
ORDER BY ProductId;

-- update many rows
UPDATE Product
SET EndDate = '2024-12-31'
WHERE CategoryId = @stationery_id;

-- verify
SELECT ProductId, ProductName, EndDate
FROM Product
WHERE CategoryId=@stationery_id
ORDER BY ProductId;

-- Part 4: Handle Foreign Key Relationship 
-- 4a) Try to set Calendar 2023 → CategoryId=999 (should FAIL w/ FK)
-- 4b) Then set it to 'Clearance' (CategoryId=3)

-- 4a (EXPECTED TO FAIL): uncomment to see FK error 1452, then re-comment
-- UPDATE Product SET CategoryId = 999 WHERE ProductId = @calendar_id;

-- 4b correct update to Clearance 
SELECT CategoryID INTO @clearance_id
FROM ProductCategory
WHERE CategoryName='Clearance';

-- preview
SELECT ProductId, ProductName, CategoryId FROM Product WHERE ProductId=@calendar_id;

UPDATE Product
SET CategoryId = @clearance_id
WHERE ProductId = @calendar_id
LIMIT 1;

-- verify
SELECT p.ProductId, p.ProductName, p.CategoryId, c.CategoryName
FROM Product p JOIN ProductCategory c ON c.CategoryId=p.CategoryId
WHERE p.ProductId=@calendar_id;

-- Part 5: Bonus Challenge 
-- Single UPDATE:
-- 'Classic Fiction' → name='Vintage Novel', category='Clearance', price=10.00

-- preview
SELECT ProductID, ProductName, CategoryId, Price FROM Product WHERE ProductID=@classic_id;

UPDATE Product
SET ProductName = 'Vintage Novel',
    CategoryId  = @clearance_id,
    Price       = 10.00
WHERE ProductId = @classic_id
LIMIT 1;

-- verify
SELECT p.ProductId, p.ProductName, p.Price, c.CategoryName
FROM Product p JOIN ProductCategory c ON c.CategoryId=p.CategoryId
WHERE p.ProductId=@classic_id;




















    

