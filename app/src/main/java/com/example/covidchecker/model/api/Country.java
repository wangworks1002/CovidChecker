package com.example.covidchecker.model.api;

import com.example.covidchecker.model.room.RoomCountry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Country {

    @SerializedName("updated")
    @Expose
    public Long updated;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("countryInfo")
    @Expose
    public CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    public Integer cases;
    @SerializedName("todayCases")
    @Expose
    public Integer todayCases;
    @SerializedName("deaths")
    @Expose
    public Integer deaths;
    @SerializedName("todayDeaths")
    @Expose
    public Integer todayDeaths;
    @SerializedName("recovered")
    @Expose
    public Integer recovered;
    @SerializedName("todayRecovered")
    @Expose
    public Integer todayRecovered;
    @SerializedName("active")
    @Expose
    public Integer active;
    @SerializedName("critical")
    @Expose
    public Integer critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    public Integer casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    public Integer deathsPerOneMillion;
    @SerializedName("tests")
    @Expose
    public Integer tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    public Integer testsPerOneMillion;
    @SerializedName("population")
    @Expose
    public Integer population;
    @SerializedName("continent")
    @Expose
    public String continent;
    @SerializedName("oneCasePerPeople")
    @Expose
    public Integer oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    @Expose
    public Integer oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    @Expose
    public Integer oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    @Expose
    public Double activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    @Expose
    public Double recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    @Expose
    public Double criticalPerOneMillion;

    public Country(Long updated, String country, CountryInfo countryInfo, Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer todayRecovered, Integer active, Integer critical, Integer casesPerOneMillion, Integer deathsPerOneMillion, Integer tests, Integer testsPerOneMillion, Integer population, String continent, Integer oneCasePerPeople, Integer oneDeathPerPeople, Integer oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion) {
        this.updated = updated;
        this.country = country;
        this.countryInfo = countryInfo;
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

    public Country(Country body) {
        this.updated = body.updated;
        this.country = body.country;
        this.countryInfo = body.countryInfo;
        this.cases = body.cases;
        this.todayCases = body.todayCases;
        this.deaths = body.deaths;
        this.todayDeaths = body.todayDeaths;
        this.recovered = body.recovered;
        this.todayRecovered = body.todayRecovered;
        this.active = body.active;
        this.critical = body.critical;
        this.casesPerOneMillion = body.casesPerOneMillion;
        this.deathsPerOneMillion = body.deathsPerOneMillion;
        this.tests = body.tests;
        this.testsPerOneMillion = body.testsPerOneMillion;
        this.population = body.population;
        this.continent = body.continent;
        this.oneCasePerPeople = body.oneCasePerPeople;
        this.oneDeathPerPeople = body.oneDeathPerPeople;
        this.oneTestPerPeople = body.oneTestPerPeople;
        this.activePerOneMillion = body.activePerOneMillion;
        this.recoveredPerOneMillion = body.recoveredPerOneMillion;
        this.criticalPerOneMillion = body.criticalPerOneMillion;
    }

    public Country(RoomCountry body){
        this.updated = body.updated;
        this.country = body.country;
        this.countryInfo = new CountryInfo(body.id, body.iso2, body.iso3, body.lat, body._long, body.flag);
        this.cases = body.cases;
        this.todayCases = body.todayCases;
        this.deaths = body.deaths;
        this.todayDeaths = body.todayDeaths;
        this.recovered = body.recovered;
        this.todayRecovered = body.todayRecovered;
        this.active = body.active;
        this.critical = body.critical;
        this.casesPerOneMillion = body.casesPerOneMillion;
        this.deathsPerOneMillion = body.deathsPerOneMillion;
        this.tests = body.tests;
        this.testsPerOneMillion = body.testsPerOneMillion;
        this.population = body.population;
        this.continent = body.continent;
        this.oneCasePerPeople = body.oneCasePerPeople;
        this.oneDeathPerPeople = body.oneDeathPerPeople;
        this.oneTestPerPeople = body.oneTestPerPeople;
        this.activePerOneMillion = body.activePerOneMillion;
        this.recoveredPerOneMillion = body.recoveredPerOneMillion;
        this.criticalPerOneMillion = body.criticalPerOneMillion;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Integer todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(Integer casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Integer getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Integer deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Integer getTests() {
        return tests;
    }

    public void setTests(Integer tests) {
        this.tests = tests;
    }

    public Integer getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Integer testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(Integer oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public Integer getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(Integer oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public Integer getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(Integer oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public Double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(Double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public Double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public Double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(Double criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

}
