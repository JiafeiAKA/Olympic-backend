package com.camt.olympic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "athlete_events")
public class Athlete {
    @Id
    private int id;

    private String name;
    private String sex;
    private float age;
    private float height;
    private float weight;
    private String team;
    private String noc;
    private String games;
    private int year;
    private String season;
    private String city;
    private String sport;
    private String event;
    private String medal;


}
