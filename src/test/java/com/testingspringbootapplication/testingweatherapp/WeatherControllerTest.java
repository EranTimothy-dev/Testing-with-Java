package com.testingspringbootapplication.testingweatherapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @InjectMocks
    private WeatherController underTest;

    @Mock
    private WeatherService weatherService;

    @Test
    public void getCurrentTemperature() {
        String city = "London";
        double temp = 72.5;
        WeatherResponse weatherResponse = new WeatherResponse(new WeatherMain(temp));

        when(weatherService.getWeather(city)).thenReturn(weatherResponse);
        ResponseEntity<Double> responseEntity = underTest.getCurrentTemperature(city);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(temp, responseEntity.getBody());
    }

    @Test
    public void getCurrentTemperature_error() {
        when(weatherService.getWeather(anyString()))
                .thenThrow(new RuntimeException("Error occurred"));

        ResponseEntity<Double> responseEntity = underTest.getCurrentTemperature("London");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
