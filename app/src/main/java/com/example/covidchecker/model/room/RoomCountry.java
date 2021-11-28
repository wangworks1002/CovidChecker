package com.example.covidchecker.model.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.covidchecker.model.api.Country;
import com.example.covidchecker.model.api.CountryInfo;

@Entity
public class RoomCountry {

    @ColumnInfo(name = "updated")
    public Long updated;
    @ColumnInfo(name = "country")
    public String country;
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "iso2")
    public String iso2;
    @ColumnInfo(name = "iso3")
    public String iso3;
    @ColumnInfo(name = "lat")
    public Double lat;
    @ColumnInfo(name = "long")
    public Double _long;
    @ColumnInfo(name = "flag")
    public String flag;
    @ColumnInfo(name = "cases")
    public  Integer cases;
    @ColumnInfo(name = "today_cases")
    public Integer todayCases;
    @ColumnInfo(name = "deaths")
    public  Integer deaths;
    @ColumnInfo(name = "today_deaths")
    public  Integer todayDeaths;
    @ColumnInfo(name = "recovered")
    public Integer recovered;
    @ColumnInfo(name = "today_recovered")
    public  Integer todayRecovered;
    @ColumnInfo(name = "active")
    public Integer active;
    @ColumnInfo(name = "critical")
    public  Integer critical;
    @ColumnInfo(name = "cases_per_one_million")
    public Integer casesPerOneMillion;
    @ColumnInfo(name = "deaths_per_one_million")
    public Integer deathsPerOneMillion;
    @ColumnInfo(name = "tests")
    public Integer tests;
    @ColumnInfo(name = "tests_per_one_million")
    public  Integer testsPerOneMillion;
    @ColumnInfo(name = "population")
    public Integer population;
    @ColumnInfo(name = "continent")
    public String continent;
    @ColumnInfo(name = "one_case_per_people")
    public Integer oneCasePerPeople;
    @ColumnInfo(name = "one_death_per_people")
    public Integer oneDeathPerPeople;
    @ColumnInfo(name = "one_test_per_people")
    public  Integer oneTestPerPeople;
    @ColumnInfo(name = "active_per_one_million")
    public  Double activePerOneMillion;
    @ColumnInfo(name = "recovered_per_one_million")
    public Double recoveredPerOneMillion;
    @ColumnInfo(name = "critical_per_one_million")
    public Double criticalPerOneMillion;

    public RoomCountry(Country country,CountryInfo countryInfo) {
        this.updated = country.updated;
        this.country = country.country;
        this.id = countryInfo.id;
        this.iso2 = countryInfo.iso2;
        this.iso3 =countryInfo.iso3;
        this.lat = countryInfo.lat;
        this._long = countryInfo._long;
        this.flag = countryInfo.flag;
        this.cases = country.cases;
        this.todayCases = country.todayCases;
        this.deaths = country.deaths;
        this.todayDeaths = country.todayDeaths;
        this.recovered = country.recovered;
        this.todayRecovered = country.todayRecovered;
        this.active = country.active;
        this.critical = country.critical;
        this.casesPerOneMillion = country.casesPerOneMillion;
        this.deathsPerOneMillion = country.deathsPerOneMillion;
        this.tests = country.tests;
        this.testsPerOneMillion = country.testsPerOneMillion;
        this.population = country.population;
        this.continent = country.continent;
        this.oneCasePerPeople = country.oneCasePerPeople;
        this.oneDeathPerPeople = country.oneDeathPerPeople;
        this.oneTestPerPeople = country.oneTestPerPeople;
        this.activePerOneMillion = country.activePerOneMillion;
        this.recoveredPerOneMillion = country.recoveredPerOneMillion;
        this.criticalPerOneMillion = country.criticalPerOneMillion;
    }

    public RoomCountry(Long updated, String country, Integer id, String iso2, String iso3, Double lat, Double _long, String flag, Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer todayRecovered, Integer active, Integer critical, Integer casesPerOneMillion, Integer deathsPerOneMillion, Integer tests, Integer testsPerOneMillion, Integer population, String continent, Integer oneCasePerPeople, Integer oneDeathPerPeople, Integer oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion) {
        this.updated = updated;
        this.country = country;
        this.id = id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.continent = continent;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
    }
}
