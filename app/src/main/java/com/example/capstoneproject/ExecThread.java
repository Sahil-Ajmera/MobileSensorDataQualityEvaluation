/**
 *  An execution class for any database function
 */

package com.example.capstoneproject;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class ExecThread {

    private String DB_NAME = "Capstone.db";
    private Database database;

    public  ExecThread(Context context){
        database = Room.databaseBuilder(context,Database.class, DB_NAME).build();
    }

    public LiveData<List<Float>> getAccScore(String name){
        return database.daoAccess().getAccScore(name);
    }

    public void insertAccScore(final AccelerometerScore accelerometerScore){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.daoAccess().insertAccScore(accelerometerScore);
                return null;
            }
        }.execute();

    }

    public LiveData<List<Float>> getGyroScore(String name){
        return database.daoAccess().getGyroScore(name);
    }

    public LiveData<List<Float>> getBarometerScore(String name){
        return database.daoAccess().getBarometerScore(name);
    }

    public LiveData<List<Float>> getMagnetometerScore(String name){
        return database.daoAccess().getMagnetometerScore(name);
    }

    public LiveData<List<Float>> getProximityScore(String name){
        return database.daoAccess().getProximityScore(name);
    }
}
