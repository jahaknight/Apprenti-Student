public class LoanPaymentCalculator {

    public static void main(String[] args) {
        //Declare and initialize variables:
        double loanAmount = 25000;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;

//        Calculate Monthly Payment using the Formula
//        monthlyPayment = (loanAmount×(interestRate/100)/12)
        double monthlyPayment = loanAmount * ((annualInterestRate / 100.0) / 12.0);

//        1. Use Assignment Operators:
//             Increase loanAmount by $5,000 (+=).
        loanAmount += 5000;
//             Reduce the annualInterestRate by 1% (-=).
        annualInterestRate -= 1;
//             Increase loanTermYears by 1 (++).
        loanTermYears++;

        double updatedMonthlyPayment = loanAmount * ((annualInterestRate / 100.0) / 12.0);
//
//         2. Use Comparison Operators:
//             Check if the loanAmount exceeds $30,000.
        boolean isLoanAmountOver30k = loanAmount > 30000;
//             Check if the monthlyPayment is more than $500.
        boolean isMonthlyPaymentOver500 = updatedMonthlyPayment > 500.0;
//
//          3. Use Logical Operators:
//            Determine if the loan is affordable (monthly payment is below $500 AND
//                    term is over 3 years).
        boolean isAffordable = (updatedMonthlyPayment < 500.0) && (loanTermYears >3);
//            Determine if the loan is expensive (monthly payment is above $700 OR
//                    interest rate is over 6%).
        boolean isExpensive = (updatedMonthlyPayment > 700.0) || (annualInterestRate > 6.0);
//
//           4. Print all results.
        System.out.println("== Finance: Loan Payment Calculator ==");
        System.out.println("Initial monthly payment (simplified): $" + fmt2(monthlyPayment));
        System.out.println("Updated values -> loanAmount: $" + fmt2(loanAmount)
                + ", annualInterestRate: " + fmt2(annualInterestRate) + "%"
                + ", loanTermYears: " + loanTermYears);
        System.out.println("Updated monthly payment (simplified): $" + fmt2(updatedMonthlyPayment));
        System.out.println("Loan amount > $30,000? " + isLoanAmountOver30k);
        System.out.println("Monthly payment > $500? " + isMonthlyPaymentOver500);
        System.out.println("Affordable (payment < $500 AND term > 3 years)? " + isAffordable);
        System.out.println("Expensive (payment > $700 OR rate > 6%)? " + isExpensive);



    }
    private static String fmt2(double v) { return String.format("%.2f", v); }

}
