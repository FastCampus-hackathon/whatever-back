package com.example.whateverback.category.controller;

import com.example.whateverback.auth.config.JwtAuthenticationProvider;
import com.example.whateverback.category.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/location")
    public ResponseEntity getLocation() {
        return new ResponseEntity(locationService.getLocation(), HttpStatus.OK);
    }

    @GetMapping("/location/{name}")
    public ResponseEntity getLocationByName(@PathVariable("name") String name) {
        return new ResponseEntity(locationService.getLocationByName(name), HttpStatus.OK);
    }

}
