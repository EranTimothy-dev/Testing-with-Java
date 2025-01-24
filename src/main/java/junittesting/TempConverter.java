package junittesting;

public class TempConverter {

    // Method to convert temperature from Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (-273.15°C)");
        }
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert temperature from Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        if (fahrenheit < -459.67) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (-459.67°F)");
        }
        return (fahrenheit - 32) * 5 / 9;
    }

}
