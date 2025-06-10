package com.testingspringbootapplication.testingweatherapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherMainTest {

    private static final WeatherMain underTest = new WeatherMain(25.0);

    @Test
    void testSetWeather() {
        assertEquals(25.0, underTest.getTemp());
        underTest.setTemp(30.0);
        assertEquals(30.0, underTest.getTemp());
    }
}
