package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the shopping cart app!");

        // Create arrays to contain addresses and sizes

        // Shipping array
        String[] shippingAddresses = {
                "123 Main St",
                "456 Main St",
                "789 Main St"
        };

        // array for sizes (small, medium, large)
        String[] productSizes = {
                "small",
                "medium",
                "large"
        };

        // List contents of arrays so users can make:
        // numeric selection that start at 1 (not 0)
        // - show shipping addresses
        for (int i = 0; i < shippingAddresses.length; i++) {
            System.out.println((i + 1) + "." + shippingAddresses[i]);
        }

        // Prompt for shipping address
        System.out.print("\nShipping address?\n");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number (e.g., 1, 2, or 3).");
            scanner.next(); // discard invalid input
        }
        int addressChoice = scanner.nextInt();
        scanner.nextLine();

        if (addressChoice < 1 || addressChoice > shippingAddresses.length) {
            System.out.println("Invalid selection, Defaulting to option 1.");
            addressChoice = 1;
        }
        String selectedAddress = shippingAddresses[addressChoice - 1];

        // Prompt order quanity
        System.out.println("\nOrder Quantity\n");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a whole number for quantity (e.g., 1, 2, 3).");
            scanner.next(); // discard invalid input
        }
        int orderQuantity = scanner.nextInt();
        scanner.nextLine();

        // listing sizes
        for (int i = 0; i < productSizes.length; i++) {
            System.out.println((i + 1) + ". " + productSizes[i]);
        }

        // Prompt for size selection
        System.out.println("\nSize\n");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number (1 for small, 2 for medium, 3 for large).");
            scanner.next(); // discard invalid input
        }
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        if (sizeChoice < 1 || sizeChoice > productSizes.length) {
            System.out.println("Invalid selection. Defaulting to option 1.");
            sizeChoice = 1;
        }
        String selectedSize = productSizes[sizeChoice - 1];

        // prompt for promo code : FREE
        System.out.println("\nPromo code for free shipping?\n");
        String promoCode = scanner.nextLine();

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Shipping address: " + selectedAddress);
        System.out.println("Order quantity: " + orderQuantity);
        System.out.println("Size: " + selectedSize);
        System.out.println("Promo code: " + (promoCode.isEmpty() ? "(none)" : promoCode));

        System.out.println("Bye");
        scanner.close();
    }
}

