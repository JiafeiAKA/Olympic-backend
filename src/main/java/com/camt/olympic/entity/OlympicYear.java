package com.camt.olympic.entity;

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
    private Long id;
    @Column(name = "year")
    private int year;

    @Column(name = "sport")
    private String sport;

    @Column(name = "male")
    private int male;

    @Column(name = "female")
    private int female;

    @Column(name = "gold")
    private int gold;

    @Column(name = "silver")
    private int silver;

    @Column(name = "bronze")
    private int bronze;

    @Column(name = "male_gold")
    private int maleGold;

    @Column(name = "male_silver")
    private int maleSilver;

    @Column(name = "male_bronze")
    private int maleBronze;

    @Column(name = "female_gold")
    private int femaleGold;

    @Column(name = "female_silver")
    private int femaleSilver;

    @Column(name = "female_bronze")
    private int femaleBronze;

    @Column(name = "team")
    private String team;

    @Column(name = "noc")
    private String noc;

    @Column(name = "games")
    private String games;

    @Column(name = "season")
    private String season;

    @Column(name = "city")
    private String city;

    @Column(name = "event",length = 6000)
    private String event;

    @Column(name = "total_medals")
    private int totalMedals;


    public OlympicYear(
            int year,
            String sport,
            int male,
            int female,
            int gold,
            int silver,
            int bronze,
            int maleGold,
            int maleSilver,
            int maleBronze,
            int femaleGold,
            int femaleSilver,
            int femaleBronze,
            String team,
            String noc,
            String games,
            String season,
            String city,
            String event,
            int totalMedals) {

        this.year = year;
        this.sport = sport;
        this.male = male;
        this.female = female;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.maleGold = maleGold;
        this.maleSilver = maleSilver;
        this.maleBronze = maleBronze;
        this.femaleGold = femaleGold;
        this.femaleSilver = femaleSilver;
        this.femaleBronze = femaleBronze;
        this.team = team;
        this.noc = noc;
        this.games = games;
        this.season = season;
        this.city = city;
        this.event = event;
        this.totalMedals = totalMedals;
    }
}
