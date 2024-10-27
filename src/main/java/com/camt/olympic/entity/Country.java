package com.camt.olympic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @JsonProperty("CountryCode")
    private    String countryCode;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("CapitalCity")
    private String capitalCity;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Continent")
    private String continent;
    @JsonProperty("Population")
    private Integer population;
    @JsonProperty("OfficialLanguage")
    private String officialLanguage;

    // Constructors, getters and setters
}