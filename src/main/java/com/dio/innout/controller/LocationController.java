package com.dio.innout.controller;

import com.dio.innout.model.Location;
import com.dio.innout.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @GetMapping
    public List<Location> getLoction() {
        return locationService.findAll();
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable("locationId") Long locationId) throws Exception {
        return ResponseEntity.ok(locationService.getById(locationId).orElseThrow(() -> new NoSuchElementException("Location id not found")));
    }

    @PutMapping
    public Location updateLoction(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity deleteById(@PathVariable("locationId") Long locationId) throws Exception {
        try {
            locationService.deleteById(locationId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(locationService.getById(locationId).orElseThrow(() -> new NoSuchElementException("Location id not found")));
    }
}
