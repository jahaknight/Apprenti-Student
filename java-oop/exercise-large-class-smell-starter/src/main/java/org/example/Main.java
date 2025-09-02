package org.example;


public class Main {
    public static void main(String[] args) {
        ConsoleIO.display("Welcome to Better School Tracker!");

        // Gather Student info
        Student student = new Student();

        student.setFirstName(ConsoleIO.promptString("Enter Student First Name"));
        student.setLastName(ConsoleIO.promptString("Enter Student Last Name"));
        student.setGPA(ConsoleIO.promptDouble("Enter Student's GPA"));

        // Gather Teacher (homeroom) info
        String tFirst = ConsoleIO.promptString("Enter Homeroom Teacher's First Name");
        String tLast = ConsoleIO.promptString("Enter Homeroom Teacher's Last Name");
        Teacher homeroom = new Teacher(tFirst, tLast);
        student.setHomeroom(homeroom);

        // Output
        System.out.println();
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Homeroom Teacher: " + student.getHomeroom().getFullName());
    }
}