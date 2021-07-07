package com.dio.innout.controller;

import com.dio.innout.model.Company;
import com.dio.innout.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping
    public List<Company> getCompany() {
        return companyService.findAll();
    }

    @GetMapping("{/companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("companyId") Long companyId) throws Exception {
        return ResponseEntity.ok(companyService.getById(companyId).orElseThrow(() -> new NoSuchElementException("Company id not found")));
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("{/companyId}")
    public ResponseEntity<Company> deleteCompany(@PathVariable("companyId") Long companyId) throws Exception {
        try {
            companyService.deleteCompany(companyId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(companyService.getById(companyId).orElseThrow(() -> new NoSuchElementException("Company id not found")));
    }
}
