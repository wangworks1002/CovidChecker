package com.example.covidchecker.model.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomCountryDao {

    @Query("SELECT * FROM roomcountry")
    List<RoomCountry> getAll();

    @Query("SELECT *  FROM roomcountry where country is :country")
    RoomCountry getSpecificCountry(String country);

    @Update
    void update(RoomCountry... roomCountries);

    @Insert
    void insertAll(RoomCountry... roomCountries);

    @Delete
    void delete(RoomCountry roomCountry);



}
