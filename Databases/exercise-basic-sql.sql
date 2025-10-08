-- L1. Select the string literal
SELECT 'All for one, and one for all.' AS quote;

-- L2 CONCAT the two parts 
SELECT CONCAT('All for one, and ', 'one for all.') AS quote_concat;

-- L3. 6 + 6
SELECT 6 + 6 AS sum_6_plus_6;

-- L4. 5 / 2 
SELECT 5 / 2 AS five_div_two_int;

-- L5. 5.0 / 2.0 (forces decimal)
SELECT 5.0 / 2.0 AS five_div_two_decimal;

-- L6. 6 divided by 4 AND the remainder
SELECT 6 / 4 AS six_div_four_quotient,
6 % 4 AS six_div_four_remainder;

-- L7. 6 squared
SELECT POW(6,2) AS six_squared;

-- T1. All rows from Building 
SELECT * FROM Building;

-- T2. Period name, start, end times 
SELECT PeriodName, StartTime, EndTime
FROM Period;

-- T3. Which table is empty?
SELECT 'Building' AS table_name, COUNT(*) AS row_count FROM Building
UNION All
SELECT 'Period'   AS table_name, COUNT(*) FROM Period
UNION ALL
SELECT 'Room' 	  AS table_name, COUNT(*) FROM Room
UNION ALL
Select 'Course'   AS table_name, COUNT(*) FROM Course
UNION ALL
SELECT 'Teacher'  AS table_name, COUNT(*) FROM Teacher
UNION ALL
SELECT 'GradeType' AS table_name, COUNT(*) FROM GradeType
UNION ALL
SELECT 'GradeItem' AS table_name, COUNT(*) FROM GradeItem;

-- T4. Courses in "CourseName (CreditHours)" format
SELECT CONCAT(CourseName, ' (', CreditHours, ')') AS course_and_hours
FROM Course
ORDER BY CourseName;

-- T5. Teachers' full names (first + last initial) for the first five teacher
SELECT CONCAT(FirstName, ' ', LEFT(LastName, 1), '.') AS teacher_short_name
FROM Teacher
ORDER BY LastName, FirstName
LIMIT 5;

-- T6. How many rooms are there?
SELECT COUNT(*) AS room_count
FROM Room;

-- T7. Range of room numbers (consider BuildingID)
SELECT BuildingID,
	MIN(RoomNumber) AS min_room_number,
    MAX(RoomNumber) AS max_room_number
FROM Room
GROUP BY BuildingID
ORDER BY BuildingID;

-- T8. Examine Room.Description
SELECT RoomID, BuildingID, RoomNumber, Description
FROM Room
ORDER BY BuildingID, RoomNumber
LIMIT 25;

-- T9. How many unique SubjectID's appear in Course?
SELECT COUNT(DISTINCT SubjectID) AS unique_subject_ids
FROM Course;

-- T10. How many grade types are there?
SELECT COUNT(*) AS grade_type_count
FROM GradeType;

-- T11. IDs and Names of the grade types
SELECT GradeTypeID AS id, GradeTypeName AS name
FROM GradeType
ORDER BY GradeTypeID;

-- T12. Which grade types apper in GradeItem?
SELECT DISTINCT gt.GradeTypeID, gt.GradeTypeName
FROM GradeItem gi
JOIN GradeType gt ON gt.GradeTypeID = gi.GradeTypeID
ORDER BY gt.GradeTypeID;

-- T13. Which grade types are NOT used in GradeItem?
SELECT gt.GradeTypeID, gt.GradeTypeName
FROM GradeType gt
LEFT JOIN GradeItem gi ON gi.GradeTypeID = gt.GradeTypeID
WHERE gi.GradeTypeID IS NULL
ORDER BY gt.GradeTypeID;


