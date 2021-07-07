package com.dio.innout.service;

import com.dio.innout.model.HourBank;
import com.dio.innout.repository.HourBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourBankService {

    @Autowired
    HourBankRepository hourBankRepository;

    public HourBankService(HourBankRepository hourBankRepository) {
        this.hourBankRepository = hourBankRepository;
    }


    public HourBank saveHourBank(HourBank hourBank) {
        return hourBankRepository.save(hourBank);
    }

    public List<HourBank> findAll() {
        return hourBankRepository.findAll();
    }

    public Optional<HourBank> getHourBankById(Long hourBankId) {
        return hourBankRepository.findById(hourBankId);
    }

    public HourBank updateHourBank(HourBank hourBank) {
        return hourBankRepository.save(hourBank);
    }

    public void deleteById(Long hourBankId) {
        hourBankRepository.deleteById(hourBankId);
    }
}
