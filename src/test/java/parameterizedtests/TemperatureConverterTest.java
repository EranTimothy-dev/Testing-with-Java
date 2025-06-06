package ParameterizedTests;

import junittesting.ParameterizedTests.TemperatureConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterTest {

    /**
     * using parameterized test to make the test code more maintainable
     * for tests that can are more complex and get larger as the code base grows
     * note that the variables are passed respectively in their order to celsius and expectedFahrenheit
     * */

    @ParameterizedTest
    @CsvSource({
            "0, 32.0",
            "100, 212.0",
            "-40, -40",
            "37, 98.6",
            "25, 77.0",
            "-10, 14.0"
    })
    void celsiusToFahrenheit(int celsius, double expectedFahrenheit) {
        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius));
    }

//    @Test
//    void celsiusToFahrenheitZero() {
//        int celsius = 0;
//        double expectedFahrenheit = 32.0;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }
//
//    @Test
//    void celsiusToFahrenheitPositive() {
//        int celsius = 100;
//        double expectedFahrenheit = 212.0;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }
//
//    @Test
//    void celsiusToFahrenheitNegative() {
//        int celsius = -40;
//        double expectedFahrenheit = -40.0;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }
//
//    @Test
//    void celsiusToFahrenheitArbitrary() {
//        int celsius = 37;
//        double expectedFahrenheit = 98.6;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }
//
//    @Test
//    void celsiusToFahrenheitAnotherPositive() {
//        int celsius = 25;
//        double expectedFahrenheit = 77.0;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }
//
//    @Test
//    void celsiusToFahrenheitAnotherNegative() {
//        int celsius = -10;
//        double expectedFahrenheit = 14.0;
//        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.01);
//    }

}
