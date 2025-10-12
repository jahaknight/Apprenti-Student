-- Creating Database
DROP DATABASE IF EXISTS DeletingLab;
CREATE DATABASE DeletingLab;
USE DeletingLab;

SELECT DATABASE() AS current_db;

-- 1 Setup
-- Tables
CREATE TABLE ProductCategory (
	CategoryId INT PRIMARY KEY,
    CategoryName VARCHAR(50)
);

CREATE TABLE Product (
	ProductId   INT PRIMARY KEY,
    ProductName VARCHAR(100),
    CategoryId  INT,
    Price	    DECIMAL(10,2),
	FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId)
);

-- Seed data
INSERT INTO ProductCategory VALUES
  (1,'Books'),
  (2,'Stationery'),
  (3,'Clearance');
  
INSERT INTO Product VALUES
  (101,'Notebook',        2,  5.00),
  (102,'Pen Set',         2,  7.50),
  (103,'Calendar 2023',   2,  9.99),
  (104,'Mystery Novel',   1, 15.00),
  (105,'Classic Fiction', 1, 12.50),
  (106,'Sticker Pack',    3,  2.99);
  

-- Checking 
SELECT * FROM ProductCategory;
SELECT * FROM Product ORDER BY ProductId;

-- Part 1 - Delete a Single Reocvrd 
-- 1. Preview the exact row
SELECT ProductID, ProductName FROM Product
WHERE ProductName = 'Calender 2023';

-- 2. Delete 
DELETE FROM Product
WHERE ProductId = 103;

-- Verify deletion 
SELECT * FROM Product WHERE ProductID = 103;
SELECT * FROM Product WHERE ProductName = 'Calendar 2023';

-- Part 2 : Delete multiple (Stationary)
SELECT CategoryId INTO @stationery_id
FROM ProductCategory
WHERE CategoryName = 'Stationery';

-- delete 
DELETE FROM Product
WHERE CategoryId = @stationery_id;

-- verify
SELECT p.*
FROM Product p
JOIN ProductCategory c ON c.CategoryId = p.CategoryId
WHERE c.CategoryName = 'Stationery';

-- Part 3: Foreign Key Deletions 
SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Books';
SELECT p.ProductID, p.ProductName, p.CategoryId
FROM Product p
JOIN ProductCategory c ON c.CategoryId = p.CategoryId
WHERE c.CategoryName = 'Books';

-- 1. Delete products that reference the 'Books' CategoryId
DELETE FROM Product
WHERE CategoryId = (
	SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Books'
);

-- 2. Delete the parent row now that no children reference it 
SELECT CategoryId INTO @books_id
FROM ProductCategory
WHERE CategoryName = 'Books';

-- delete by PK 
DELETE FROM ProductCategory
WHERE CategoryId = @books_id
LIMIT 1;   -- extra seatbelt

-- Verify results
SELECT * FROM ProductCategory WHERE CategoryName = 'Books';
SELECT *
FROM Product
WHERE CategoryId NOT IN (SELECT CategoryId FROM ProductCategory);

-- Optional
START TRANSACTION;

SELECT CategoryId INTO @books_id
FROM ProductCategory
WHERE CategoryName = 'Books';

DELETE FROM Product
WHERE CategoryId = @books_id;

DELETE FROM ProductCategory
WHERE CategoryId = @books_id
LIMIT 1;

COMMIT;














	




