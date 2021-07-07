package com.dio.innout.controller;

import com.dio.innout.model.WorkingDay;
import com.dio.innout.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/work-days")
public class WorkingDayController {

    @Autowired
    WorkingDayService workingDayService;

    @PostMapping
    public WorkingDay createWorkingDay( @RequestBody WorkingDay workingDay) {
        return workingDayService.saveWorkingDay(workingDay);
    }

    @GetMapping
    public List<WorkingDay> getWorkingDay() {
        return workingDayService.findAll();
    }

    @GetMapping("/{workingDayId}")
    public ResponseEntity<WorkingDay> getWorkingDayById(@PathVariable("workingDayId") Long workingDayId) throws Exception {
        return ResponseEntity.ok(workingDayService.getById(workingDayId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public WorkingDay updateWorkingDay( @RequestBody WorkingDay workingDay) {
        return workingDayService.updateWorkingDay(workingDay);
    }

    @DeleteMapping("/{workingDayId}")
    public ResponseEntity deleteById(@PathVariable("workingDayId") Long workingDayId) throws Exception {
        try {
            workingDayService.deleteById(workingDayId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkingDay>) ResponseEntity.ok();
    }
}
