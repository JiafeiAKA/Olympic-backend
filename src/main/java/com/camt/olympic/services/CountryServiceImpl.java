package com.camt.olympic.services;

import com.camt.olympic.dao.CommentsDao;
import com.camt.olympic.dao.CountryDao;
import com.camt.olympic.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

    private final CountryDao countryDao;

    @Override
    public Optional<Country> getCountryByNoc(String noc) {
        return countryDao.getCountryByNoc(noc);
    }

    @Override
    public Optional<Country> addNewCountry(Country country) {

        return countryDao.addNewCountry(country);
    }

    @Override
    public ResponseEntity<Void> deleteCountryByNoc(Country country) {
        return countryDao.deleteCountryByNoc(country);
    }

    @Override
    public Optional<Country> updateDetailCountry(Country country) {
        return Optional.empty();
    }
}
