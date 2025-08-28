package org.example.inheritanceexercise;

// GiftCardPayment is child class of Payment
// Tracks stored-value balance and loyalty points
// Must implement processPayment();
// Override toString() to include Gift Card + balance and points

public class GiftCardPayment extends Payment {
    // gift card fields:
    private String accountNumber;
    private double balance;
    private int loyaltyPoints;

    // Constructor
    public GiftCardPayment(int id, double amount, String accountNumber, double balance, int loyaltyPoints) {
        super(id, amount); // initialize parent fields (id,amount)
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() {return balance; }
    public int getLoyaltyPoints() { return loyaltyPoints; }

    // Try paying with gift card
    // If balance >= amount: deduct amount, add points = (int)(100 * amount), return true
    // Else: return false and do not change balance/points
    @Override
    public boolean processPayment() {
        if (balance >= getAmount()) {
        System.out.println("Processing gift card and adding loyalty points...");
            balance -= getAmount();
            loyaltyPoints += (int) (100 * getAmount());
            return true;
        } else {
            System.out.println("Gift card payment failed: insufficient balance.");
            return false;
        }
    }

    // toString() output used in Payment Report
    @Override
    public String toString() {
        return "Payment:  " + getId()
                + "  Amount:  $" + String.format("%.2f", getAmount())
                + "  Type: Gift Card"
                + "  Balance: $" + String.format("%.2f", balance)
                + "  Points: " + loyaltyPoints;
    }
}






