package com.example.covidchecker.model.room;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomFavoriteDao {

    @Query("Insert into roomfavorite values (:country)")
    void setFavorite(String country);

    @Query("Delete from roomfavorite where country is :country")
    void deleteFavorite(String country);

    @Query("Select * from roomfavorite where country is :country")
    RoomFavorite checkFavorite(String country);

    @Query("Select * from roomfavorite")
    List<RoomFavorite> getAll();

}
