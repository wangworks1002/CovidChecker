package com.example.covidchecker.model.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.covidchecker.utils.DateConverter;

import java.util.Date;

@Entity
public class RoomGlobal {

    @TypeConverters(DateConverter.class)
    @PrimaryKey
    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "cases")
    public Integer cases;

    @ColumnInfo(name = "active")
    public Integer active;

    @ColumnInfo(name = "recovered")
    public Integer recovered;

    @ColumnInfo(name = "deaths")
    public Integer deaths;

    public RoomGlobal(@NonNull Integer cases, Integer active, Integer recovered, Integer deaths) {
        this.date = new Date();
        this.cases = cases;
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }
}
