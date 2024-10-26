package com.camt.olympic.services;

import com.camt.olympic.dao.MedalCountryDao;
import com.camt.olympic.entity.OlympicYear;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MedalCountryServiceImpl implements MedalCountryService{
    final MedalCountryDao medalCountryDao;

    @Override
    public List<Map<String,Object>> getMedalByCountryByYear(String NOC, int year) {
        return medalCountryDao.getMedalByCountryByYear(NOC,year);
    }

    @Override
    public Optional<OlympicYear> updateMedalByCountry(String medal, int medalCount) {
        return medalCountryDao.updateMedalByCountry(medal,medalCount);
    }

    @Override
    public Optional<OlympicYear> insertNewMedal(OlympicYear olympicYear) {
        return medalCountryDao.insertNewMedal(olympicYear);
    }

    @Override
    public ResponseEntity<?> deleteMedalCountry(String NOC) {
        return medalCountryDao.deleteMedalCountry(NOC);
    }
}
