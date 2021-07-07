package com.dio.innout.service;

import com.dio.innout.model.AccessLevel;
import com.dio.innout.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    @Autowired
    AccessLevelRepository accessLevelRepository;

    public AccessLevelService(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel saveAccessLevel(AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> getById(Long accessLevelId) {
        return accessLevelRepository.findById(accessLevelId);
    }

    public AccessLevel updateAccessLevel(AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public void deleteById(Long accessLevelId) {
        accessLevelRepository.deleteById(accessLevelId);
    }
}
