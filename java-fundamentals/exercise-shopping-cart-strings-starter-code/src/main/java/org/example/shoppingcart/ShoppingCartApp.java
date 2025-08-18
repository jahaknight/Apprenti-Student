package org.example.shoppingcart;

/**
 * 1. Add business name and contact info.
 * 2. Add item description.
 */

public class ShoppingCartApp {
    enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED
    }

    enum ShippingStatus {
        STANDARD, TWO_DAY, OVERNIGHT
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        // Business name, contact info, item description
        String businessName = "Coffee Haven";
        String contactInfo = "Email: info@coffeehaven.com | Phone: (555) 123-4567";
        String itemDescription = "Freshly roasted premium coffee beans";

        System.out.println("Business: " + businessName);
        System.out.println("Contact: " + contactInfo);
        System.out.println("Item: " + itemDescription);
        System.out.println();

        int productId = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        double totalCost = productCost * productQuantity;
        System.out.println(totalCost);

        double profitMargin = productPrice - productCost;
        System.out.println(profitMargin);

        double totalProfit = profitMargin * productQuantity;
        System.out.println(totalProfit);

        System.out.println(ShippingStatus.STANDARD);
        System.out.println(ShippingStatus.TWO_DAY);
        System.out.println(ShippingStatus.OVERNIGHT);

        System.out.println(OrderStatus.PENDING);
        System.out.println(OrderStatus.PROCESSING);
        System.out.println(OrderStatus.SHIPPED);
        System.out.println(OrderStatus.DELIVERED);



        System.out.println("Bye");
    }

}
