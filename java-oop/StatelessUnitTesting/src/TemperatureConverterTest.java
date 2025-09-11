import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    // ---- Example cases from the assignment ----

    @Test
    void celsiusToFahrenheit_examples() {
        // Arrange
        double c0 = 0.0;
        // Act
        double f0 = TemperatureConverter.celsiusToFahrenheit(c0);
        // Assert
        assertEquals(32.00, f0, 1e-9);
    }

    @Test
    void fahrenheitToCelsius_examples() {
        assertEquals(0.00, TemperatureConverter.fahrenheitToCelsius(32.0), 1e-9);
    }

    @Test
    void celsiusToKelvin_examples() {
        assertEquals(373.15, TemperatureConverter.celsiusToKelvin(100.0), 1e-9);
    }

    @Test
    void kelvinToCelsius_examples() {
        assertEquals(-273.15, TemperatureConverter.kelvinToCelsius(0.0), 1e-9);
    }

    @Test
    void fahrenheitToKelvin_examples() {
        assertEquals(373.15, TemperatureConverter.fahrenheitToKelvin(212.0), 1e-9);
    }

    @Test
    void kelvinToFahrenheit_examples() {
        assertEquals(32.00, TemperatureConverter.kelvinToFahrenheit(273.15), 1e-9);
    }

    // ---- More cases + rounding ----

    @ParameterizedTest
    @CsvSource({
            "20, 68.00",
            "25.5, 77.90",
            "-40, -40.00"   // -40C == -40F
    })
    void celsiusToFahrenheit_various(double c, double expectedF) {
        assertEquals(expectedF, TemperatureConverter.celsiusToFahrenheit(c), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "98.6, 37.00",
            "77, 25.00",
            "-40, -40.00"
    })
    void fahrenheitToCelsius_various(double f, double expectedC) {
        assertEquals(expectedC, TemperatureConverter.fahrenheitToCelsius(f), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 273.15",
            "37, 310.15",
            "-273.15, 0.00"
    })
    void celsiusToKelvin_various(double c, double expectedK) {
        assertEquals(expectedK, TemperatureConverter.celsiusToKelvin(c), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "310.15, 37.00",
            "295.37, 22.22",
            "273.15, 0.00"
    })
    void kelvinToCelsius_various(double k, double expectedC) {
        assertEquals(expectedC, TemperatureConverter.kelvinToCelsius(k), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "32, 273.15",
            "-40, 233.15",
            "451, 505.93"
    })
    void fahrenheitToKelvin_various(double f, double expectedK) {
        assertEquals(expectedK, TemperatureConverter.fahrenheitToKelvin(f), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "0, -459.67",
            "273.15, 32.00",
            "310.15, 98.60"
    })
    void kelvinToFahrenheit_various(double k, double expectedF) {
        assertEquals(expectedF, TemperatureConverter.kelvinToFahrenheit(k), 1e-9);
    }

    // ---- Edge cases & validation (absolute zero) ----

    @Test
    void celsiusToKelvin_belowAbsoluteZero_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToKelvin(-300.0));
    }

    @Test
    void kelvinToCelsius_negativeKelvin_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.kelvinToCelsius(-0.01));
    }

    @Test
    void fahrenheitToKelvin_belowAbsoluteZero_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.fahrenheitToKelvin(-500.0));
    }

    @Test
    void kelvinToFahrenheit_negativeKelvin_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.kelvinToFahrenheit(-1.0));
    }

    // ---- (Optional) round-trip sanity checks ----
    @ParameterizedTest
    @CsvSource({"-40", "0", "20", "100"})
    void roundTrip_cToFToC_isClose(double c) {
        double f = TemperatureConverter.celsiusToFahrenheit(c);
        double backToC = TemperatureConverter.fahrenheitToCelsius(f);
        assertEquals(c, backToC, 0.02); // allow small loss due to rounding to 2 decimals
    }
}
