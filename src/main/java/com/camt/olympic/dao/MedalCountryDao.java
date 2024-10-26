package com.camt.olympic.dao;

import com.camt.olympic.entity.OlympicYear;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MedalCountryDao {
    List<Map<String,Object>> getMedalByCountryByYear(String NOC, int year);
    Optional<OlympicYear> updateMedalByCountry(String medal,int medalCount);
    Optional<OlympicYear> insertNewMedal(OlympicYear olympicYear);
    ResponseEntity<?> deleteMedalCountry(String NOC);
}
