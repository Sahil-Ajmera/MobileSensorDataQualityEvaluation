package com.dataqualitylab.sensorquality;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class Database_Impl extends Database {
  private volatile DaoAccess _daoAccess;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(10) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AccelerometerScore` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `generalFeatures` TEXT, `webLink` TEXT, `valueSensitivity` REAL NOT NULL, `normalizedvalueSensitivity` REAL NOT NULL, `valueNonLinearity` REAL NOT NULL, `normalizedvalueNonLinearity` REAL NOT NULL, `noiseDensity` REAL NOT NULL, `normalizednoiseDensity` REAL NOT NULL, `finalScore` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `GyroscopeScore` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `GyroFeatures` TEXT, `GyroWebLink` TEXT, `valueSensitivity` REAL NOT NULL, `normalizedvalueSensitivity` REAL NOT NULL, `valueNoiseDensity` REAL NOT NULL, `normalizedvalueNoiseDensity` REAL NOT NULL, `valueCrossAxisSensitivity` REAL NOT NULL, `normalizedvalueCrossAxisSensitivity` REAL NOT NULL, `valueNonLinearity` REAL NOT NULL, `normalizedvalueNonLinearity` REAL NOT NULL, `finalScore` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BarometerScore` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `generalFeatures` TEXT, `webLink` TEXT, `lowestMeasurementRange` REAL NOT NULL, `normalizedlowestMeasurementRange` REAL NOT NULL, `highestMeasurementRange` REAL NOT NULL, `normalizedhighestMeasurementRange` REAL NOT NULL, `absoluteAccuracy` REAL NOT NULL, `normalizedabsoluteAccuracy` REAL NOT NULL, `noise` REAL NOT NULL, `normalizednoise` REAL NOT NULL, `finalScore` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MagnetometerScore` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `generalFeatures` TEXT, `webLink` TEXT, `valueNonLinearity` REAL NOT NULL, `normalizedvalueNonLinearity` REAL NOT NULL, `valueSensitivity` REAL NOT NULL, `normalizedvalueSensitivity` REAL NOT NULL, `noise` REAL NOT NULL, `normalizednoise` REAL NOT NULL, `headingAccuracy` REAL NOT NULL, `normalizedheadingAccuracy` REAL NOT NULL, `magneticFieldRange` REAL NOT NULL, `normalizedmagneticFieldRange` REAL NOT NULL, `resolution` REAL NOT NULL, `normalizedResolution` REAL NOT NULL, `finalScore` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ProximityScore` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `generalFeatures` TEXT, `webLink` TEXT, `resolution` REAL NOT NULL, `normalizedResolution` REAL NOT NULL, `valueRange` REAL NOT NULL, `normalizedvalueRange` REAL NOT NULL, `absoluteResponse` REAL NOT NULL, `normalizedabsoluteResponse` REAL NOT NULL, `finalScore` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"fc0168b8d7ef8b64a07621d7af7d4ceb\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `AccelerometerScore`");
        _db.execSQL("DROP TABLE IF EXISTS `GyroscopeScore`");
        _db.execSQL("DROP TABLE IF EXISTS `BarometerScore`");
        _db.execSQL("DROP TABLE IF EXISTS `MagnetometerScore`");
        _db.execSQL("DROP TABLE IF EXISTS `ProximityScore`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAccelerometerScore = new HashMap<String, TableInfo.Column>(11);
        _columnsAccelerometerScore.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1));
        _columnsAccelerometerScore.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsAccelerometerScore.put("generalFeatures", new TableInfo.Column("generalFeatures", "TEXT", false, 0));
        _columnsAccelerometerScore.put("webLink", new TableInfo.Column("webLink", "TEXT", false, 0));
        _columnsAccelerometerScore.put("valueSensitivity", new TableInfo.Column("valueSensitivity", "REAL", true, 0));
        _columnsAccelerometerScore.put("normalizedvalueSensitivity", new TableInfo.Column("normalizedvalueSensitivity", "REAL", true, 0));
        _columnsAccelerometerScore.put("valueNonLinearity", new TableInfo.Column("valueNonLinearity", "REAL", true, 0));
        _columnsAccelerometerScore.put("normalizedvalueNonLinearity", new TableInfo.Column("normalizedvalueNonLinearity", "REAL", true, 0));
        _columnsAccelerometerScore.put("noiseDensity", new TableInfo.Column("noiseDensity", "REAL", true, 0));
        _columnsAccelerometerScore.put("normalizednoiseDensity", new TableInfo.Column("normalizednoiseDensity", "REAL", true, 0));
        _columnsAccelerometerScore.put("finalScore", new TableInfo.Column("finalScore", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAccelerometerScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAccelerometerScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAccelerometerScore = new TableInfo("AccelerometerScore", _columnsAccelerometerScore, _foreignKeysAccelerometerScore, _indicesAccelerometerScore);
        final TableInfo _existingAccelerometerScore = TableInfo.read(_db, "AccelerometerScore");
        if (! _infoAccelerometerScore.equals(_existingAccelerometerScore)) {
          throw new IllegalStateException("Migration didn't properly handle AccelerometerScore(com.dataqualitylab.sensorquality.AccelerometerScore).\n"
                  + " Expected:\n" + _infoAccelerometerScore + "\n"
                  + " Found:\n" + _existingAccelerometerScore);
        }
        final HashMap<String, TableInfo.Column> _columnsGyroscopeScore = new HashMap<String, TableInfo.Column>(13);
        _columnsGyroscopeScore.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1));
        _columnsGyroscopeScore.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsGyroscopeScore.put("GyroFeatures", new TableInfo.Column("GyroFeatures", "TEXT", false, 0));
        _columnsGyroscopeScore.put("GyroWebLink", new TableInfo.Column("GyroWebLink", "TEXT", false, 0));
        _columnsGyroscopeScore.put("valueSensitivity", new TableInfo.Column("valueSensitivity", "REAL", true, 0));
        _columnsGyroscopeScore.put("normalizedvalueSensitivity", new TableInfo.Column("normalizedvalueSensitivity", "REAL", true, 0));
        _columnsGyroscopeScore.put("valueNoiseDensity", new TableInfo.Column("valueNoiseDensity", "REAL", true, 0));
        _columnsGyroscopeScore.put("normalizedvalueNoiseDensity", new TableInfo.Column("normalizedvalueNoiseDensity", "REAL", true, 0));
        _columnsGyroscopeScore.put("valueCrossAxisSensitivity", new TableInfo.Column("valueCrossAxisSensitivity", "REAL", true, 0));
        _columnsGyroscopeScore.put("normalizedvalueCrossAxisSensitivity", new TableInfo.Column("normalizedvalueCrossAxisSensitivity", "REAL", true, 0));
        _columnsGyroscopeScore.put("valueNonLinearity", new TableInfo.Column("valueNonLinearity", "REAL", true, 0));
        _columnsGyroscopeScore.put("normalizedvalueNonLinearity", new TableInfo.Column("normalizedvalueNonLinearity", "REAL", true, 0));
        _columnsGyroscopeScore.put("finalScore", new TableInfo.Column("finalScore", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGyroscopeScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGyroscopeScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGyroscopeScore = new TableInfo("GyroscopeScore", _columnsGyroscopeScore, _foreignKeysGyroscopeScore, _indicesGyroscopeScore);
        final TableInfo _existingGyroscopeScore = TableInfo.read(_db, "GyroscopeScore");
        if (! _infoGyroscopeScore.equals(_existingGyroscopeScore)) {
          throw new IllegalStateException("Migration didn't properly handle GyroscopeScore(com.dataqualitylab.sensorquality.GyroscopeScore).\n"
                  + " Expected:\n" + _infoGyroscopeScore + "\n"
                  + " Found:\n" + _existingGyroscopeScore);
        }
        final HashMap<String, TableInfo.Column> _columnsBarometerScore = new HashMap<String, TableInfo.Column>(13);
        _columnsBarometerScore.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1));
        _columnsBarometerScore.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsBarometerScore.put("generalFeatures", new TableInfo.Column("generalFeatures", "TEXT", false, 0));
        _columnsBarometerScore.put("webLink", new TableInfo.Column("webLink", "TEXT", false, 0));
        _columnsBarometerScore.put("lowestMeasurementRange", new TableInfo.Column("lowestMeasurementRange", "REAL", true, 0));
        _columnsBarometerScore.put("normalizedlowestMeasurementRange", new TableInfo.Column("normalizedlowestMeasurementRange", "REAL", true, 0));
        _columnsBarometerScore.put("highestMeasurementRange", new TableInfo.Column("highestMeasurementRange", "REAL", true, 0));
        _columnsBarometerScore.put("normalizedhighestMeasurementRange", new TableInfo.Column("normalizedhighestMeasurementRange", "REAL", true, 0));
        _columnsBarometerScore.put("absoluteAccuracy", new TableInfo.Column("absoluteAccuracy", "REAL", true, 0));
        _columnsBarometerScore.put("normalizedabsoluteAccuracy", new TableInfo.Column("normalizedabsoluteAccuracy", "REAL", true, 0));
        _columnsBarometerScore.put("noise", new TableInfo.Column("noise", "REAL", true, 0));
        _columnsBarometerScore.put("normalizednoise", new TableInfo.Column("normalizednoise", "REAL", true, 0));
        _columnsBarometerScore.put("finalScore", new TableInfo.Column("finalScore", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBarometerScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBarometerScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBarometerScore = new TableInfo("BarometerScore", _columnsBarometerScore, _foreignKeysBarometerScore, _indicesBarometerScore);
        final TableInfo _existingBarometerScore = TableInfo.read(_db, "BarometerScore");
        if (! _infoBarometerScore.equals(_existingBarometerScore)) {
          throw new IllegalStateException("Migration didn't properly handle BarometerScore(com.dataqualitylab.sensorquality.BarometerScore).\n"
                  + " Expected:\n" + _infoBarometerScore + "\n"
                  + " Found:\n" + _existingBarometerScore);
        }
        final HashMap<String, TableInfo.Column> _columnsMagnetometerScore = new HashMap<String, TableInfo.Column>(17);
        _columnsMagnetometerScore.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1));
        _columnsMagnetometerScore.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsMagnetometerScore.put("generalFeatures", new TableInfo.Column("generalFeatures", "TEXT", false, 0));
        _columnsMagnetometerScore.put("webLink", new TableInfo.Column("webLink", "TEXT", false, 0));
        _columnsMagnetometerScore.put("valueNonLinearity", new TableInfo.Column("valueNonLinearity", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizedvalueNonLinearity", new TableInfo.Column("normalizedvalueNonLinearity", "REAL", true, 0));
        _columnsMagnetometerScore.put("valueSensitivity", new TableInfo.Column("valueSensitivity", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizedvalueSensitivity", new TableInfo.Column("normalizedvalueSensitivity", "REAL", true, 0));
        _columnsMagnetometerScore.put("noise", new TableInfo.Column("noise", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizednoise", new TableInfo.Column("normalizednoise", "REAL", true, 0));
        _columnsMagnetometerScore.put("headingAccuracy", new TableInfo.Column("headingAccuracy", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizedheadingAccuracy", new TableInfo.Column("normalizedheadingAccuracy", "REAL", true, 0));
        _columnsMagnetometerScore.put("magneticFieldRange", new TableInfo.Column("magneticFieldRange", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizedmagneticFieldRange", new TableInfo.Column("normalizedmagneticFieldRange", "REAL", true, 0));
        _columnsMagnetometerScore.put("resolution", new TableInfo.Column("resolution", "REAL", true, 0));
        _columnsMagnetometerScore.put("normalizedResolution", new TableInfo.Column("normalizedResolution", "REAL", true, 0));
        _columnsMagnetometerScore.put("finalScore", new TableInfo.Column("finalScore", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMagnetometerScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMagnetometerScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMagnetometerScore = new TableInfo("MagnetometerScore", _columnsMagnetometerScore, _foreignKeysMagnetometerScore, _indicesMagnetometerScore);
        final TableInfo _existingMagnetometerScore = TableInfo.read(_db, "MagnetometerScore");
        if (! _infoMagnetometerScore.equals(_existingMagnetometerScore)) {
          throw new IllegalStateException("Migration didn't properly handle MagnetometerScore(com.dataqualitylab.sensorquality.MagnetometerScore).\n"
                  + " Expected:\n" + _infoMagnetometerScore + "\n"
                  + " Found:\n" + _existingMagnetometerScore);
        }
        final HashMap<String, TableInfo.Column> _columnsProximityScore = new HashMap<String, TableInfo.Column>(11);
        _columnsProximityScore.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1));
        _columnsProximityScore.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsProximityScore.put("generalFeatures", new TableInfo.Column("generalFeatures", "TEXT", false, 0));
        _columnsProximityScore.put("webLink", new TableInfo.Column("webLink", "TEXT", false, 0));
        _columnsProximityScore.put("resolution", new TableInfo.Column("resolution", "REAL", true, 0));
        _columnsProximityScore.put("normalizedResolution", new TableInfo.Column("normalizedResolution", "REAL", true, 0));
        _columnsProximityScore.put("valueRange", new TableInfo.Column("valueRange", "REAL", true, 0));
        _columnsProximityScore.put("normalizedvalueRange", new TableInfo.Column("normalizedvalueRange", "REAL", true, 0));
        _columnsProximityScore.put("absoluteResponse", new TableInfo.Column("absoluteResponse", "REAL", true, 0));
        _columnsProximityScore.put("normalizedabsoluteResponse", new TableInfo.Column("normalizedabsoluteResponse", "REAL", true, 0));
        _columnsProximityScore.put("finalScore", new TableInfo.Column("finalScore", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProximityScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProximityScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProximityScore = new TableInfo("ProximityScore", _columnsProximityScore, _foreignKeysProximityScore, _indicesProximityScore);
        final TableInfo _existingProximityScore = TableInfo.read(_db, "ProximityScore");
        if (! _infoProximityScore.equals(_existingProximityScore)) {
          throw new IllegalStateException("Migration didn't properly handle ProximityScore(com.dataqualitylab.sensorquality.ProximityScore).\n"
                  + " Expected:\n" + _infoProximityScore + "\n"
                  + " Found:\n" + _existingProximityScore);
        }
      }
    }, "fc0168b8d7ef8b64a07621d7af7d4ceb", "d4c82078469a4ae24caac6785535f4f3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "AccelerometerScore","GyroscopeScore","BarometerScore","MagnetometerScore","ProximityScore");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `AccelerometerScore`");
      _db.execSQL("DELETE FROM `GyroscopeScore`");
      _db.execSQL("DELETE FROM `BarometerScore`");
      _db.execSQL("DELETE FROM `MagnetometerScore`");
      _db.execSQL("DELETE FROM `ProximityScore`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DaoAccess daoAccess() {
    if (_daoAccess != null) {
      return _daoAccess;
    } else {
      synchronized(this) {
        if(_daoAccess == null) {
          _daoAccess = new DaoAccess_Impl(this);
        }
        return _daoAccess;
      }
    }
  }
}
