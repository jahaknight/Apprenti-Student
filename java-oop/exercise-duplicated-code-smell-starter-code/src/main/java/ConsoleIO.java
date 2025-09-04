import java.util.Scanner;

// Goal : get rid of input/validation code
// Single scanner for entire app
// One readLine(prompt) helper
// Reused loops for string and number parsing

public class ConsoleIO {

    // New: single shared Scanner for the whole class
    private final Scanner myScanner = new Scanner(System.in);

    public void writeMessage(String message) {
        System.out.println(message);
    }

    // New: helper to avoid repeating "print prompt -> read line"
    private String readLine(String prompt) {
        System.out.print(prompt + ": "); // print (not println) so cursor stays on the same line
        return myScanner.nextLine();
    }

    // New: non-null, non-empty String using the shared helper
    public String getNonNullNonEmptyString(String prompt) {
        boolean goodInput = false;
        String result = null;

        while (!goodInput) {
            result = readLine(prompt); // New: replace direct scanner usage
            if (result == null || result.isBlank()) {
                System.out.println("Enter a valid response.");
            } else {
                result = result.trim();
                goodInput = true;
            }
        }
        return result;
    }

    // NEW: generic numeric prompt we can reuse (eliminates duplicated loops)
    public double getDouble(String prompt) {
        while (true) {
            String line = readLine(prompt + " (number)");
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) { // specific exception
                System.out.println("Input a valid number");
            }
        }
    }

    // Keep public API but delegate to getDouble to remove duplication
    public double getMoney() {
        return getDouble("Enter the amount of cash on hand"); // fixed typos
    }
}

