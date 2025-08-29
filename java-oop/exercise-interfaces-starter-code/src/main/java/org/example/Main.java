package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean listComplete = false;
        /*
        Before proceeding with the Main class, perform the following:
        1) Create three classes that implement the `Connectable` interface within the project.
            You should have the following devices:
            * TV
            * Fridge
            * Toaster
        2) Modify those classes to implement the desired behaviours within each:
            * Each class needs a property to capture the state, a boolean, to capture whether the device is on or off
            * Modify the methods as appropriate
            * The getName() method simply can return a hardcoded value representing the device type
        */

        // Define an array of devices to store 5 devices
        List<Connectable> connectables = new ArrayList<>();

        System.out.println("Welcome to the Device Manager App!!");
        System.out.println("===================================\n");


        System.out.println("Setup the devices");
        System.out.println("=================\n");
        // Loop through the array of devices
        // - Prompt user for device type to add
        // - Create the device instance
        // - Store the instance in the array
        while (!listComplete) {
            switch (promptInt("Select a Device to add: " +
                    "\n1. TV" +
                    "\n2. Refrigerator" +
                    "\n3. Toaster", 1, 3)) {
                case 1:
                    connectables.add(new Television());
                    break;
                case 2:
                    connectables.add(new Refrigerator());
                    break;
                case 3:
                    connectables.add(new Toaster());
                    break;
                default:
                    System.exit(0);
            }

            if(!promptString("Add Another Device (Y/N)").equalsIgnoreCase("Y")) {
                listComplete = true;
            }
        }


        listComplete = false;
        System.out.println("Interact with the devices");
        System.out.println("=========================\n");
        // Come up with a menu system which will provide the following:
        // Select the device (one of the 5 in our array)
        while (!listComplete) {
            switch (promptInt("Device Menu Options: " +
                        "\n1. Get Device Name" +
                        "\n2. Turn On Device" +
                        "\n3. Turn Off Device" +
                        "\n4. Get Device Status" +
                        "\n5. Quit", 1, 5)) {

                case 1:
                    System.out.println("Devices Connected: ");
                    for (Connectable connectable : connectables){
                        System.out.println(connectable.getName());
                    }
                    break;
                case 2:
                    System.out.println("Turning on Devices");
                    for (Connectable connectable: connectables) {
                        connectable.turnOn();
                    }
                    break;
                case 3:
                    System.out.println("Turning off Devices");
                    for (Connectable connectable : connectables){
                        connectable.turnOff();
                    }
                    System.out.println("All Devices are off");
                    break;
                case 4:
                    System.out.println("Device Statuses");
                    for (Connectable connectable : connectables){
                        if (connectable.getState()) {
                            System.out.println(connectable.getName() + " is on.");
                        } else {
                            System.out.println(connectable.getName() + " if off");
                        }
                    }
                    System.out.println("*****************************");
                    break;
                case 5:
                    // This process should continue until the user enters 5
                    System.out.println("\nThanks for using the Device Manager App. Bye!");
                    System.exit(0);
            }



        }
    }

    public static String promptString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine(); }

    // Utility method to prompt user for integer input
    public static int promptInt(String message) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {

            try {
                System.out.println(message);
                String input = sc.nextLine();
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }

    // Utility method to prompt user for integer input within a range
    public static int promptInt(String message, int min, int max) {
        int result = 0;

        boolean isValid = false;
        while (!isValid) {
            result = promptInt(message);
            if (result > max || result < min) {
                System.out.println("Entry out of range: " + min + " - " + max + ". Try again.");
            }
            else {
                isValid = true;
            }
        }
        return result;
    }
}