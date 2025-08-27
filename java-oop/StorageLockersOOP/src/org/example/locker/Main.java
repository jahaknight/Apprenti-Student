package org.example.locker;
// Console app for managing storage lockers
// Menu :
// 1. Add Locker
// 2. Remove Locker
// 3. Store item in locker
// 4. Retrieve item from locker
// 5. Display all lockers
// 6. Exit

import java.util.Scanner;

public class Main {
    // One scanner for app
    private static final Scanner CONSOLE = new Scanner(System.in);

    // One manager that holds list of all lockers
    private static final LockerManager manager = new LockerManager();

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Welcome to Lockdown Inc. - Locker Manager 🔐");

        while (!exit) {
            printMenu();
            int choice = promptInt("Choose an option (1-6): ");
            switch (choice) {
                case 1 -> addLockerFlow();
                case 2 -> removeLockerFlow();
                case 3 -> storeItemFlow();
                case 4 -> retrieveItemFlow();
                case 5 -> manager.displayAllLockers();
                case 6 -> {
                    System.out.println("Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Please select a valid option (1-6).");
            }
            System.out.println();
        }
    }
    // Menu
    private static void printMenu() {
        System.out.println("---------------");
        System.out.println("1) Add locker");
        System.out.println("2) Remove locker");
        System.out.println("3) Store item in locker");
        System.out.println("4) Retrieve item from locker");
        System.out.println("5) Display all lockers");
        System.out.println("6) Exit");
        System.out.println("---------------");
    }

    // call LockerManager and Locker
    private static void addLockerFlow() {
        String id = promptNonBlank("Enter new locker ID ( ex., J-101): ");
        manager.addLocker(id);
    }

    private static void removeLockerFlow() {
        String id = promptNonBlank("Enter locker ID to remove: ");
        manager.removeLocker(id);
    }

    private static void storeItemFlow() {
        String id = promptNonBlank("Enter locker ID to store an item: ");
        Locker l = manager.getLocker(id);
        if (l == null) {
            System.out.println("Locker " + id + " not found.");
            return;
        }
        if (l.isOccupied()) {
            System.out.println("Locker " + id + " is already occupied with: " + l.getContents());
            return;
        }

        String item = promptNonBlank("Enter item to store (description): ");
        try {
            l.storeItem(item);
            System.out.println("Stored in " + id + ".");
        } catch (IllegalArgumentException ex) {
            System.out.println("Could not store item: " + ex.getMessage());
        }
    }

    private static void retrieveItemFlow() {
        String id = promptNonBlank("Enter Locker ID to retrieve from: ");
        Locker l = manager.getLocker(id);
        if (l == null) {
            System.out.println("Locker " + id + " not found.");
            return;
        }
        if (!l.isOccupied()) {
            System.out.println("Locker " + id + " is already empty.");
            return;
        }

        // add y/n option
        if (!confirmYesNo("Are you sure you want to empty locker " + id + "?")) {
            System.out.println("Canceled");
            return;
        }

        String removed = l.removeItem();
        System.out.println("Retrieved: " + removed);
        System.out.println("Locker " + id + " is now empty.");
    }

    // Clean up
    // Tried using print instead of println b/c learned that does impact where the cursor lands

    // Prompt for any line of text
    private static String promptLine(String prompt) {
        System.out.print(prompt);
        return CONSOLE.nextLine();
    }

    // Prompt for non-blank line
    private static String promptNonBlank(String prompt) {
        while (true) {
            String s = promptLine(prompt).trim();
            if (!s.isEmpty()) return s;
            System.out.print("Please enter a non-blank value.");
        }
    }

    // Prompt for integer
    private static int promptInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = CONSOLE.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    // y/n confirmation
    private static boolean confirmYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String ans = CONSOLE.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) return true;
            if (ans.equals("n") || ans.equals("no")) return false;
            System.out.println("Please answer y or no.");
        }
    }
}
