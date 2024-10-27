package com.camt.olympic.controllers;


import com.camt.olympic.entity.Comments;
import com.camt.olympic.entity.Country;
import com.camt.olympic.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
@CrossOrigin
public class CountryController {

    final CountryService countryService;

    @GetMapping({"","/"})
    public Optional<Country> getCountryDetailByCode(
            @RequestParam(value = "countryCode") String countryCode
    ){
        return countryService.getCountryByNoc(countryCode);
    }


    @PostMapping("/newCountry")
    public Optional<Country> createCountry(@RequestBody Country country){
        return countryService.addNewCountry(country);

    }


    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteComment(@RequestBody Country country){

        countryService.deleteCountryByNoc(country);

        return  ResponseEntity.noContent().build();
    }


}
