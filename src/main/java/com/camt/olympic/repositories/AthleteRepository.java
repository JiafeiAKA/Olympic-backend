package com.camt.olympic.repositories;

import com.camt.olympic.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {


    @Query(value = "SELECT NOC, Sport, COUNT(Medal) AS MedalCount," +
            "SUM(CASE WHEN Medal = 'Gold' THEN 1 ELSE 0 END) AS Gold," +
            "SUM(CASE WHEN Medal = 'Silver' THEN 1 ELSE 0 END) AS Silver," +
            "SUM(CASE WHEN Medal = 'Bronze' THEN 1 ELSE 0 END) AS Bronze " +
            "FROM athlete_events " +
//            "WHERE Year = (SELECT MAX(Year) FROM athlete_events) " +
            "WHERE Year = :year " +
            "AND Medal <> 'NA' " +
            "GROUP BY Noc, Sport " +
            "ORDER BY Noc, Sport", nativeQuery = true)
    public List<Map<String, Object>> findMedalCountByNocAndSport(@Param("year") int year);






}
