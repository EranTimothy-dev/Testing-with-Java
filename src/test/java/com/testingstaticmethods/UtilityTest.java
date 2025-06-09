package com.testingstaticmethods;

import com.staticmethods.Utility;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void celsiusToFahrenheit() {
        // mock all of the static methods of the utility class
        try(MockedStatic<Utility> utility = Mockito.mockStatic(Utility.class)) {
            utility.when(() -> Utility.celsiusToFahrenheit(0))
                    .thenReturn(32.0);
            assertEquals(32.0, Utility.celsiusToFahrenheit(0));
        }
    }
}
