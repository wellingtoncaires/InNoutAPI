package com.dio.innout.controller;

import com.dio.innout.model.HourBank;
import com.dio.innout.service.HourBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hourBank")
public class HourBankController {

    @Autowired
    HourBankService hourBankService;

    @PostMapping
    public HourBank createHourBank(@RequestBody HourBank hourBank) {
        return hourBankService.saveHourBank(hourBank);
    }

    @GetMapping
    public List<HourBank> getHourBank() {
        return hourBankService.findAll();
    }

    @GetMapping("/{hourBankId}")
    public ResponseEntity<HourBank> getHourBankById(@PathVariable("hourBankId") Long hourBankId) throws Exception {
        return ResponseEntity.ok(hourBankService.getHourBankById(hourBankId).orElseThrow(() -> new NoSuchElementException("Hour bank id not found")));
    }

    @PutMapping
    public HourBank updateHourBank(@RequestBody HourBank hourBank) {
        return hourBankService.updateHourBank(hourBank);
    }

    @DeleteMapping("/{hourBankId}")
    public ResponseEntity deleteHoutBankById(@PathVariable("/{hourBankId}") Long hourBankId) throws Exception {
        try {
            hourBankService.deleteById(hourBankId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(hourBankService.getHourBankById(hourBankId).orElseThrow(() -> new NoSuchElementException("Hour bank id not found")));
    }


}
