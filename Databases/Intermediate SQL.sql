USE SimpleSchool;

-- 1. Add a new subject named "Comp. Science"
INSERT INTO Subject (SubjectName)
VALUES ('Comp. Science.');

-- Capture SubjectID
SELECT SubjectID INTO @cs_id
FROM Subject
WHERE SubjectName = 'Comp. Science.';

SELECT @cs_id AS comp_science_new_id;

-- 2. Modify the new subject's name to "Computer Science."
UPDATE Subject
SET SubjectName = 'Computer Science'
WHERE SubjectID = @cs_id;

-- Refresh the id
SELECT SubjectID INTO @cs_id
FROM Subject 
WHERE SubjectName = 'Computer Science';

SELECT @cs_id AS computer_science_id_after_rename;

-- 3. Add the courses to the Computer Science subject
-- (Java, C#, JavaScript, Advanced Java) — all 3 credit hours

INSERT INTO Course (CourseName, CreditHours, SubjectID) VALUES
  ('Java',         3, @cs_id),
  ('C#',           3, @cs_id),
  ('JavaScript',   3, @cs_id),
  ('Advanced Java',3, @cs_id);
  
  -- verification 
  SELECT CourseID, CourseName, CreditHours, SubjectID
  FROM Course
  WHERE SubjectID = @cs_id
  ORDER BY CourseName;
  
  -- Rename the course "Java" to "Java 101"
  UPDATE Course
  SET CourseName = 'Java 101'
  WHERE CourseName = 'Java'
	AND SubjectID = @cs_id;
    
-- verify 
SELECT CourseID, CourseName, CreditHours
FROM Course
WHERE SubjectID = @cs_id
ORDER BY CourseName;

-- 5. Rename "Advanced Java" to "Java 201" AND set CreditHours = 4
UPDATE Course
SET CourseName = 'Java 201',
	CreditHours = 4
WHERE CourseName = 'Advanced Java'
	AND SubjectID = @cs_id;
    
-- verify
SELECT CourseId, CourseName, CreditHours
FROM Course
WHERE SubjectID = @cs_id
ORDER BY CourseName;

-- 6. Delete the "Computer Science" subject 
-- a) what error message?
-- b) why?

-- a) Attempt (this should FAIL while courses still reference the subject) 
-- Expected : Error Code: 1451 - Cannot delete or update a parent row:
-- 			  Foreign key constraint fails
DELETE FROM Subject
WHERE SubjectName = 'Computer Science';

-- b) Explanation for error
-- The subject row is a PARENT referenced by Course.SubjectID
-- MYSQL prevents deleting a parent row that still has CHILD rows 
-- Have to delete (or reassign) the child Course rows first

-- 7. Delete the "Java 101" course 
DELETE FROM Course
WHERE CourseName = 'Java 101'
	AND SubjectID = @cs_id;
    
-- verify
SELECT CourseID, CourseName
FROM Course
WHERE SubjectID = @cs_id
ORDER BY CourseName;

-- 8. Delete the remaining "Computer Science" courses
DELETE FROM Course
WHERE SubjectID = @cs_id;

-- verify
SELECT CourseID, CourseName
FROM Course 
WHERE SubjectID = @cs_id;

-- 9. Delete the "Computer Science" (now that children are gone)
DELETE FROM Subject 
WHERE SubjectID = @cs_id;

-- Final checks
SELECT * FROM Subject WHERE SubjectID = @cs_id;
SELECT * FROM Course WHERE SubjectID = @cs_id;









  
  
  










