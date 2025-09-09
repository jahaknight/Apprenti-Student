import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// create, add, get, remove, size, IsEmpty, sort, merge

public class ListExercise {
    public static void main(String[] args) {

        // 1. Declare
        List<String> students = new ArrayList<>();

        // 2. Add elements to the end of the list
        students.add("Ava");
        students.add("Olivia");
        students.add("Emma");
        students.add("Liam");
        students.add("John");

        System.out.println("Starting list: " + students);

        // 3. Get 3rd student
        // Lists are 0-based: 0=first, 1=second, 2=third (TIP)
        if (students.size() >= 3) {
            String thirdStudent = students.get(2);
            System.out.println("Third students: " +thirdStudent);
        } else {
            System.out.println("Need at least 3 students to get the third one.");
        }

        // 4. Remove 2nd student
        if (students.size() >= 2) {
            String removed = students.remove(1);
            System.out.println("Removed student: " + removed);
        } else {
            System.out.println("Need at least 2 students to remove the second one.");
        }

        // 5. Size: how many are left?
        System.out.println("List is empty: ");

        // 6. IsEmpty: true if size == 0
        System.out.println("List is empty: " + students.isEmpty());

        // 7. Sort : alphabetical
        Collections.sort(students);
        System.out.println("Sorted list: " + students);

        // Bonus
        List<String> newStudents = new ArrayList<>(Arrays.asList("Sophia", "Noah", "Mia"));
        students.addAll(newStudents);
        Collections.sort(students);
        System.out.println("Merged + sorted list: " + students);

    }

}
