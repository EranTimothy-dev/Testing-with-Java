package com.testingspringbootapplication.testingweatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getCurrentTemperature/{city}")
    public ResponseEntity<Double> getCurrentTemperature(@PathVariable String city) {

        try {
            WeatherResponse weather = weatherService.getWeather(city);
            return ResponseEntity.ok(weather.getMain().getTemp());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
