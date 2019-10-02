/**
 *  AccelerometerScore table description in Room database format
 *
 *  All the fields have been defined as per table in .db file provided to app or room database
 */
package com.example.capstoneproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class AccelerometerScore implements Serializable {

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

    public float noiseDensity;

    // Getter and setter for noise density
    public float getNoiseDensity() {
        return noiseDensity;
    }

    public void setNoiseDensity(float noiseDensity) {
        this.noiseDensity = noiseDensity;
    }

    public float normalizednoiseDensity;

    // Getter and setter for normalizednoisedensity
    public float getNormalizednoiseDensity() {
        return normalizednoiseDensity;
    }

    public void setNormalizednoiseDensity(float normalizednoiseDensity) {
        this.normalizednoiseDensity = normalizednoiseDensity;
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
