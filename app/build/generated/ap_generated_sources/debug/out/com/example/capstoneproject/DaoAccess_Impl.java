package com.example.capstoneproject;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Float;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class DaoAccess_Impl implements DaoAccess {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAccelerometerScore;

  public DaoAccess_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAccelerometerScore = new EntityInsertionAdapter<AccelerometerScore>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `AccelerometerScore`(`sid`,`Name`,`generalFeatures`,`webLink`,`valueSensitivity`,`normalizedvalueSensitivity`,`valueNonLinearity`,`normalizedvalueNonLinearity`,`noiseDensity`,`normalizednoiseDensity`,`finalScore`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AccelerometerScore value) {
        stmt.bindLong(1, value.sid);
        if (value.Name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.Name);
        }
        if (value.generalFeatures == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.generalFeatures);
        }
        if (value.webLink == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.webLink);
        }
        stmt.bindDouble(5, value.valueSensitivity);
        stmt.bindDouble(6, value.normalizedvalueSensitivity);
        stmt.bindDouble(7, value.valueNonLinearity);
        stmt.bindDouble(8, value.normalizedvalueNonLinearity);
        stmt.bindDouble(9, value.noiseDensity);
        stmt.bindDouble(10, value.normalizednoiseDensity);
        stmt.bindDouble(11, value.finalScore);
      }
    };
  }

  @Override
  public Long insertAccScore(AccelerometerScore accelerometerScore) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAccelerometerScore.insertAndReturnId(accelerometerScore);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Float>> getAccScore(String name) {
    final String _sql = "SELECT finalScore FROM AccelerometerScore WHERE Name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return new ComputableLiveData<List<Float>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Float> compute() {
        if (_observer == null) {
          _observer = new Observer("AccelerometerScore") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final List<Float> _result = new ArrayList<Float>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Float _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getFloat(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
