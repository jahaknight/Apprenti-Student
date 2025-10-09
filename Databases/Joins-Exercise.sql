USE SimpleSchool;

-- 1. All course names, hours, and subject names 
-- where  subjecy name is "History"
-- No aliases
-- Uses INNER keyword
-- Ordered by course name

SELECT 
	Course.CourseName,
    Course.CreditHours,
    Subject.SubjectName
FROM Course
INNER JOIN Subject
	ON Course.SubjectID = Subject.SubjectID
WHERE Subject.SubjectName = 'History'
ORDER BY Course.CourseName;

-- 2. Same as #1 but with aliases (c, s) and no INNER keyword
SELECT 
	c.CourseName,
    c.CreditHours,
    s.SubjectName
FROM Course c
JOIN Subject s
	ON c.SubjectID = s.SubjectID
WHERE s.SubjectName = 'History'
ORDER BY c.CourseName;

-- 3. Same as #2 but explicitly using INNER with aliases
SELECT 
	c.CourseName,
    c.CreditHours,
    s.SubjectName
FROM Course c 
INNER JOIN Subject s
	ON c.SubjectID = s.SubjectID
WHERE s.SubjectName = 'History'
ORDER BY c.CourseName;

-- 4. Course names, credit hours, and subject names
-- where the subject name contains "Art"
-- ordered by subject name, then course name
SELECT 
	c.CourseName,
    c.CreditHours,
    s.SubjectName
FROM Course c
JOIN Subject s
	ON c.SubjectID = s.SubjectID
WHERE s.SubjectName LIKE '%Art%'
ORDER BY s.SubjectName, c.CourseName;

-- 5. Room number, description, and building name
--    only rooms missing a description (NULL)
SELECT
  r.RoomNumber,
  r.Description,
  b.BuildingName
FROM Room r
JOIN Building b
  ON r.BuildingID = b.BuildingID
WHERE r.Description IS NULL;

-- 6. All courses > 3 credit hours for teacher "Geno Booy"
--    join Course -> Teacher and filter by teacher full name
SELECT DISTINCT
  c.CourseName,
  c.CreditHours,
  t.FirstName,
  t.LastName
FROM Course  c
JOIN Section s  ON s.CourseID  = c.CourseID
JOIN Teacher t  ON t.TeacherID = s.TeacherID
WHERE c.CreditHours > 3
  AND CONCAT(t.FirstName, ' ', t.LastName) = 'Geno Booy'
ORDER BY c.CourseName;
    




