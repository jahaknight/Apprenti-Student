package org.example.shoppingcart;
import java.util.Scanner;

/**
 * If tax exempt don't charge tax.
 * If order total is more than $100 apply discount 5%
 * If order total is more than $500 apply discount 10%
 * If promo code is valid, apply free shipping (unless next-day or 2-day)
 */
public class ShoppingCartApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // constants
        final double TAX_RATE = 0.07;
        final double STANDARD_SHIPPING = 2.00;
        final double TWO_DAY_SHIPPING = 5.00;
        final double OVERNIGHT_SHIPPING = 10.00;

        System.out.println("Welcome to the shopping cart app!");

        double productPrice = 4.99;
        int productQuantity = 78;
        double totalCost = productPrice * productQuantity; // subtotal before discounts/tax/shipping

        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Quantity: " + productQuantity);
        System.out.println("Total Cost: " + totalCost);

        // Prompt for tax exempt
        System.out.print("Are you tax-exempt? (y/n) ");
        String taxExempt = scanner.nextLine().trim();

        // Prompt for shipping
        System.out.print("Shipping? (standard / overnight / two-day) ");
        String shipping = scanner.nextLine().trim();

        // Prompt for promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = scanner.nextLine().trim();

        // Calculations
        double subtotal = totalCost;

        // Discounts
        double discountRate;
        if (subtotal > 500.00) {
            discountRate = 0.10;     // 10%
        } else if (subtotal > 100.00) {
            discountRate = 0.05;     // 5%
        } else {
            discountRate = 0.00;
        }
        double discountAmount = subtotal * discountRate;
        double discountedSubtotal = subtotal - discountAmount;

        // Tax (skip if tax exempt)
        boolean isTaxExempt = taxExempt.equalsIgnoreCase("y") || taxExempt.equalsIgnoreCase("yes");
        double tax = isTaxExempt ? 0.0 : discountedSubtotal * TAX_RATE;

        // Shipping
        String ship = shipping.toLowerCase();
        double shippingCost;
        switch (ship) {
            case "standard" -> shippingCost = STANDARD_SHIPPING;
            case "two-day", "2-day", "two day", "two_day" -> shippingCost = TWO_DAY_SHIPPING;
            case "overnight", "next-day", "next day" -> shippingCost = OVERNIGHT_SHIPPING;
            default -> {
                System.out.println("Unrecognized shipping method; defaulting to standard.");
                shippingCost = STANDARD_SHIPPING;
                ship = "standard";
            }
        }

        // Promo : FREE (only for standard)
        if (promoCode.equalsIgnoreCase("FREE") && ship.equals("standard")) {
            shippingCost = 0.0;
        }

        double grandTotal = discountedSubtotal + tax + shippingCost;

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shipping);
        System.out.println("Promo code: " + (promoCode.isEmpty() ? "(none)" : promoCode));

        // Formatted breakdown
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount (%.0f%%): -$%.2f%n", discountRate * 100, discountAmount);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Shipping Cost: $%.2f%n", shippingCost);
        System.out.println("---------------------");
        System.out.printf("Total: $%.2f%n", grandTotal);

        System.out.println("Bye");
        scanner.close();
    }
}
