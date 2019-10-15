/**
 *  Magnetometer table description in Room database format
 *
 *  All the fields have been defined as per table in .db file provided to app or room database
 */
package com.example.capstoneproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class MagnetometerScore implements Serializable {

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


    public float valueNonLinearity;


    // Getter and setter for valueNonLinearity
    public float getValueNonLinearity() {
        return valueNonLinearity;
    }

    public void setValueNonLinearity(float valueNonLinearity) {
        this.valueNonLinearity = valueNonLinearity;
    }

    public float normalizedvalueNonLinearity;

    // Getter and setter for normalized value non linearity
    public float getNormalizedvalueNonLinearity() {
        return normalizedvalueNonLinearity;
    }

    public void setNormalizedvalueNonLinearity(float normalizedvalueNonLinearity) {
        this.normalizedvalueNonLinearity = normalizedvalueNonLinearity;
    }

    public float valueSensitivity;

    // Getter and setter for valueSensitivity field
    public float getValueSensitivity() {
        return valueSensitivity;
    }

    public void setValueSensitivity(float valueSensitivity) {
        this.valueSensitivity = valueSensitivity;
    }

    public float normalizedvalueSensitivity;

    // Getter and setter for normalized value sensitivity
    public float getNormalizedvalueSensitivity() {
        return normalizedvalueSensitivity;
    }

    public void setNormalizedvalueSensitivity(float normalizedvalueSensitivity) {
        this.normalizedvalueSensitivity = normalizedvalueSensitivity;
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

    public float headingAccuracy;

    // Getter and setter for headingAccuracy
    public float getHeadingAccuracy() {
        return headingAccuracy;
    }

    public void setHeadingAccuracy(float headingAccuracy) {
        this.headingAccuracy = headingAccuracy;
    }

    public float normalizedheadingAccuracy;

    // Getter and setter for normalizedheadingAccuracy
    public float getNormalizedheadingAccuracy() {
        return normalizedheadingAccuracy;
    }

    public void setNormalizedheadingAccuracy(float normalizedheadingAccuracy) {
        this.normalizedheadingAccuracy = normalizedheadingAccuracy;
    }

    public float magneticFieldRange;

    // Getter and setter for Magnetic Field Range
    public float getMagneticFieldRange() {
        return magneticFieldRange;
    }

    public void setMagneticFieldRange(float magneticFieldRange) {
        this.magneticFieldRange = magneticFieldRange;
    }

    public float normalizedmagneticFieldRange;

    // Getter and setter for normalizedmagneticFieldRange
    public float getNormalizedmagneticFieldRange() {
        return normalizedmagneticFieldRange;
    }

    public void setNormalizedmagneticFieldRange(float normalizedmagneticFieldRange) {
        this.normalizedmagneticFieldRange = normalizedmagneticFieldRange;
    }

    public float resolution;

    // Getter and setter for Resolution
    public float getResolution() {
        return resolution;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public float normalizedResolution;

    // Getter and setter for normalizedResolution
    public float normalizedResolution() {
        return normalizedResolution;
    }

    public void setNormalizedResolution(float normalizedResolution) {
        this.normalizedResolution = normalizedResolution;
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
