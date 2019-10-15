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


    @Insert
    Long insertGyroScore(GyroscopeScore gyroscopeScore);

    @Query("SELECT finalScore FROM GyroscopeScore WHERE Name = :name")
    LiveData<List<Float>> getGyroScore(String name);

    @Insert
    Long insertBarometerScore(BarometerScore barometerScore);

    @Query("SELECT finalScore FROM BarometerScore WHERE Name = :name")
    LiveData<List<Float>> getBarometerScore(String name);

    @Insert
    Long insertMagnetometerScore(MagnetometerScore magnetometerScore);

    @Query("SELECT finalScore FROM MagnetometerScore WHERE Name = :name")
    LiveData<List<Float>> getMagnetometerScore(String name);

    @Insert
    Long insertProximityScore(ProximityScore proximityScore);

    @Query("SELECT finalScore FROM ProximityScore WHERE Name = :name")
    LiveData<List<Float>> getProximityScore(String name);
}
