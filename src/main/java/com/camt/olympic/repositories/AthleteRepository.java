package com.camt.olympic.repositories;

import com.camt.olympic.entity.Athlete;
import com.camt.olympic.entity.OlympicYear;
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


    @Query(value = """
                 SELECT
                 year,
                 sport,
                 SUM(CASE WHEN sex = 'M' THEN 1 ELSE 0 END) AS male,
                 SUM(CASE WHEN sex = 'F' THEN 1 ELSE 0 END) AS female,
                 SUM(CASE WHEN medal = 'Gold' THEN 1 ELSE 0 END) AS gold,
                 SUM(CASE WHEN medal = 'Silver' THEN 1 ELSE 0 END) AS silver,
                 SUM(CASE WHEN medal = 'Bronze' THEN 1 ELSE 0 END) AS bronze,
                 SUM(CASE WHEN sex = 'M' AND medal = 'Gold' THEN 1 ELSE 0 END) AS male_gold,
                 SUM(CASE WHEN sex = 'M' AND medal = 'Silver' THEN 1 ELSE 0 END) AS male_silver,
                 SUM(CASE WHEN sex = 'M' AND medal = 'Bronze' THEN 1 ELSE 0 END) AS male_bronze,
                 SUM(CASE WHEN sex = 'F' AND medal = 'Gold' THEN 1 ELSE 0 END) AS female_gold,
                 SUM(CASE WHEN sex = 'F' AND medal = 'Silver' THEN 1 ELSE 0 END) AS female_silver,
                 SUM(CASE WHEN sex = 'F' AND medal = 'Bronze' THEN 1 ELSE 0 END) AS female_bronze,
                 GROUP_CONCAT(DISTINCT team) AS team,
                 noc,
                 GROUP_CONCAT(DISTINCT games) games,
                 GROUP_CONCAT(DISTINCT season) AS season,
                 GROUP_CONCAT(DISTINCT city) city,
                 GROUP_CONCAT(DISTINCT event) event,
                 (SUM(CASE WHEN medal = 'Gold' THEN 1 ELSE 0 END) +
                 SUM(CASE WHEN medal = 'Silver' THEN 1 ELSE 0 END) +
                 SUM(CASE WHEN medal = 'Bronze' THEN 1 ELSE 0 END)) AS total_medals
                 FROM
                 athlete_events
                 GROUP BY
                 year, sport, noc
            """,nativeQuery = true)
    List<Object[]> findOlympicYearSummarizedData();



}



//@Query(value="""
//                SELECT
//                year,
//                sport,
//                SUM(CASE WHEN sex = 'M' THEN 1 ELSE 0 END) AS male,
//                SUM(CASE WHEN sex = 'F' THEN 1 ELSE 0 END) AS female,
//                SUM(CASE WHEN medal = 'Gold' THEN 1 ELSE 0 END) AS gold,
//                SUM(CASE WHEN medal = 'Silver' THEN 1 ELSE 0 END) AS silver,
//                SUM(CASE WHEN medal = 'Bronze' THEN 1 ELSE 0 END) AS bronze,
//                SUM(CASE WHEN sex = 'M' AND medal = 'Gold' THEN 1 ELSE 0 END) AS male_gold,
//                SUM(CASE WHEN sex = 'M' AND medal = 'Silver' THEN 1 ELSE 0 END) AS male_silver,
//                SUM(CASE WHEN sex = 'M' AND medal = 'Bronze' THEN 1 ELSE 0 END) AS male_bronze,
//                SUM(CASE WHEN sex = 'F' AND medal = 'Gold' THEN 1 ELSE 0 END) AS female_gold,
//                SUM(CASE WHEN sex = 'F' AND medal = 'Silver' THEN 1 ELSE 0 END) AS female_silver,
//                SUM(CASE WHEN sex = 'F' AND medal = 'Bronze' THEN 1 ELSE 0 END) AS female_bronze,
//                team,
//                noc,
//                games,
//                season,
//                city,
//                event,
//                (SUM(CASE WHEN medal = 'Gold' THEN 1 ELSE 0 END) +
//                SUM(CASE WHEN medal = 'Silver' THEN 1 ELSE 0 END) +
//                SUM(CASE WHEN medal = 'Bronze' THEN 1 ELSE 0 END)) AS total_medals
//                FROM
//                athlete_events
//                GROUP BY
//                year, sport, team, noc, games, season, city, event
//                """,nativeQuery = true)
