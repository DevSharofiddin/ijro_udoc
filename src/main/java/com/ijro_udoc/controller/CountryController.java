package com.ijro_udoc.controller;

import com.ijro_udoc.model.Country;
import com.ijro_udoc.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/country-post")
    public ResponseEntity<?> countryPost(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.save(country));
    }

    @PutMapping("/country-put")
    public ResponseEntity<?> countryPut(@RequestBody Country country) {
        Country country1 = countryService.findById(country.getId());
        country.setCreated_at(country1.getCreated_at());
        return ResponseEntity.ok(countryService.save(country));
    }

    @GetMapping("/country")
    public ResponseEntity<?> countryGet() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<?> countryGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @DeleteMapping("/country-del/{id}")
    public ResponseEntity<?> countryDelOne(@PathVariable Integer id) {
        countryService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
