package com.ijro_udoc.controller;

import com.ijro_udoc.model.Country;
import com.ijro_udoc.model.Region;
import com.ijro_udoc.model.dto.RegionRequestDto;
import com.ijro_udoc.service.CountryService;
import com.ijro_udoc.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RegionController {

    private final RegionService regionService;
    private final CountryService countryService;

    public RegionController(RegionService regionService, CountryService countryService) {
        this.regionService = regionService;
        this.countryService = countryService;
    }

    @PostMapping("/region-post")
    public ResponseEntity<?> regionPost(@RequestBody RegionRequestDto body) {
        Country country = countryService.findById(body.getCountryId());

        Region region = new Region(body, country);

        return ResponseEntity.ok(regionService.save(region));
    }

    @PutMapping("/region-put")
    public ResponseEntity<?> regionPut(@RequestBody RegionRequestDto body) {

        //created_at
        Region region1 = regionService.findById(body.getId());
        body.setCreated_at(region1.getCreated_at());

        Country country = countryService.findById(body.getCountryId());
        Region region = new Region(body, country);

        return ResponseEntity.ok(regionService.save(region));
    }

    @GetMapping("/region")
    public ResponseEntity<?> regionGet() {
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<?> regionGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(regionService.findById(id));
    }

    @DeleteMapping("/region-del/{id}")
    public ResponseEntity<?> regionDelOne(@PathVariable Integer id) {
        regionService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
