import junittesting.TempConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempConverterTest {

    @Test
    public void fahrenheitToCelsiusTest(){
        double celsiusValue = TempConverter.fahrenheitToCelsius(32);
        assertEquals(celsiusValue, 0);
    }

    @Test
    public void celsiusToFahrenheitTest(){
        double fahrenheitValue = TempConverter.celsiusToFahrenheit(20);
        assertEquals(fahrenheitValue, 68);
    }

}
