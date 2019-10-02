/**
 * Dao class for running functions on sensors
 */
package com.example.capstoneproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertAccScore(AccelerometerScore accelerometerScore);

    @Query("SELECT finalScore FROM AccelerometerScore WHERE Name = :name")
    LiveData<List<Float>> getAccScore(String name);

}
