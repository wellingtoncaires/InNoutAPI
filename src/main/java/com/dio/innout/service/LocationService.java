package com.dio.innout.service;

import com.dio.innout.model.Location;
import com.dio.innout.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    
    @Autowired
    LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> getById(Long locationId) {
        return locationRepository.findById(locationId);
    }

    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteById(Long locationId) {
        locationRepository.deleteById(locationId);
    }
}
