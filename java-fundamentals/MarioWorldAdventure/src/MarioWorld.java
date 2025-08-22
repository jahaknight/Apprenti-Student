import java.util.Random;
import java.util.Scanner;

public class MarioWorld {

    // ====== Global Scanner (single instance) ======
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    // ====== Game State Arrays ======
    // 5 distinct locations (excluding Bowser & Exit)
    private static final String[] LOCALE_NAMES = {
            "Toad's House 🍄",
            "Luigi's Mansion 🏯",
            "Yoshi's Island 🦖",
            "Princess Peach's Garden 🌸",
            "Toadette's Workshop 🛠️"
    };

    // First-visit narrative (index-aligned to LOCALE_NAMES)
    private static final String[] FIRST_VISIT_LINES = {
            // Toad's House
            "You have entered Toad's House 🍄\nFind Toad under a Mushroom... You found Toad!",
            // Luigi's Mansion
            "You have entered Luigi's Mansion 🏯",
            // Yoshi's Island
            "You have arrived at Yoshi's Island 🦖",
            // Princess Peach's Garden
            "You stroll into Princess Peach's Garden 🌸",
            // Toadette's Workshop
            "Clink! Clank! Toadette's Workshop 🛠️"
    };

    // Revisit narrative (index-aligned to LOCALE_NAMES)
    private static final String[] REVISIT_LINES = {
            "You have entered Toad's House 🍄\nThis looks familiar...you've been here before. 🤔",
            "You have entered Luigi's Mansion 🏯\nCobwebs look rearranged… but you've been here.",
            "Back on Yoshi's Island 🦖\nThe waves look the same as last time.",
            "Princess Peach's Garden 🌸\nYou've walked these paths before.",
            "Toadette wipes a wrench: \"Back again, huh?\" 🛠️"
    };

    // Track whether each locale has been visited
    private static final boolean[] visited = new boolean[LOCALE_NAMES.length];

    // Track Stars earned per locale (parallel to visited)
    private static final boolean[] starEarned = new boolean[LOCALE_NAMES.length];

    public static void main(String[] args) {

        // ====== Initialize Variables ======
        boolean running = true;

        System.out.println("   Welcome to Mario World 🕹️   ");
        System.out.println(" ⭐️ Collect 5 Stars to unlock Bowser's Castle ⭐️ ");
        System.out.println("\nYou've landed at Mario's Museum! There are paintings in front of you: ");
        // ====== Main Hub Loop ======
        while (running) {
            // Hub Menu
            System.out.println("Which painting would you like to jump into? 🖌️");
            // 1..N locales from array
            for (int i = 0; i < LOCALE_NAMES.length; i++) {
                System.out.println("[" + (i + 1) + "] " + LOCALE_NAMES[i]);
            }
            // Bowser and Exit come after locales
            int bowserMenuNumber = LOCALE_NAMES.length + 1;
            int exitMenuNumber = LOCALE_NAMES.length + 2;

            System.out.println("[" + bowserMenuNumber + "] Bowser's Castle 🏰 (locked until you have 5 Stars)");
            System.out.println("[" + exitMenuNumber + "] Exit 🏃🏽‍♂️");
            System.out.print("Enter a number (1-" + exitMenuNumber + "): ");

            // ====== Read menu choice with exception handling ======
            Integer choice = readIntOrNull();
            if (choice == null) {
                // Invalid (non-numeric) -> return to start of the menu (per lab)
                System.out.println("Invalid input. Returning to menu.");
                continue;
            }

            // ====== Process Menu Choice ======
            if (choice >= 1 && choice <= LOCALE_NAMES.length) {
                // Visit one of the 5 locales
                visitLocale(choice - 1);
            } else if (choice == bowserMenuNumber) {
                // Visit Bowser's Castle (must have 2 stars)
                if (totalStars() >= 5) {
                    visitBowser();
                    // After Bowser round, offer restart
                    running = askPlayAgainOrQuit();
                } else {
                    System.out.println("You bounced off the paintings!");
                    System.out.println(" ⭐ 5 Stars must be collected to enter ⭐️ ");
                }
            } else if (choice == exitMenuNumber) {
                // Exit Game
                running = false;
            } else {
                // Out-of-range -> return to menu (you could message here if you want)
                System.out.println("Please enter a valid menu option.");
            }
        }

        // ====== Ending ======
        System.out.println("\nThanks for visiting Mario's Museum!!!");
    }

    // ==========================
    // Helper: total stars earned
    // ==========================
    private static int totalStars() {
        int sum = 0;
        for (boolean s : starEarned) {
            if (s) sum++;
        }
        return sum;
    }

    // =========================================
    // Helper: robust integer read with try/catch
    // - Returns null if parse fails (lab: go back
    //   to menu instead of crashing)
    // =========================================
    private static Integer readIntOrNull() {
        String line = in.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (Exception e) {
            return null;
        }
    }

