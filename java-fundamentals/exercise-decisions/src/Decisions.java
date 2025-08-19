import java.util.Scanner;

public class Decisions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true; // restart

        while (playAgain) { // outer loop to allow restarting
            //  Decisions Exercise
            //        Objective
            //        Create a text-based adventure game where the player explores a mysterious cave.
            //                Use if statements, else-if chains, nested ifs, and switch statements to control the
            //        story and outcomes.
            //                Requirements
            //        Your game should include:

            // Welcome Message
            System.out.println("Welcome, adventurer! Do you have what it takes to explore the dark cave?");
            // STEP 1: enter the cave (force valid yes/no )
            String enterCave;
            while (true) {
                System.out.println("The decision is yours. Do you want to enter the cave? (yes/no)");
                enterCave = scanner.nextLine().toLowerCase().trim();
                if (enterCave.equals("yes") || enterCave.equals("no")) break;
            }

            // 1. A starting prompt where the player chooses to enter the cave or leave.
            if (enterCave.equals("yes")) {
                // STEP 2: choose path (force valid left/right, using your exact prompt)
                String path;
                while (true) {
                    System.out.println("Inside the cave, you see two paths. Which path is your destiny? Left or Right?");
                    path = scanner.nextLine().toLowerCase().trim();
                    if (path.equals("left") || path.equals("right")) break;
                }

                // 2. A decision inside the cave (e.g., choosing between two paths: left or right).
                if (path.equals("left")) {
                    // 3. A nested decision (fight or flee) — force valid input, keep your exact text
                    String action;
                    while (true) {
                        //        3. A nested decision inside one of the paths (e.g., fight or flee from a mysterious
                        //        figure).
                        System.out.println("A mysterious figure has appeared! Do you want to fight or flee?");
                        action = scanner.nextLine().toLowerCase().trim();
                        if (action.equals("fight") || action.equals("flee")) break;
                    }

                    if (action.equals("fight")) {
                        System.out.println("You have bravely fought the Metapod!!");
                    } else if (action.equals("flee")) {
                        System.out.println("You barely escaped but you are SAFE!");
                    } else {
                        System.out.println("Invalid choice. The Metapod disappears, leaving you confused");
                    }

                } else if (path.equals("right")) {
                    // 4. Switch statement artifact menu — keep your exact text; force valid 1..3
                    //        4. A switch statement allowing the player to select an artifact with different
                    //        outcomes.
                    while (true) {
                        System.out.println("You found a treasure room! Choose an articfact: ");
                        System.out.println("1. Gem");
                        System.out.println("2. Key");
                        System.out.println("3. Book");

                        String line = scanner.nextLine().trim();
                        int artifactChoice;
                        try {
                            artifactChoice = Integer.parseInt(line);
                        } catch (NumberFormatException e) {
                            continue; // re-show your same menu until a number is entered
                        }
                        if (artifactChoice < 1 || artifactChoice > 3) {
                            continue; // re-show your same menu until 1..3
                        }

                        switch (artifactChoice) {
                            case 1:
                                System.out.println("The gem glows brightly, granting you wealth!");
                                break;
                            case 2:
                                System.out.println("The key unlocks a hidden door, leading you to freedom!!");
                                break;
                            case 3:
                                System.out.println("The Book unlocks a hidden message");
                                break;
                            default:
                                System.out.println("Invalid choice. The artifacts disappear and crumble into dust.");
                        }
                        break; // leave the artifact loop after a valid choice is handled
                    }
                } else {
                    System.out.println("You wander and get lost in the dark");
                }

            } else if (enterCave.equals("no")) {
                System.out.println("You walk away, never knowing what lays inside");
            } else {
                System.out.println("You wait too long. The cave collapses. Game over");
            }

            // End of Game (your text kept exactly)
            System.out.println("Thank you for exploring great adventurer!!");

            // Restart prompt (new line added; does not change your existing messages)
            String again;
            while (true) {
                System.out.print("Would you like to play again? (yes/no): ");
                again = scanner.nextLine().toLowerCase().trim();
                if (again.equals("yes") || again.equals("no")) break;
            }
            playAgain = again.equals("yes");
        }

        scanner.close();
    }
}

