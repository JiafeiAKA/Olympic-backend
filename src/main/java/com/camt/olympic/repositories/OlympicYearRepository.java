package com.camt.olympic.repositories;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.entity.OlympicYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OlympicYearRepository extends JpaRepository<OlympicYear,Long> {

    @Query(value = "SELECT * FROM olympic_year WHERE noc = :country AND year = :year", nativeQuery = true)
    List<Map<String, Object>> getMedalByCountryAndYear(@Param("country") String country, @Param("year") int year);

}
