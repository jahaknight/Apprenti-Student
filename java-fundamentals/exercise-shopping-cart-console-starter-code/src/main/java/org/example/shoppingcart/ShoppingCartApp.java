package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        // 0) Create the Scanner
        Scanner scanner = new Scanner(System.in);

        // 1) Prompt for tax-exempt
        System.out.print("Are you tax-exempt? (y/n) ");
        String taxExempt = scanner.nextLine();

        // 2) Prompt for shipping
        System.out.print("Shipping? (y/n) ");
        String shipping = scanner.nextLine();

        // 3) Prompt for order quantity
        System.out.print("Order quantity? ");
        int orderQuantity = scanner.nextInt();
        scanner.nextLine();

        // 4) Prompt for promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = scanner.nextLine();

        // 5) Print details
        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shipping);
        System.out.println("Order quantity: " + orderQuantity);
        System.out.println("Promo code: " + promoCode);

        System.out.println("Bye");
        scanner.close();
    }
}

