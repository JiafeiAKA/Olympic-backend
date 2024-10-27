package com.camt.olympic.repositories;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query(value = "SELECT * FROM country WHERE country_code = :country_code", nativeQuery = true)
    Optional<Country> getCountryByCountryCode(@Param("country_code") String country_code);

}
