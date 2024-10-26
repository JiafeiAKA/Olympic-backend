package com.camt.olympic.dao;


import com.camt.olympic.entity.OlympicYear;
import com.camt.olympic.repositories.OlympicYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MedalCountryDaoImpl implements MedalCountryDao{


    final OlympicYearRepository olympicYearRepository;


    @Override
    public List<Map<String,Object>> getMedalByCountryByYear(String NOC, int year) {
        return olympicYearRepository.getMedalByCountryAndYear(NOC,year);
    }

    @Override
    public Optional<OlympicYear> updateMedalByCountry(String medal, int medalCount) {
        return Optional.empty();
    }

    @Override
    public Optional<OlympicYear> insertNewMedal(OlympicYear olympicYear) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<?> deleteMedalCountry(String NOC) {
        return null;
    }
}
