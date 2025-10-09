-- Clean Slate & Select DB
DROP DATABASE IF EXISTS BookBarn;
CREATE DATABASE BookBarn;
USE BookBarn;

SELECT DATABASE() AS current_db;

-- Seed Data
DROP TABLE IF EXISTS Sale;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Genre;

CREATE TABLE Genre (
	GenreId INT PRIMARY KEY,
	GenreName VARCHAR(50)
);

CREATE TABLE Book (
	BookId INT PRIMARY KEY,
    GenreId INT,
    Title VARCHAR(100),
    Price DECIMAL(6,2),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);

CREATE TABLE Staff (
	StaffId INT PRIMARY KEY,
    LastName VARCHAR(50),
    HireDate DATE
);

CREATE TABLE Sale (
	SaleID INT PRIMARY KEY,
    StaffId INT,
    Total DECIMAL(10,2),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);

-- Sample Rows
INSERT INTO Genre VALUES 
(1,'Fiction'), (2,'Business'), (3,'Children');

INSERT INTO Book VALUES
(1,1,'Into the Woods', 14.99),
(2,2,'Startup Fundamentals', 22.00),
(3,1,'Ghost Leaves', 11.50),
(4,3,'Adventures with Max',  9.75),
(5,2,'Leadership 101',      26.50);

INSERT INTO STAFF VALUES
(1,'Nguyen','2020-01-01'),
(2,'Smith','2021-03-15'),
(3,'Perez','2021-03-15'),
(4,'Jones','2022-06-10');

INSERT INTO Sale Values
(101,1,295.75),
(102,2,840.20),
(103,2,100.25),
(104,3,925.00),
(105,4,400.00);

-- Sanity Check 
SHOW TABLES;
SELECT * FROM Genre;
SELECT * FROM Book;
SELECT * FROM Staff;
SELECT * FROM Sale;

-- Part 1: Book Pricing Summary
-- (MIN/MAX/AVG, GROUP BY genre, HAVING avg > 15)
-- 1. Overall min, max, avg book price
SELECT
	MIN(Price) AS min_price,
    MAX(Price) AS max_price,
    AVG(Price) AS avg_price
FROM Book;

-- 2. Average price per genre 
SELECT
	g.GenreName,
    ROUND(AVG(b.Price), 2) AS avg_price
FROM Book b
JOIN Genre g ON g.GenreId = b.GenreId
GROUP BY g.GenreName
ORDER BY g.GenreName;

-- 3. Only genres where avg price > $15
SELECT
	g.GenreName,
    ROUND(AVG(b.Price), 2) AS avg_price
FROM Book b
JOIN Genre g ON g.GenreId = b.GenreId
GROUP BY g.GenreName
HAVING AVG(b.Price) > 15
ORDER BY avg_price DESC;

-- Part 2: Staff Sales Performances 
-- (COUNT sales, SUM totals, HAVING > 800, sort desc)
-- 1. Number of sales per staff?
SELECT
	s.LastName,
    COUNT(sa.SaleId) AS total_sales_count
FROM Staff s
JOIN Sale sa ON sa.StaffId = s.StaffId
GROUP BY s.LastName
ORDER BY s.LastName;

-- 2. Total sales value per staff
SELECT
	s.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff s 
JOIN Sale sa ON sa.StaffId = s.StaffId
GROUP BY s.LastName;

-- 3. Only staff whose sales exceed $800
SELECT
	s.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff s
JOIN Sale sa ON sa.StaffID = s.StaffId
GROUP BY s.LastName
HAVING SUM(sa.Total) > 800
ORDER BY total_sales_value DESC;

-- 4. Ranking: sort all staff by total sales desc
SELECT
	s.LastName,
    SUM(sa.Total) AS total_sales_value
FROM Staff s
JOIN Sale sa ON sa.StaffID = s.StaffId
GROUP BY s.LastName
ORDER BY total_sales_value DESC;

-- Part 3: Staff Hire Summary 
SELECT
	HireDate,
    GROUP_CONCAT(LastName ORDER BY LastName SEPARATOR ', ') AS staff_hired
FROM Staff
GROUP BY HireDate
ORDER BY Hiredate;



















