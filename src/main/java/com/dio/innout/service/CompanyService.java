package com.dio.innout.service;

import com.dio.innout.controller.CompanyController;
import com.dio.innout.model.Company;
import com.dio.innout.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> getById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
