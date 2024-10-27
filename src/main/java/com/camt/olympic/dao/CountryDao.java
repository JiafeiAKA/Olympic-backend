package com.camt.olympic.dao;

import com.camt.olympic.entity.Country;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CountryDao {
    Optional<Country> getCountryByNoc(String noc);
    Optional<Country> addNewCountry(Country country);
    ResponseEntity<Void> deleteCountryByNoc(Country country);
    Optional<Country> updateDetailCountry(Country country);


}
