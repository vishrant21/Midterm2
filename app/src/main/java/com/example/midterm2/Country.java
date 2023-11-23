package com.example.midterm2;

// Country.java

public class Country {

    private String name;
    private String capital;
    private String flagUrl;
    private String region;
    private long population;
    private String timezone;
    private String currency;

    // Constructor
    public Country(String name, String capital, String flagUrl, String region, long population, String timezone, String currency) {
        this.name = name;
        this.capital = capital;
        this.flagUrl = flagUrl;
        this.region = region;
        this.population = population;
        this.timezone = timezone;
        this.currency = currency;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for capital
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    // Getter and Setter for flagUrl
    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    // Getter and Setter for region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // Getter and Setter for population
    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    // Getter and Setter for timezone
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    // Getter and Setter for currency
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}


