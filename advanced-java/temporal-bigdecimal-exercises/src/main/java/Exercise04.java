import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Exercise04 {
    private static final RoundingMode RM = RoundingMode.HALF_UP;

    // BigDecimal
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. add a, b, and c together and return the result
    BigDecimal add(BigDecimal a, BigDecimal b, BigDecimal c) {
        // Treat nulls as zero to be defensive
        BigDecimal x = (a == null) ? BigDecimal.ZERO : a;
        BigDecimal y = (b == null) ? BigDecimal.ZERO : b;
        BigDecimal z = (c == null) ? BigDecimal.ZERO : c;
        return x.add(y).add(z);
    }

    // 2. divide a by b and return the result with only two decimal points
    BigDecimal divideWithTwoDecimalPlaces(BigDecimal a, BigDecimal b) {
        return a.divide(b, 2, RM);
    }

    // 3. calculate the sum of elements in values and return it
    // with a scale of 4.
    BigDecimal sum(BigDecimal[] values) {
        BigDecimal total = BigDecimal.ZERO;
        if (values != null) {
            for (BigDecimal v : values) {
                if (v != null) total = total.add(v);
            }
        }
        return total;
    }

    // 4. calculate the average of elements in values
    BigDecimal average(BigDecimal[] values) {
        if (values == null || values.length == 0) {
            return BigDecimal.ZERO.setScale(4, RM);
        }
        BigDecimal total = BigDecimal.ZERO;
        int count = 0;
        for (BigDecimal v : values) {
            if (v != null) {
                total = total.add(v);
                count++;
            }
        }
        if (count == 0) {
            return BigDecimal.ZERO.setScale(4, RM);
        }
        return total.divide(BigDecimal.valueOf(count), 4, RM);

    }

    /**
     * 5. complete the calculateInterest method using the spec below.
     * Calculates the total interest earned on an investment.
     * Does *not* calculate the final balance, just the interest over and above the initial investment.
     *
     * @param investment   the starting balance
     * @param interestRate the interest rate expressed as a decimal (not a %-age).
     * @param periods      number of periods in which to apply the interest
     * @return total interest earned (final balance - initial investment)
     */

    BigDecimal calculateInterest(BigDecimal investment, BigDecimal interestRate, int periods) {
        if (periods <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal balance = investment;
        BigDecimal onePlusRate = interestRate.add(BigDecimal.ONE);
        for (int i = 0; i < periods; i++) {
            balance = balance.multiply(onePlusRate);
        }
        return balance.subtract(investment); // exact balance, no scale set
    }
}
