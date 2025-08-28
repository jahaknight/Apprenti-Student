package org.example.inheritanceexercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Different kinds of payments will be stored here (CreditCard, DirectDebit, GiftCard)
        List<Payment> payments = new ArrayList<>();

        //Create your sample payments here
        // Long literals end with 'L'
        payments.add(new CreditCardPayment(101, 120.00, 4111111111111111L, "Visa"));
        payments.add(new DirectDebitPayment(102, 250.00, 61600339L, 123456789L, "Bank of America", 3.00));
        payments.add(new GiftCardPayment(103, 40.00, "GC-ABCD-1234", 80.00, 200)); //should succeed
        payments.add(new GiftCardPayment(104, 130.00, "GC-HEY-2222", 20.00, 0));      // should fail (insufficient balance)

        //Payments Report
        System.out.println("--- Payments Report ---");
        // Calls toString() on each payment
        for (Payment p : payments) {
            System.out.println(p.toString());
        }

        //Payment Processing Report
        System.out.println("\n--- Payments Processing Report ---");
        for (Payment p : payments) {
            p.processPayment();
        }

        //Uncomment this section after implementing GiftCardPayment to verify that balances are correct after processing
        //Post processing gift card balance check
        System.out.println("\n--- Post-Processing Gift Card Check ---");
        for (Payment p : payments) {
            if (p instanceof GiftCardPayment) {
                System.out.println(p.toString());
           }
        }
    }
}
