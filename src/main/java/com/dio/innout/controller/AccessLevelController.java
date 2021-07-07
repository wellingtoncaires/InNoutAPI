package com.dio.innout.controller;

import com.dio.innout.model.AccessLevel;
import com.dio.innout.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/access")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel) {
        return accessLevelService.saveAccessLevel(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccessLevel() {
        return accessLevelService.findAll();
    }

    @GetMapping("/{accessLevelId}")
    public ResponseEntity<AccessLevel> getAccessLevelById(@PathVariable("accessLevelId") Long accessLevelId) throws Exception {
        return ResponseEntity.ok(accessLevelService.getById(accessLevelId).orElseThrow(() -> new NoSuchElementException("Access id not found!")));
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel) {
        return accessLevelService.updateAccessLevel(accessLevel);
    }

    @DeleteMapping("/{accessLevelId}")
    public ResponseEntity deleteAccessLevelById(@PathVariable("accessLevelId") Long accessLevelId) throws Exception {
        try {
            accessLevelService.deleteById(accessLevelId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(accessLevelService.getById(accessLevelId).orElseThrow(() -> new NoSuchElementException("Access id not found!")));
    }
}
