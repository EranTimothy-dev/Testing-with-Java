package com.testingspringbootapplication.testingweatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @InjectMocks
    private WeatherService underTest;

    @Mock
    private RestTemplate restTemplate;

    private static final String CITY = "London";
    private static final double TEMP = 72;
    private static final String API_KEY = "123456";

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(underTest, "apiKey", API_KEY); // change attributes at runtime instead of using a setter
    }

    @Test
    void getWeatherTest() {
        WeatherResponse mockResponse = new WeatherResponse(new WeatherMain(TEMP));
        when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY + "&units=imperial"
                ,WeatherResponse.class)).thenReturn(mockResponse);
        WeatherResponse response = underTest.getWeather(CITY);
        assertEquals(mockResponse, response);
    }

    @Test
    void getWeatherErrorTest() {

        when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
                        + CITY + "&appid=" + API_KEY + "&units=imperial"
                ,WeatherResponse.class)).thenThrow(new RestClientException("error"));

        Exception e = assertThrows(RestClientException.class, () -> underTest.getWeather(CITY));
        assertEquals("error", e.getMessage());
    }

}
