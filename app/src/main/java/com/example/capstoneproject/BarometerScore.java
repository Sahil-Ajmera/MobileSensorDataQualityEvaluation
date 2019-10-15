/**
 *  Barometer table description in Room database format
 *
 *  All the fields have been defined as per table in .db file provided to app or room database
 */
package com.example.capstoneproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class BarometerScore implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @ColumnInfo(name = "Name")
    public String Name;

    // Getter and setter for Name field
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String generalFeatures;

    // Getter and setter for general features
    public String getGeneralFeatures() {
        return generalFeatures;
    }

    public void setGeneralFeatures(String generalFeatures) {
        this.generalFeatures = generalFeatures;
    }

    public String webLink;

    // Getter and setter for web link
    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public float lowestMeasurementRange;

    // Getter and setter for lowestMeasurementRange field
    public float getLowestMeasurementRange() {
        return lowestMeasurementRange;
    }

    public void setLowestMeasurementRange(float lowestMeasurementRange) {
        this.lowestMeasurementRange = lowestMeasurementRange;
    }

    public float normalizedlowestMeasurementRange;

    // Getter and setter for normalizedlowestMeasurementRange
    public float getNormalizedlowestMeasurementRange() {
        return normalizedlowestMeasurementRange;
    }

    public void setNormalizedlowestMeasurementRange(float normalizedlowestMeasurementRange) {
        this.normalizedlowestMeasurementRange = normalizedlowestMeasurementRange;
    }


    public float highestMeasurementRange;

    // Getter and setter for highestMeasurementRange
    public float getHighestMeasurementRange() {
        return highestMeasurementRange;
    }

    public void setHighestMeasurementRange(float highestMeasurementRange) {
        this.highestMeasurementRange = highestMeasurementRange;
    }

    public float normalizedhighestMeasurementRange;

    // Getter and setter for normalizedhighestMeasurementRange
    public float getNormalizedhighestMeasurementRange() {
        return normalizedhighestMeasurementRange;
    }

    public void setNormalizedhighestMeasurementRange(float normalizedhighestMeasurementRange) {
        this.normalizedhighestMeasurementRange = normalizedhighestMeasurementRange;
    }

    public float absoluteAccuracy;

    // Getter and setter for noise density
    public float getAbsoluteAccuracy() {
        return absoluteAccuracy;
    }

    public void setAbsoluteAccuracy(float absoluteAccuracy) {
        this.absoluteAccuracy = absoluteAccuracy;
    }

    public float normalizedabsoluteAccuracy;

    // Getter and setter for normalizedabsoluteAccuracy
    public float getNormalizedabsoluteAccuracy() {
        return normalizedabsoluteAccuracy;
    }

    public void setNormalizedabsoluteAccuracy(float absoluteAccuracy) {
        this.normalizedabsoluteAccuracy = normalizedabsoluteAccuracy;
    }

    public float noise;

    // Getter and setter for noise
    public float getNoise() {
        return noise;
    }

    public void setNoise(float noise) {
        this.noise = noise;
    }

    public float normalizednoise;

    // Getter and setter for normalizednoise
    public float getNormalizednoise() {
        return normalizednoise;
    }

    public void setNormalizednoise(float normalizednoise) {
        this.normalizednoise = normalizednoise;
    }

    @ColumnInfo(name = "finalScore")
    public float finalScore;

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }
}
