package org.example;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * File I/O:
 * Part 1: Create a file with java.io.File
 * Part 2: Write text lines (overwrite)
 * Part 3: Append new lines
 * Part 4: Read the file line-by-line
 * Part 5: Show absolute vs relative
 * Part 6: Delete file
 */

public class FileIOExercise {

    private static final String STUDENT_FILE = "student_data.text";
    private static final String USER_LOG_FILE = "user.log.txt";

    public static void main(String[] args) {
        try {
            // Part 1 : Create a file
            File f = createStudentFile(STUDENT_FILE);

            // Part 2: Write initial data (overwrite content)
            writeStudentOverwrite(f);

            // Part 3: Append more data
            appendStudents(f);

            // Part 4: Read the file line-by-line
            readStudents(f);

            // Part 5: Path exploration
            showPaths(f);

            // Part 6: Delete file
            deleteStudentFile(f);

            // Bonus :
            runLoggerDemo();
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    // Part 1: Create a new file
    /**
     * Uses java.io.File to create "student_data.txt"
     *
     */

    private static File createStudentFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("[Part 1] Created new file?" + file.getAbsolutePath());
        } else {
            boolean created = file.createNewFile(); // true if created, false if already exisits
            System.out.println("[Part 1] Created new file?" + created + " -> " + file.getAbsolutePath());
        }
        return file;
    }

    // Part 2 : Write Data (overwrite)
    private static void writeStudentOverwrite(File file) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, false))) {
            out.write("Alice, A");
            out.newLine();
            out.write("Bob, B");
            out.newLine();
            out.write("Charlie, A+");
            out.newLine();
        }
        System.out.println("[Part 2] Wrote initial data (overwrote file).");
    }

    // Part 3 : Append Data
    private static void appendStudents(File file) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
            out.write("David, B+");
            out.newLine();
            out.write("Eva, A");
            out.newLine();
        }
        System.out.println("[Part 3] Appended extra student data.");
    }

    // Part 4 : Read data
    private static void readStudents(File file) throws IOException {
        System.out.println("[Part 4] Reading file");
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(" " + line);
            }
        }
        System.out.println("[Part 4] Done reading.");
    }

    // Part 5 : Paths
    private static void showPaths(File file) {
        Path projectDir = Paths.get("").toAbsolutePath(); // Current working directory
        Path absolute = file.toPath().toAbsolutePath();
        Path relative = projectDir.relativize(absolute);

        System.out.println("[Path 5] Working dir (project): " + projectDir);
        System.out.println("[Part 5] Absolute path:         " + absolute);
        System.out.println("[Part 5] Relative path:         " + relative);
        System.out.println("[Part 5] Absolute vs Relative: Absolute is full path from root; Relative is 'from here'.");
    }

    // Part 6: Delete
    private static void deleteStudentFile(File file) {
        boolean deleted = file.delete();
        System.out.println("[Part 6] Deleted file?" + deleted + "->" + file.getAbsolutePath());
    }

    // Bonus Challenge:
    private static void runLoggerDemo() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Bonus : User Logger ===");
        System.out.println("This writes to: " + Paths.get(USER_LOG_FILE).toAbsolutePath());

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. View Log");
            System.out.println("2. Add entry");
            System.out.println("3. Exit bonus");
            System.out.println("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> viewLog();
                case "2" -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine().trim();
                    System.out.println("Enter your action");
                    String action = sc.nextLine().trim();
                    appendLog(name, action);
                }
                case "3" -> running = false;
                default -> System.out.println("Unknown choice, try 1, 2, or 3.");
            }
        }
        System.out.println("Exiting bonus logger.");
    }

    // Appends one line to user_log.txt
    private static void appendLog(String name, String action) throws IOException {
        Path logPath = Paths.get(USER_LOG_FILE);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("\"yyyy-MM-dd HH:mm:ss\"");
        String timestamp = LocalDateTime.now().format(fmt);

        try (BufferedWriter out = Files.newBufferedWriter(
                logPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            out.write(name + " | " + action + " | " + timestamp);
            out.newLine();
        }
        System.out.println("Appended log entry for" + name + ".");
    }

    // Reads whole log and prints
    private static void viewLog() throws IOException {
        Path logPath = Paths.get(USER_LOG_FILE);
        if (!Files.exists(logPath)) {
            System.out.println("(No log yet. Perform an action to create one).");
            return;
        }
        System.out.println("--- Log contents ---");
        List<String> lines = Files.readAllLines(logPath);
        if (lines.isEmpty()) {
            System.out.println("(Log file is empty)");
        } else {
            for (String line : lines) {
                System.out.println(" " + line);
            }
        }
        System.out.println("--- End of log ---");
    }
}
