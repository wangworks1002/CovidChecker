package com.example.covidchecker.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AllResponse {

    @SerializedName("updated")
    @Expose
    public Long updated;
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
    public Double deathsPerOneMillion;
    @SerializedName("tests")
    @Expose
    public Long tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    public Double testsPerOneMillion;
    @SerializedName("population")
    @Expose
    public Long population;
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
    @SerializedName("affectedCountries")
    @Expose
    public Integer affectedCountries;

    public AllResponse(Long updated, Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer todayRecovered, Integer active, Integer critical, Integer casesPerOneMillion, Double deathsPerOneMillion, Long tests, Double testsPerOneMillion, Long population, Integer oneCasePerPeople, Integer oneDeathPerPeople, Integer oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion, Integer affectedCountries) {
        this.updated = updated;
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
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.affectedCountries = affectedCountries;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
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

    public Double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Double deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Long getTests() {
        return tests;
    }

    public void setTests(Long tests) {
        this.tests = tests;
    }

    public Double getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Double testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
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

    public Integer getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(Integer affectedCountries) {
        this.affectedCountries = affectedCountries;
    }
}
