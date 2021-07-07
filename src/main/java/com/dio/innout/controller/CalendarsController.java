package com.dio.innout.controller;

import com.dio.innout.model.Calendars;
import com.dio.innout.service.CalendarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendar")
public class CalendarsController {

    @Autowired
    CalendarsService calendarsService;

    @PostMapping
    public Calendars createCalendars(@RequestBody Calendars calendars) {
        return calendarsService.saveCalendar(calendars);
    }

    @GetMapping
    public List<Calendars> getCalendars() {
        return calendarsService.findAll();
    }

    @GetMapping("/{calendarsId}")
    public ResponseEntity<Calendars> getCalendarsById(@PathVariable("calendarsId") Long calendarsId) throws Exception {
        return ResponseEntity.ok(calendarsService.getById(calendarsId).orElseThrow(() -> new NoSuchElementException("Calendar id not found")));
    }

    @PutMapping
    public Calendars updateCalendars(@RequestBody Calendars calendars) {
        return calendarsService.updateCalendar(calendars);
    }

    @DeleteMapping("/{calendarsId}")
    public ResponseEntity deleteCalendar(@PathVariable("calendarsId") Long calendarsId) throws Exception {
        try {
            calendarsService.deleteByid(calendarsId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(calendarsService.getById(calendarsId).orElseThrow(() -> new NoSuchElementException("Calendar id not found")));
    }

}
