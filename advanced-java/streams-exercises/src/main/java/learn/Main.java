package learn;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
//        for (Student student : students) {
//            System.out.println(student);
//        }

        // stream solution
//        students.stream().forEach(System.out::println);

        // 1. Print students from Argentina
        students.stream()
                .filter(student -> "Argentina".equalsIgnoreCase(student.getCountry()))
                .forEach(System.out::println);

        // 2. Print students whose last names starts with 'T'.
        students.stream()
                .filter(student -> student.getLastName().startsWith("T"))
                .forEach(System.out::println);

        // 3. Print students from Argentina, ordered by GPA
        students.stream()
                .filter(student -> "Argentina".equalsIgnoreCase(student.getCountry()))
                .sorted(Comparator.comparing(Student::getGpa))
                .forEach(System.out::println);

        // 4. Print the bottom 10% (100 students) ranked by GPA.
        students.stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .limit(100)
                .forEach(System.out::println);

        // 5. Print the 4th - 6th ranked students by GPA from Argentina
        students.stream()
                .filter(s -> "Argentina".equals(s.getCountry()))
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .skip(3)
                .limit(3)
                .forEach(System.out::println);


        // 6. Is anyone from Maldives?
        boolean fromMaldives = students.stream()
                .anyMatch(s-> "Maldives".equals(s.getCountry()));

        // 7. Does everyone have a non-null, non-empty email address?
        boolean allHaveEmail = students.stream()
                .allMatch(s-> s.getEmailAddress() != null
                        && !s.getEmailAddress().isEmpty());
        System.out.println(allHaveEmail);


        // 8. Print students who are currently registered for 5 courses.
        students.stream()
                .filter(s-> s.getRegistrations().size() == 5)
                .forEach(System.out::println);

        // 9. Print students who are registered for the course "Literary Genres".
        students.stream()
                .filter(s-> s.getRegistrations().stream()
                        .anyMatch(r-> "Literary Genres".equals(r.getCourse())))
                .forEach(System.out::println);

        // 10. Who has the latest birthday? Who is the youngest?
        Optional<Student> youngest = students.stream()
                .max(Comparator.comparing(Student::getBirthDate));
        youngest.ifPresent(System.out::println);

        // 11. Who has the highest GPA? There may be a tie.
        Optional<Student> highestGpa = students.stream()
                .max(Comparator.comparing(Student::getGpa));
        highestGpa.ifPresent(h-> {
            students.stream()
                    .filter(s-> s.getGpa().equals(h.getGpa()))
                    .forEach(System.out::println);
        });


        // 12. Print every course students are registered for, including repeats.
        students.stream()
                .flatMap(s-> s.getRegistrations().stream())
                .map(Registration::getCourse)
                .forEach(System.out::println);

        // 13. Print a distinct list of courses students are registered for.
        students.stream()
                .flatMap(s-> s.getRegistrations().stream())
                .map(Registration::getCourse)
                .distinct()
                .forEach(System.out::println);


        // 14. Print a distinct list of courses students are registered for, ordered by name.
         students.stream()
                .flatMap(s-> s.getRegistrations().stream())
                .map(Registration::getCourse)
                .distinct()
                 .sorted()
                .forEach(System.out::println);

        // 15. Count students per country.
        Map<String,Long> studentsPerCountry = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));
        studentsPerCountry.forEach((country, count )-> System.out.println(country + " : " + count));

        // 16. Count students per country. Order by most to fewest students.
        Map<String,Long> studentsPerCountrySorted = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));

        studentsPerCountrySorted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey()
                + ": " + entry.getValue()));

        // 17. Count registrations per course.
        Map<String, Long> registrationsPerCourse = students.stream()
                .flatMap(s-> s.getRegistrations().stream())
                .collect(Collectors.groupingBy(Registration::getCourse, Collectors.counting()));
        registrationsPerCourse.forEach((course, count) ->
                System.out.println(course + ": " + count));

        // 18. How many registrations are not graded (GradeType == AUDIT)?
        long auditCount = students.stream()
                .flatMap(s-> s.getRegistrations().stream())
                .filter(r-> r.getGradType() == GradeType.AUDIT)
                .count();
        System.out.println(auditCount);

        // 19. Create a new type, learn.StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to learn.StudentSummary, then sort and limit by IQ (your choice of low or high).
        students.stream()
                .map(s-> new StudentSummary(s.getCountry(), s.getMajor(), s.getIq()))
                .sorted(Comparator.comparing(StudentSummary::getIq).reversed())
                .limit(10)
                .forEach(System.out::println);


        // 20. What is the average GPA per country (remember, it's random fictional data).
        Map<String, Double> avgGpaPerCountry = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCountry,
                        Collectors.averagingDouble(s-> s.getGpa().doubleValue())
                ));
        avgGpaPerCountry.forEach((country, avgGpa) ->
                System.out.printf(country + ": " + "%.2f&n",avgGpa));

        // 21. What is the maximum GPA per country?

        // 22. Print average IQ per Major ordered by IQ ascending.

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
    }
}