    // ==================================================
    // Visit a locale by index (arrays drive the content)
    // - Uses first-visit vs revisit text from arrays
    // - Each locale has a small interaction to earn Star
    // ==================================================
    private static void visitLocale(int index) {
        if (visited[index]) {
            System.out.println(REVISIT_LINES[index]);
            // Already visited; nothing more needed
            if (starEarned[index]) {
                return;
            }
        }
        else {
            System.out.println(FIRST_VISIT_LINES[index]);
        }

        // First visit path
        switch (index) {
            case 0: // Toad's House 🍄 — simple ask
                System.out.println("Ask Toad for the Star: ");
                // Read anything; Toad gives a Star
                in.nextLine();
                System.out.println("Toad hands you a Star ⭐️ Nice!");
                starEarned[index] = true;
                break;

            case 1: // Luigi's Mansion 🏯 — guess ghost count
                int numberOfGhosts = random.nextInt(10) + 1; // 1..10
                for (int i = 0; i < numberOfGhosts; i++) System.out.print("👻");
                System.out.print("\nGuess the number of Ghosts 👻 to collect Star: ");
                while (true) {
                    Integer guess = readIntOrNull();
                    if (guess == null) {
                        System.out.print("Invalid input. Enter a number: ");
                        continue; // re-ask here (mini-game loop only)
                    }
                    if (guess == numberOfGhosts) {
                        System.out.println("You guessed correctly!! You get a Star ⭐️");
                        starEarned[index] = true;
                        break;
                    } else {
                        System.out.print("Guess Again: ");
                    }
                }
                break;

            case 2: // Yoshi's Island 🦖 — simple word choice
                System.out.println("Yoshi loves fruit! Type the fruit he's thinking of (apple/berry/banana): ");
                String fruit = "";
                while(true) {
                    fruit = in.nextLine().trim().toLowerCase();
                    if (fruit.equals("banana") || fruit.equals("apple") || fruit.equals("berry")) {
                        System.out.println("Yoshi is thrilled! You get a Star ⭐️");
                        starEarned[index] = true;
                        break;
                    } else {
                        System.out.println("Yoshi tilts his head… maybe next time! (No Star). Please enter valid fruit option: ");
                    }
                }

            case 3: // Princess Peach's Garden 🌸 — count roses
                System.out.println("Count the roses to impress Peach and earn a Star!");
                int roses = random.nextInt(5) + 5; // 5..9
                for (int i = 0; i < roses; i++) System.out.print("🌹");
                System.out.print("\nHow many roses did you count? ");
                Integer count = readIntOrNull();
                if (count != null && count == roses) {
                    System.out.println("Perfect! Peach awards you a Star ⭐️");
                    starEarned[index] = true;
                } else {
                    System.out.println("So close! Peach smiles anyway. (No Star)");
                }
                break;

            case 4: // Toadette's Workshop 🛠️ — mini math
                System.out.println("Solve a quick gear math to get a Star.");
                int a = random.nextInt(6) + 2; // 2..7
                int b = random.nextInt(6) + 2; // 2..7
                System.out.print("Tighten gear ratio! What is " + a + " × " + b + "? ");
                Integer prod = readIntOrNull();
                if (prod != null && prod == a * b) {
                    System.out.println("Perfect fit! Toadette grants you a Star ⭐️");
                    starEarned[index] = true;
                } else {
                    System.out.println("Hmm, gears slip… try again next time. (No Star)");
                }
                break;

            default:
                // Should never happen
                break;
        }

        visited[index] = true;
    }

    // ==================================
    // Bowser's Castle (requires 5 Stars)
    // ==================================
    private static void visitBowser() {
        System.out.println("\nCongratulations you have unlocked Bowser's Castle!! 🏰");
        System.out.println("Fight Bowser to save Princess Peach 👸🏼");
        System.out.println("[1] Ground Pound 🧱");
        System.out.println("[2] Fire Ball ☄️");
        System.out.println("[3] Star Power 🌟");
        System.out.print("Choose your move (1-3): ");

        Integer move = readIntOrNull();
        if (move == null) {
            System.out.println("Invalid input. Bowser laughs… You Lose ❌");
            return;
        }

        if (move == 1) {
            System.out.println("Ground Pound was blocked by Bowser's shell.");
            System.out.println("You Lose ❌");
        } else if (move == 2) {
            System.out.println("Fire doesn't work on Bowser 🔥");
            System.out.println("You Lose ❌");
        } else if (move == 3) {
            System.out.println("Star power destroys Bowser 💫🐢!!!");
            System.out.println("You've saved Princess Peach! 👸🏼 You Won 🏆");
        } else {
            System.out.println("You hesitate… Bowser strikes! You Lose ❌");
        }
    }

    // ==========================================================
    // Ask to play again; if yes, reset arrays and continue game
    // ==========================================================
    private static boolean askPlayAgainOrQuit() {
        boolean playAgainValid = false;
        boolean playAgain = false;
        while (!playAgainValid) {
            System.out.print("Play Again? (y/n) 🕹️ ");
            String gameRestart = in.nextLine().trim();
            if (gameRestart.equalsIgnoreCase("y")) {
                // reset state
                for (int i = 0; i < visited.length; i++) {
                    visited[i] = false;
                    starEarned[i] = false;
                }
                playAgainValid = true;
                playAgain = true; // keep running
            } else if (gameRestart.equalsIgnoreCase("n")) {
                playAgainValid = true;
                playAgain = false; // stop running
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return playAgain;
    }
}

