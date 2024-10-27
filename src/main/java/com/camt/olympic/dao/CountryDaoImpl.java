package com.camt.olympic.dao;


import com.camt.olympic.entity.Comments;
import com.camt.olympic.entity.Country;
import com.camt.olympic.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CountryDaoImpl implements CountryDao {

    final  CountryRepository countryRepository;

    @Override
    public Optional<Country> getCountryByNoc(String noc) {
        return countryRepository.getCountryByCountryCode(noc);
    }

    @Override
    public Optional<Country> addNewCountry(Country country) {
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public ResponseEntity<Void> deleteCountryByNoc(Country country) {
        countryRepository.delete(country);
        return null;
    }

    @Override
    public Optional<Country> updateDetailCountry(Country country) {
        return Optional.empty();
    }
}
