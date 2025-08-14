public class WeatherForecast {
    public static void main(String[] args) {
        // Declare and initialize variables:
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

        // 1) Convert Celsius to Fahrenheit: F = C * 9/5 + 32
        double temperatureFahrenheit = (temperatureCelsius * 9.0 / 5.0) + 32.0; // <-- fixed 5.0

        // 2) Assignment updates
        temperatureCelsius += 5.0; // increase temp by 5°C
        windSpeedKmh += 5;         // increase wind by 5 km/h

        // Recompute Fahrenheit AFTER the updates
        double updatedFahrenheit = (temperatureCelsius * 9.0 / 5.0) + 32.0;

        // 3) Comparisons
        boolean isFahrenheitOver85 = updatedFahrenheit > 85.0;
        boolean isWindOver20 = windSpeedKmh > 20;

        // 4) Logical
        boolean isGoodDayOutside = (!isRaining) && (updatedFahrenheit >= 60.0 && updatedFahrenheit <= 85.0);
        boolean hasWeatherWarning = (windSpeedKmh > 30) || (temperatureCelsius < 0.0);

        // 5) Output
        System.out.println("== Weather: Temperature & Forecast Analysis ==");
        System.out.println("Initial: " + fmt1(temperatureFahrenheit) + "°F");
        System.out.println("Updated -> " + fmt1(temperatureCelsius) + "°C / "
                + fmt1(updatedFahrenheit) + "°F, Wind: " + windSpeedKmh + " km/h, Raining: " + isRaining);
        System.out.println("Temp > 85°F? " + isFahrenheitOver85);
        System.out.println("Wind > 20 km/h? " + isWindOver20);
        System.out.println("Good day outside? " + isGoodDayOutside);
        System.out.println("Weather warning (wind > 30 OR temp < 0°C)? " + hasWeatherWarning);
    }

    private static String fmt1(double v) { return String.format("%.1f", v); }
}

