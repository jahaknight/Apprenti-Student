package org.example.inheritanceexercise;

// DirectDebitPayment is child class of Payment
// Store routingNumber, accountNumber, bankName, and a small processingFee
// Must implement processPayment();
// Override toString() to include Type: Direct Debit and bank name

public class DirectDebitPayment extends Payment {

    // unique fields for direct-debit transaction
    private long routingNumber;
    private long accountNumber;
    private String bankName;
    private double processingFee;

    // Constructor
    public DirectDebitPayment(int id, double amount, long routingNumber, long accountNumber,
                              String bankName, double processingFee) {
        super(id, amount); // initialize parent fields (id,amount)
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.processingFee = processingFee;
    }

    // Getters
    public long getRoutingNumber() { return routingNumber; }
    public long getAccountNumber() { return accountNumber;}
    public String getBankName() { return bankName; }
    public double getProcessingFee() { return processingFee; }

    // Simulate sending debit to bank
    @Override
    public boolean processPayment() {
        System.out.println("Direct debit processing fee:  $"
        + String.format("%.2f", processingFee));
        System.out.println("Sending transaction to bank: " + bankName + "...");
        return true;
    }

    // toString() output used in Payment Report
    @Override
    public String toString() {
        return "Payment:  " + getId()
                + "  Amount:  $" + String.format("%.2f", getAmount())
                + "  Type: Direct Debit"
                + "  Bank: " + bankName;
    }
}
