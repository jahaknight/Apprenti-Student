// Formulas :
// F = C * 9/5 + 32
// C = (F - 32) * 5/9
// K = C + 273.15
// C = K - 273.15
// K = (F - 32) * 5/9 + 273.15
// F = (K - 273.15) * 9/5 + 32

public class TemperatureConverter {
    private static final double ABS_Zero_C = -273.15; // Celsius
    private static final double ABS_Zero_K = 0.0; // Kelvin
    private static final double ABS_Zero_F = -459.67; // Fahrenheit

    // Utility class:
    private TemperatureConverter() { }

    // helpers
    // Round to 2 decimals  (12.345 -> 12.35)
    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    // conversions
    // Celsius -> Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        double f = celsius * 9.0 / 5.0 + 32.0;
        return round2(f);
    }

    // Fahrenheit -> Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        double c = (fahrenheit - 32.0) * 5.0/9.0;
        return round2(c);
    }

    // Celsius
    public static double celsiusToKelvin (double celsius) {
        if (celsius < ABS_Zero_C) {
            throw new IllegalArgumentException("Celsius below absolute zero");
        }
        double k = celsius + 273.15;
        return round2(k);
    }

    // Kelvin -> Celsius (no negative Kelvin)
    public static double kelvinToCelsius(double kelvin) {
        if (kelvin < ABS_Zero_K) {
            throw new IllegalArgumentException("Kelvin cannot be negative");
        }
        double c = kelvin - 273.15;
        return round2(c);
    }

    // Fahrenheit -> Kelvin (validate absolute zero)
    public static double fahrenheitToKelvin(double fahrenheit) {
        if (fahrenheit < ABS_Zero_F) {
            throw new IllegalArgumentException("Fahrenheit below absolute zero");
        }
        // Use direct formula or F->C->K
        double k = (fahrenheit - 32.0) * 5.0 / 9.0 + 273.15;
        return round2(k);
    }

    // Kelvin -> Fahrenheit (no negative Kelvin)
    public static double kelvinToFahrenheit(double kelvin) {
        if (kelvin < ABS_Zero_K) {
            throw new IllegalArgumentException("Kelvin cannot be negative");
        }
        double f = (kelvin - 273.15) * 9.0 / 5.0 + 32.0;
        return round2(f);
    }
}
