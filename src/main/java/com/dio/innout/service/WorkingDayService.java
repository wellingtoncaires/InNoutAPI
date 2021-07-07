package com.dio.innout.service;

import com.dio.innout.model.WorkingDay;
import com.dio.innout.repository.WorkingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingDayService {

    WorkingDayRepository workingDayRepository;

    @Autowired
    public WorkingDayService(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    public WorkingDay saveWorkingDay(WorkingDay workingDay) {
        return workingDayRepository.save(workingDay);
    }

    public List<WorkingDay> findAll() {
        return workingDayRepository.findAll();
    }

    public Optional<WorkingDay> getById(Long workingDayId) {
        return workingDayRepository.findById(workingDayId);
    }

    public WorkingDay updateWorkingDay(WorkingDay workingDay) {
        return workingDayRepository.save(workingDay);
    }

    public void deleteById(Long workingDayId) {
        workingDayRepository.deleteById(workingDayId);
    }
}
