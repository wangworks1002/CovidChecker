package com.example.covidchecker.model.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface RoomGlobalDao {

    @Query("SELECT * FROM roomglobal")
    abstract RoomGlobal getAllCases();

    @Insert
    void insertAll(RoomGlobal... roomGlobals);

    @Query("DELETE FROM roomglobal")
    void deleteAll();
}
