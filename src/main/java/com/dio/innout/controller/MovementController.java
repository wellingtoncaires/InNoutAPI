package com.dio.innout.controller;

import com.dio.innout.model.Movement;
import com.dio.innout.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement) {
        return movementService.saveMovement(movement);
    }

    @GetMapping
    public List<Movement> getMovement() {
        return movementService.findAll();
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Movement> getMovementById(@PathVariable("movementId") Long movementId) throws Exception {
        return ResponseEntity.ok(movementService.getById(movementId).orElseThrow(() -> new NoSuchElementException("Movement id not found")));
    }

    @PutMapping
    public Movement updateMovement(@RequestBody Movement movement) {
        return movementService.updateMovement(movement);
    }

    @DeleteMapping("/{movementId}")
    public ResponseEntity<Movement> deletetMovementById(@PathVariable("movementId") Long movementId) {
        try {
            movementService.deleteById(movementId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(movementService.getById(movementId).orElseThrow(() -> new NoSuchElementException("Movement id not found")));
    }
}
