package com.testingspringbootapplication.testingweatherapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherResponseTest {

    private  static final WeatherMain WEATHER_MAIN = new WeatherMain(25.0);
    private static final WeatherResponse underTest = new WeatherResponse(WEATHER_MAIN);

    @Test
    void getWeatherMainTest() {
        assertEquals(WEATHER_MAIN, underTest.getMain());
    }
}
