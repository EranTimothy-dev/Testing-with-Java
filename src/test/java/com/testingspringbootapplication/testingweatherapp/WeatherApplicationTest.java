package com.testingspringbootapplication.testingweatherapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class WeatherApplicationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockitoBean
    private RestTemplate restTemplate;

    @Test
    public void getCurrentTemperature() {
        when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=London&appid=123456&units=imperial",
                WeatherResponse.class))
                .thenReturn(new WeatherResponse(new WeatherMain(65)));

        Double temperature = testRestTemplate.getForObject("/getCurrentTemperature/London",
                Double.class);
        assertEquals(65, temperature);
    }

}
