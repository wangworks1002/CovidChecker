package com.example.covidchecker.model.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomFavorite {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "country")
    public String country;

}
