package com.example.covidchecker.model;

import com.example.covidchecker.model.api.Country;
import com.example.covidchecker.model.room.RoomCountry;

public class CountryAdapterModel {
    private String country;
    private String continent;

    public CountryAdapterModel(Country countryi) {
        this.country = countryi.getCountry();
        this.continent = countryi.getContinent();
    }

    public CountryAdapterModel(RoomCountry roomCountry){
        this.country = roomCountry.country;
        this.continent = roomCountry.continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
