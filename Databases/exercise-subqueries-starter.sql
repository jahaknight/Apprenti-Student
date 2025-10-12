USE SimpleSchool;
-- Part 1: Using NOT EXISTS
--  Write a query to list all Students that are not registerd for a class 
-- Hint(Check the Section Roster)
SELECT
	s.StudentID,
    s.FirstName,
    s.LastName
FROM Student s
WHERE NOT EXISTS (
	SELECT 1
    FROM SectionRoster sr
    WHERE sr.StudentID = s.StudentID
)
ORDER BY s.LastName, s.FirstName;

-- Part 2: Subqueries in the WHERE Clause
-- Find the name(s) of classes that have the most students registered

SELECT 
	c.CourseID,
    c.CourseName,
    s.SectionID,
    COUNT(sr.StudentID) AS num_students
FROM Section s
JOIN Course c			ON c.CourseID = s.CourseID
JOIN SectionRoster sr   ON sr.SectionID = s.SectionID
GROUP BY c.CourseId, c.CourseName, s.SectionID
HAVING COUNT(sr.StudentID) = (
	SELECT MAX(student_count)
    FROM (
		SELECT COUNT(StudentID) AS student_count
        FROM SectionRoster
        GROUP BY SectionID
	) AS sub
)
ORDER BY c.CourseName;

-- Part 3: Subquery in the SELECT Clause
-- Select all Classes Show:
-- The Teacher That is assigned to Instruct
-- The Room That the class is in
-- No Joins Allowed

SELECT 
	s.SectionID,
    s.CourseID,
    (SELECT CONCAT(t.FirstName, ' ', t.LastName)
		FROM Teacher t
        WHERE t.TeacherID = s.TeacherID) AS TeacherName,
        (SELECT r.RoomNumber
        FROM Room r
        WHERE r.RoomID = s.RoomID) AS RoomNumber
	FROM Section s
    ORDER BY s.SectionID;

-- Part 4: Subquery in the HAVING Clause
-- Use the Query from Part 2. Use Having to determine which class(s)
-- Has the least amount of Students (Must Be in a Subquery)

SELECT
	c.CourseID,
    c.CourseName,
    s.SectionID,
    COUNT(sr.StudentID) AS num_students
FROM Section s
JOIN Course c			ON c.CourseID = s.CourseID
JOIN SectionRoster sr ON sr.SectionID = s.SectionID
GROUP BY c.CourseID, c.CourseName, s.SectionID
HAVING Count(sr.StudentID) = (
	SELECT MIN(student_count)
    FROM (
		SELECT COUNT(StudentID) AS student_count
        FROM SectionRoster
        GROUP BY SectionID
	) 	AS sub
)
ORDER BY c.CourseName;

-- Part 5: Correlated Subquery
-- Return the top 3 Teachers that have the most students to teach 
-- across all classes and semesters
SELECT
	t.TeacherID,
    CONCAT(t.FirstName, ' ', t.LastName) AS TeacherName,
    (
    SELECT COUNT(sr.StudentID)
    FROM SectionRoster sr
    JOIN Section s2 ON s2.SectionID = sr.SectionID
    WHERE s2.TeacherID = t.TeacherID
) AS total_students
FROM Teacher t
ORDER BY total_students DESC
LIMIT 3;

