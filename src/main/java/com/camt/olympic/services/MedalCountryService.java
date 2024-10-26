package com.camt.olympic.services;

import com.camt.olympic.entity.OlympicYear;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface MedalCountryService {
    List<Map<String,Object>> getMedalByCountryByYear(String NOC, int year);
    Optional<OlympicYear> updateMedalByCountry(String medal, int medalCount);
    Optional<OlympicYear> insertNewMedal(OlympicYear olympicYear);
    ResponseEntity<?> deleteMedalCountry(String NOC);
}
