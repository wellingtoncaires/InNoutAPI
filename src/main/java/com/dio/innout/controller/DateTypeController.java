package com.dio.innout.controller;

import com.dio.innout.model.DateType;
import com.dio.innout.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/date")
public class DateTypeController {

    @Autowired
    DateTypeService dateTypeService;

    @PostMapping
    public DateType createDateType(@RequestBody DateType dateType) {
        return dateTypeService.saveDateType(dateType);
    }

    @GetMapping
    public List<DateType> getDateType() {
        return dateTypeService.findAll();
    }

    @GetMapping("/{dateTypeId}")
    public ResponseEntity<DateType> getDateTypeId(@PathVariable("dateTypeId") Long dateTypeId) throws Exception {
        return ResponseEntity.ok(dateTypeService.getById(dateTypeId).orElseThrow(() -> new NoSuchElementException("Date type id not found")));
    }

    @PutMapping
    public DateType updateDateType(@RequestBody DateType dateType) {
        return dateTypeService.updateDateType(dateType);
    }

    @DeleteMapping("/{dateTypeId}")
    public ResponseEntity deleteDateType(@PathVariable("dateTypeId") Long dateTypeId) throws Exception {
        try {
            dateTypeService.deleteById(dateTypeId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(dateTypeService.getById(dateTypeId).orElseThrow(() -> new NoSuchElementException("Date type id not found")));
    }
}
