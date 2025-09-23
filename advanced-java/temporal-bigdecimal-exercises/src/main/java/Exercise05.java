import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercise05 {
    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        int year = date.getYear();
        LocalDate firstFriday = LocalDate.of(year, 1, 1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));

        BigDecimal total = BigDecimal.ZERO;
        for (LocalDate pay = firstFriday; pay.getYear() == year; pay = pay.plusWeeks(2)) {
            if (!pay.isBefore(date)) {
                total = total.add(BigDecimal.TEN);
            }
        }
        return total;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        int year = date.getYear();
        LocalDate firstFriday = LocalDate.of(year, 1, 1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));

        BigDecimal total = BigDecimal.ZERO;
        for (LocalDate pay = firstFriday; pay.getYear() == year; pay = pay.plusWeeks(2)) {
            if (!pay.isBefore(date)) {
                total = total.add(BigDecimal.valueOf(pay.getDayOfMonth()));
            }
        }
        return total;
    }
}
