package com.camt.olympic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "olympic_year")
public class OlympicYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("year")
    @Column(name = "year")
    private int year;

    @Column(name = "sport")
    @JsonProperty("sport")
    private String sport;

    @Column(name = "male")
    @JsonProperty("male")
    private int male;

    @Column(name = "female")
    @JsonProperty("female")
    private int female;

    @Column(name = "gold")
    @JsonProperty("gold")
    private int gold;

    @Column(name = "silver")
    @JsonProperty("silver")
    private int silver;

    @Column(name = "bronze")
    @JsonProperty("bronze")
    private int bronze;

    @Column(name = "male_gold")
    @JsonProperty("male_gold")
    private int maleGold;

    @Column(name = "male_silver")
    @JsonProperty("male_silver")
    private int maleSilver;

    @Column(name = "male_bronze")
    @JsonProperty("male_bronze")
    private int maleBronze;

    @Column(name = "female_gold")
    @JsonProperty("female_gold")
    private int femaleGold;

    @Column(name = "female_silver")
    @JsonProperty("female_silver")
    private int femaleSilver;

    @Column(name = "female_bronze")
    @JsonProperty("female_bronze")
    private int femaleBronze;

    @Column(name = "team")
    @JsonProperty("team")
    private String team;

    @Column(name = "noc")
    @JsonProperty("noc")
    private String noc;

    @Column(name = "games")
    @JsonProperty("games")
    private String games;

    @Column(name = "season")
    @JsonProperty("season")
    private String season;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "event",length = 6000)
    @JsonProperty("event")
    private String event;

    @Column(name = "total_medals")
    @JsonProperty("total_medals")
    private int totalMedals;


//    public OlympicYear(
//            int year,
//            String sport,
//            int male,
//            int female,
//            int gold,
//            int silver,
//            int bronze,
//            int maleGold,
//            int maleSilver,
//            int maleBronze,
//            int femaleGold,
//            int femaleSilver,
//            int femaleBronze,
//            String team,
//            String noc,
//            String games,
//            String season,
//            String city,
//            String event,
//            int totalMedals) {
//
//        this.year = year;
//        this.sport = sport;
//        this.male = male;
//        this.female = female;
//        this.gold = gold;
//        this.silver = silver;
//        this.bronze = bronze;
//        this.maleGold = maleGold;
//        this.maleSilver = maleSilver;
//        this.maleBronze = maleBronze;
//        this.femaleGold = femaleGold;
//        this.femaleSilver = femaleSilver;
//        this.femaleBronze = femaleBronze;
//        this.team = team;
//        this.noc = noc;
//        this.games = games;
//        this.season = season;
//        this.city = city;
//        this.event = event;
//        this.totalMedals = totalMedals;
//    }
}
