// Dream Team: 👩🏾‍💻🧑🏼‍💻👩🏻‍💻👨🏼‍💻
// Jaha: 👩🏾‍💻
// Spencer: 👨🏼‍💻
// Gloria: 👩🏻‍💻
// Adam: 🧑🏼‍💻

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class StorageLocker{

    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final Random RNG = new Random();
    enum LockerAction {
        ACCESS,
        RELEASE
    }
    // Initialize Variables
    static final int NUM_OF_LOCKERS = 20;
    static String[] lockers = new String[NUM_OF_LOCKERS];
    static int lockersAvailable = NUM_OF_LOCKERS;
    static boolean exit = false;

    public static void main(String[] args) {

        System.out.println("Welcome to Lockdown Inc. Storage Locker App 🔐");

        // Main Control Loop
        while (!StorageLocker.exit){
            displayMainMenu(lockersAvailable);
            int choice = getInputFromUser();
            switch (choice){
                // Rent Locker
                case 1:
                    if (lockersAvailable == 0){
                        System.out.println("No lockers available to rent");
                        break;
                    }
                    rentLocker(lockers, lockersAvailable);
                    break;
                // Access Locker
                case 2:
                    handleLocker(lockers, lockersAvailable, LockerAction.ACCESS);
                    break;
                // Release Locker
                case 3:
                    handleLocker(lockers, lockersAvailable, LockerAction.RELEASE);
                    break;
                // Exit Program
                default:
                    StorageLocker.exit = true;

            }
        }
    }

    // Display Menu
    private static void displayMainMenu(int lockersAvailable) {
        System.out.println("What would you like to do next?");
        // Only show rented lockers if lockers are available
        if (lockersAvailable != 0){
            System.out.println("[1] Rent a Locker");
        } else {
            System.out.println("No lockers available to rent");
        }
        System.out.println("[2] Access a Locker");
        System.out.println("[3] Release a Locker");
        System.out.println("---");
        System.out.println("Any other key to exit.");
    }
    // Ensure input is integer
    private static int getInputFromUser() {
        try {
            return Integer.parseInt(CONSOLE.nextLine());

        } catch (Exception e) {
            return -1;
        }

    }

    // Renting Locker
    private static void rentLocker(String[] lockers, int lockersAvailable){
        int pin = RNG.nextInt(10000);
        // Add leading zeroes to ensure 4 digit pin
        String formattedPin = String.format("%04d", pin);
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null){
                // Update locker variables
                lockers[i] = formattedPin;
                StorageLocker.lockersAvailable--;
                System.out.println("Locker assigned: " + ( i+ 1));
                System.out.println("Your PIN: " + formattedPin + ", Remember your pin!! 🔢 ");
                return;
            }

        }
        System.out.println("No Locker Found");
    }

    // Handle Locker Feature:
    // Method will access or release locker based on locker action
    private static void handleLocker(String[] lockers, int lockersAvailable, LockerAction action){
        int lockerNumber;
        String pin;
        // Prompt Locker number (valid range)
        System.out.println("What is your Locker number? ");
        while(true){
            lockerNumber = getInputFromUser();
            // Check if it's in rented
            try {
                if (lockers[lockerNumber - 1] != null){
                    break;
                } else {
                    System.out.println("Locker is not rented. Please re-enter locker number: ");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a valid locker number. 1 - " + lockers.length);
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }

        }
        // Prompt Pin and verify
        System.out.println("What is your pin?");
        while (true){
            pin = CONSOLE.nextLine();
            if (pin.equals(lockers[lockerNumber - 1])){
                if (action == LockerAction.ACCESS) {
                    System.out.println("Success!!! Make sure your personal belongings are secured 🔒");
                    return;
                }
                break;
            } else {
                System.out.println("Incorrect Pin. Try Again.");
            }
        }

        // Release a Locker Feature:
        // Confirm "Are you sure?" (y/n)
        // Clear the locker (set to null) if confirmed
        System.out.println("Are you sure you want to release this locker?");
        while(true) {
            System.out.println(" Enter (y/n): ");
            String input = CONSOLE.nextLine().toLowerCase();
            if (input.equals("y")) {
                lockers[lockerNumber - 1] = null;
                StorageLocker.lockersAvailable++;
                System.out.println("Success! Locker is now available. Pin has been reset.");
                break;
            } else if (input.equals("n")) {
                break;
            }
            System.out.println("Please answer y/n.");
        }

    }
}

        // PSEUDOCODE
        /*
        1. display menu
            show options: rent, access, release
            if no lockers available hide RENT option
            exit on any other key input
        2. rent a locker
            assign next available locker
            generate 4-digit PIN (as string WITH leading/trailing zeros)
            store locker/PIN in array
        3. access a locker
            prompt user for locker/PIN
            validate inputs against stored data
            grant access or error
        4. release a locker
            prompt user for locker/PIN
            confirm user action (are you sure you want to release locker x?)
            clear data from array
            error for incorrect PIN/locker
        5. initialize lockers array
            create array with null values
            allow configurable size (at startup)
        6. generate PIN with leading/trailing zeros
            random 4-digit string
            ensure it preserves leading zeros
        7. DRY refactoring with methods
        8. input validation and error handling
        9. display helpful error messages
            invalid input, wrong PIN, unavailable lockers etc.
        10. update menu based on locker availability
            hide "RENT" if lockers are full


        int arraySize;
        int lockers[arraySize] -> set values to null
        int lockersAvailable = arraySize

        display menu options: [1] RENT, [2] ACCESS, [3] RELEASE
            if lockersAvailable = 0 then do not display RENT
        userInput = get user input
        if userInput = RENT then
            find first element in lockers[] where the value is null
            generate PIN ->
                loop 4 times:
                    create random digit and add to string
                return PIN string
            store PIN in lockers array at
            print "thank you" and give user locker instructions
            end (go back to menu)

        else if userInput = ACCESS then
            lockerNumber = input user for locker number
            confirm locker is rented
            PIN = input user for PIN number
            if lockers[lockerNumber] = PIN then
                grant access
            else
                error message
            end (go back to menu)

        else if userInput = RELEASE then
            lockerNumber = input user for locker number
            confirm locker is rented
            userConfirmation = prompt user (are they sure they want to release locker)
            if userConfirmation = 'yes' then
                set lockers[lockerNumber] to null (deletes PIN and opens locker up for renting)
            else if userConfirmation = 'no' then
                print(the locker has not been released)
            end (go back to menu)
        else
            exit program
         */

        /*
        NOTE:
        validate all inputs from users so that they are correct/formatted as needed


        METHODS:
        prompt user for locker and validate it is rented
        prompt user for PIN and validate it is correct
        display menu
        prompt user for menu selection
         */