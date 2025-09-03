package org.example;

import java.util.Scanner;

public final class ConsoleIO {

    // Shared Scanner
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleIO() { /* no instances */ }

    public static void display(String message) {
        System.out.println(message);
    }

    public static String promptString(String message) {
        while (true) {
            System.out.print(message + ": ");  // keep cursor on the same line
            String line = SCANNER.nextLine();
            if (line != null && !line.isBlank()) {
                return line.trim();
            }
            System.out.println("Please enter a non-empty value.");
        }
    }

    public static double promptDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(promptString(message)); // reuses promptString
            } catch (NumberFormatException ex) {
                display("Invalid number. Try again.");
            }
        }
    }
}

