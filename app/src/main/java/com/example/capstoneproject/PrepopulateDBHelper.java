/**
 *  Class for moving the prepopulated database present in assets folder
 *
 *  Class for also migrating existing sqlite .db file to room files
 */

package com.example.capstoneproject;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import androidx.room.Room;

public class PrepopulateDBHelper {
    private static final String TAG = PrepopulateDBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "Capstone.db";

    private Database mAppDataBase;
    private static Context appContext;

    private static class Holder {
        private static final PrepopulateDBHelper INSTANCE = new PrepopulateDBHelper();
    }

    public static PrepopulateDBHelper getInstance(Context context) {
        appContext = context;
        return Holder.INSTANCE;
    }

    public PrepopulateDBHelper() {
        //call method that check if database not exists and copy prepopulated file from assets
        copyAttachedDatabase(appContext, DATABASE_NAME);
        mAppDataBase = Room.databaseBuilder(appContext,
                Database.class, DATABASE_NAME)
                .addMigrations(Database.MIGRATION_1_2)
                .build();
    }

    public Database getRoomDatabase() {
        return mAppDataBase;
    }


    public void copyAttachedDatabase(Context context, String databaseName) {
        final File dbPath = context.getDatabasePath(databaseName);

        // If the database already exists, return
        if (dbPath.exists()) {
            return;
        }

        // Make sure we have a path to the file
        dbPath.getParentFile().mkdirs();

        // Try to copy database file
        try {
            final InputStream inputStream = context.getAssets().open("databases/" + databaseName);
            final OutputStream output = new FileOutputStream(dbPath);

            byte[] buffer = new byte[8192];
            int length;

            while ((length = inputStream.read(buffer, 0, 8192)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            inputStream.close();
        }
        catch (IOException e) {
            Log.d(TAG, "Failed to open file", e);
            e.printStackTrace();
        }
    }

}