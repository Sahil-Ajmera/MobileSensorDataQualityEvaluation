package com.example.capstoneproject;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {AccelerometerScore.class},version = 6, exportSchema = false)
abstract class Database extends RoomDatabase{

    public abstract DaoAccess daoAccess();

    static final Migration MIGRATION_1_2
            = new Migration(1, 2) {
        @Override public void migrate(
                SupportSQLiteDatabase database) {
        }
    };
}

//public abstract class Database extends RoomDatabase {

  //  public abstract DaoAccess daoAccess();
//}