package com.dio.innout.service;

import com.dio.innout.model.Calendars;
import com.dio.innout.repository.CalendarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarsService {

    @Autowired
    CalendarsRepository calendarsRepository;

    public CalendarsService(CalendarsRepository calendarsRepository) {
        this.calendarsRepository = calendarsRepository;
    }

    public Calendars saveCalendar(Calendars calendars) {
        return calendarsRepository.save(calendars);
    }

    public List<Calendars> findAll() {
        return calendarsRepository.findAll();
    }

    public Optional<Calendars> getById(Long calendars) {
        return calendarsRepository.findById(calendars);
    }

    public Calendars updateCalendar(Calendars calendars) {
        return calendarsRepository.save(calendars);
    }

    public void deleteByid(Long calendarsId) {
        calendarsRepository.deleteById(calendarsId);
    }
}
