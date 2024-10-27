package com.camt.olympic.services;

import com.camt.olympic.entity.Country;
import com.camt.olympic.repositories.CountryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    Optional<Country> getCountryByNoc(String noc);
    Optional<Country> addNewCountry(Country country);
    ResponseEntity<Void> deleteCountryByNoc(Country country);
    Optional<Country> updateDetailCountry(Country country);

}
