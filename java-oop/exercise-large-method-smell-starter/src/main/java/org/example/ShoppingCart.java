package org.example;

public class ShoppingCart {

    public double checkoutShoppingCart(Item[] items, double taxRate, double discountCode) {
        double subtotal = calculateSubtotal(items);                 // 1) sum prices
        double discount = calculateDiscount(subtotal, discountCode);// 2) compute discount amount
        double taxable  = subtotal - discount;                      // 3) amount to tax
        double tax      = calculateTax(taxable, taxRate);           // 4) compute tax
        return taxable + tax;                                       // 5) final total
    }

    // Sum item prices; safely handles null arrays and null elements
    private double calculateSubtotal(Item[] items) {
        if (items == null) return 0.0;
        double subtotal = 0.0;
        for (Item item : items) {
            if (item != null) {
                subtotal += item.getPrice();
            }
        }
        return subtotal;
    }

    // Returns the discount AMOUNT given a subtotal and a discount rate
    private double calculateDiscount(double subtotal, double discountRate) {
        if (discountRate < 0) discountRate = 0;
        return subtotal * discountRate;
    }

    // Returns the tax AMOUNT for the given base using the tax rate
    private double calculateTax(double amount, double taxRate) {
        if (taxRate < 0) taxRate = 0;
        return amount * taxRate;
    }
}

