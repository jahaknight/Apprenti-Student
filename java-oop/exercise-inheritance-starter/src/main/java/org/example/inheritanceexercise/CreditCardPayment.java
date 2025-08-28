package org.example.inheritanceexercise;
// CreditCardPayment is Child (subclass) Class of Payment (parent/superclass)

public class CreditCardPayment extends Payment {
    // Data only credit-card payment needs
    private long accountNumber;
    private String cardVendor; //e.x. "Visa" "Discover" "Mastercard"

    // Constructor: set both parent fields (id, amount)
    // super(id, amount) calls parent (Payment) constructor to initialize state
    public CreditCardPayment(int id, double amount, long accountNumber, String cardVendor) {
        super(id, amount); // initialize parent fields (id,amount)
        this.accountNumber = accountNumber;
        this.cardVendor = cardVendor;
    }

    // "getter"
    public long getAccountNumber() {return accountNumber; }
    public String getCardVendor() {return cardVendor; }

    @Override
    public boolean processPayment() {
        System.out.println("Processing via: " + cardVendor
        + " for $" + String.format("%.2f", getAmount()));
        return true;
    }

    // toString() prints "Payment Report"
    @Override
    public String toString() {
        return "Payment:  " + getId()
                + "  Amount: $" + String.format("%.2f", getAmount())
                + "  Type: Credit Card"
                + "  Vendor: " + cardVendor;
    }
}
