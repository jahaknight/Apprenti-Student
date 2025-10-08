USE SimpleSchool;

--  1. StudentID, LastName, FirstName of Students whose LastName starts with 'Cr'
SELECT 
	StudentID,
    LastName,
    FirstName
FROM Student
WHERE LastName LIKE 'Cr%';

-- 2. All courses with SubjectID 1, 2, or 4 using OR 
SELECT
*
FROM Course
WHERE SubjectID = 1
	OR SubjectID = 2
    OR SubjectID = 4;
    
-- 3. All Courses with SubjectID 1, 2, or 4 — using IN
SELECT
*
FROM Course
WHERE SubjectID IN (1, 2, 4);

-- 4. Student record with an id of 42
SELECT 
*
FROM Student
WHERE StudentID = 42;

-- 5. Student FirstNames that start with 'C' - using LIKE
SELECT
	FirstName
FROM Student
WHERE FirstName LIKE 'C%';

-- 6. Student FirstNames that start with 'Ce' using BETWEEN
SELECT
	FirstName
FROM Student
WHERE FirstName BETWEEN 'Ce' AND 'Cezzzzzzz';

-- 7. First 10 unique Student LastNames
SELECT DISTINCT
	LastName
FROM Student
ORDER BY LastName
LIMIT 10;

-- 8. First 10 Student Records (ordered by StudentID)
SELECT
	*
FROM Student
ORDER BY StudentID
LIMIT 10;

-- 9. Top five Students in reverse alphabetical order by LastName
SELECT
	*
FROM Student
ORDER BY LastName DESC, FirstName DESC
LIMIT 5;







