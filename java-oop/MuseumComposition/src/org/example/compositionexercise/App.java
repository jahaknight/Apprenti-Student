package org.example.compositionexercise;

import java.util.Locale;
import java.util.Scanner;

// Console flow:
// 1) prompt artifact name
// 2) prompt year (validated int)
// 3) prompt discoverer (Person)
// 4) ask if discoverer is also curator
// 5) if not, prompt curator (Person)
// 6) build Artifact and print 3 line report

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            // 1) Name
            String name = promptNonBlank(in, "Enter the name of the Artifact: ");

            // 2) Year
            int year = promptInt(in, "Enter the year of its discovery: ");

            // 3) Discoverer
            System.out.println("\n-- Discoverer Info --");
            Person discoverer = promptPerson(in);

            // 4) ask if discoverer is also curator
            boolean same = promptYesNo(in, "Is the discoverer also the curator? (Y/N): ");

            // 5) Curator (reuse or prompt)
            Person curator = same ? discoverer : promptCurator(in);

            // 6) Build and print 3 line report
            Artifact artifact = new Artifact(name, year, discoverer, curator);
            System.out.println("\n ---- Artifact Report -----");
            System.out.println(artifact.toString());
        }
    }

    // helpers

    private static String promptNonBlank(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine();
            if (s != null && !s.isBlank()) return s.trim();
            System.out.println("Please enter a value.\n");
        }
    }

    private static int promptInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number (e.g., 1965).\n");
            }
        }
    }

    private static boolean promptYesNo(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine();
            if (s == null) continue;
            s = s.trim().toUpperCase();
            if (s.equals("Y") || s.equals("YES")) return true;
            if (s.equals("N") || s.equals("NO")) return false;
            System.out.println("Please answer Y or N.\n");
        }
    }

    private static Person promptPerson(Scanner in) {
        String first = promptNonBlank(in, "First Name: ");
        String last = promptNonBlank(in, "Last Name: ");
        String spec = promptNonBlank(in, "Primary specialty: ");
        return new Person(first, last, spec);
    }

    private static Person promptCurator(Scanner in) {
        System.out.println("\n-- Curator Info --");
        return promptPerson(in);
    }
}

// Pseudocode
// class Person:
// firstName, lastName, primarySpeciality
// getters, toString -> "First Last, Speciality"

// class Artifact:
// name, yearOfDiscovery, discoverer (Person), curator (Person)
// getters, toString -> 3 line report template

// App.main
// prompt name
// prompt year (int)
// prompt discoverer (first, last, speciality)
// ask if discoverer is also curator (y/n)
// if Y -> curator = discoverer
// else -> prompt curator (first, last, speciality)
// create Artifact and print its toString()