import junittesting.TempConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TempConverterTest {

    @Test
    public void fahrenheitToCelsiusTest(){
        double celsiusValue = TempConverter.fahrenheitToCelsius(32);
        assertEquals(celsiusValue, 0);
    }

    @Test
    public void fahrenheitToCelsius_celsiusTooLowTest(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> TempConverter.fahrenheitToCelsius(-500));
        assertEquals("Temperature cannot be below absolute zero (-459.67°F)", e.getMessage());
    }

    @Test
    public void celsiusToFahrenheit(){
        double fahrenheitValue = TempConverter.celsiusToFahrenheit(20);
        assertEquals(fahrenheitValue, 68);
    }

    @Test
    public void celsiusToFahrenheit_celsiusTooLowTest(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()-> TempConverter.celsiusToFahrenheit(-300));
        assertEquals("Temperature cannot be below absolute zero (-273.15°C)", e.getMessage());
    }

}
