package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Build tiny cart
        Item apple = new Item();
        apple.setName("Apple");
        apple.setPrice(1.25);

        Item milk = new Item();
        milk.setName("Milk");
        milk.setPrice(3.49);

        Item chips = new Item();
        chips.setName("Chips");
        chips.setPrice(2.99);

        Item[] items = { apple, milk, chips};

        double taxRate = 0.06; // 6% tax
        double discountRate = 0.10; // 10% off

        ShoppingCart cart = new ShoppingCart();
        double total = cart.checkoutShoppingCart(items, taxRate, discountRate);

        System.out.printf("Total due: $%.2f%n", total);
    }
}
