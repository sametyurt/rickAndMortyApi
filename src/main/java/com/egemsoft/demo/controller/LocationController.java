package com.egemsoft.demo.controller;


import com.egemsoft.demo.model.location.LocationRequest;
import com.egemsoft.demo.model.location.LocationResponse;
import com.egemsoft.demo.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public LocationResponse getCharacters(LocationRequest request) {
        return locationService.getLocations(request);
    }




}
