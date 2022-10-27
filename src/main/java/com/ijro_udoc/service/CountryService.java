package com.ijro_udoc.service;

import com.ijro_udoc.model.Country;
import com.ijro_udoc.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    public Country findById(Integer id) {
        return countryRepository.findById(id).get();
    }
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}
