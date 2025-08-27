import java.util.Scanner;

public class AquariumTracker {
    private static final Scanner CONSOLE = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the information for your fish.");

        // Object that will hold all data
        AquariumFish fish = new AquariumFish();

        // Gather inputs and set object
        fish.setSpecies(promptLine(" Species Name: "));
        fish.setCommonName(promptLine("Common Name: "));
        fish.setMaxTemp(promptDouble("Maximum Temperature: "));
        fish.setMinTemp(promptDouble("Minimum Temperature: "));
        fish.setDiet(promptLine(" Diet: "));

        // print
        System.out.println();
        System.out.println("Summary");
        System.out.println("=======");
        System.out.println(fish.toString());
        System.out.printf("Average Temperature: %.2f%n", fish.getAverageTemp());
    }

    // Help to keep main clean
    private static String promptLine(String prompt) {
        System.out.println(prompt);
        return CONSOLE.nextLine();
    }

    private static double promptDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = CONSOLE.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number (decimals allowed).");
            }
        }
    }
}
