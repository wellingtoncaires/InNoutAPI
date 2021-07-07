package com.dio.innout.service;

import com.dio.innout.model.Movement;
import com.dio.innout.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    @Autowired
    MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement saveMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> getById(Long movementId) {
        return movementRepository.findById(movementId);
    }

    public Movement updateMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    public void deleteById(Long movementId) {
        movementRepository.deleteById(movementId);
    }
}
