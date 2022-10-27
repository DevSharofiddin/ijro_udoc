package com.ijro_udoc.service;

import com.ijro_udoc.model.Company;
import com.ijro_udoc.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public Company save(Company company) {
        return companyRepository.save(company);
    }
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public Company findById(Integer id) {
        return companyRepository.findById(id).get();
    }
    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }
}
