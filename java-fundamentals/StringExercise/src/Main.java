//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        part1_BasicStringOps();
        part2_ExtractingParts();
        part3_SplittingStrings();
        part4_ReplacingCharacters();
        part5_NullAndEmpty();
    }

    // Part 1 : Basic String Operations
    private static void part1_BasicStringOps() {
        System.out.println("=== Part 1: Basic String Operations ===");

        // 1. Declare and assign
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;

        // 2. Print fullName
        System.out.println("Full name: " + fullName);

        // 3. Length
        int length = fullName.length();
        System.out.println("Length: " + length);

        // 4. First character
        char firstChar = fullName.charAt(0);
        System.out.println("First Character: " + firstChar);

        // 5. Index of 'r'
        int indexOfR = fullName.indexOf('r');
        System.out.println("Index of 'r': " + indexOfR);

        System.out.println();
    }

    // Part 2: Extracting Parts of a String
    private static void part2_ExtractingParts() {
        System.out.println("=== Part 2: Extracting Parts of a String ===");
        String sentence = "Learning Java is fun!";

        String firstWord = sentence.substring(0, 8);   // "Learning"
        String secondWord = sentence.substring(9, 13); // "Java"
        int lastSpace = sentence.lastIndexOf(' ');
        String lastWord = sentence.substring(lastSpace + 1); // "fun!"

        System.out.println("First word: " + firstWord);
        System.out.println("Second word: " + secondWord);
        System.out.println("Last word: " + lastWord);
        System.out.println();
    }

    // Part 3: Splitting Strings
    private static void part3_SplittingStrings() {
        System.out.println("=== Part 3: Splitting Strings ===");
        String csv = "apple,banana,grape,orange";
        String[] fruits = csv.split(",");

        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Fruit " + (i + 1) + ": " + fruits[i]);
        }
        System.out.println();
    }

    // Part 4: Replacing Characters
    private static void part4_ReplacingCharacters() {
        System.out.println("=== Part 4: Replacing Characters ===");
        String sentence = "The quick brown fox.";
        String modified = sentence.replace("quick", "slow").replace(' ', '_');
        System.out.println("Modified sentence: " + modified);
        System.out.println();
    }

    // Part 5: Handling Null and Empty Strings
    private static void part5_NullAndEmpty() {
        System.out.println("=== Part 5: Handling Null and Empty Strings ===");
        String maybeNull = null;

        if (maybeNull == null) {
            System.out.println("The string is null, cannot compute length.");
        } else {
            System.out.println("Length: " + maybeNull.length());
        }

        String empty = "";
        System.out.println("Empty string length: " + empty.length());
        System.out.println();
    }
}
