/**
 *  Gyroscope table description in Room database format
 *
 *  All the fields have been defined as per table in .db file provided to app or room database
 */
package com.example.capstoneproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class GyroscopeScore implements Serializable {

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

    public String GyroFeatures;

    // Getter and setter for general features for Gyroscope
    public String getGyroFeatures() {
        return GyroFeatures;
    }

    public void setGyroFeatures(String GyroFeatures) {
        this.GyroFeatures = GyroFeatures;
    }

    public String GyroWebLink;

    // Getter and setter for web link for Gyroscope
    public String getGyroWebLink() {
        return GyroWebLink;
    }

    public void setGyroWebLink(String GyroWebLink) {
        this.GyroWebLink = GyroWebLink;
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

    public float valueNoiseDensity;


    // Getter and setter for valueNoiseDensity
    public float getValueNoiseDensity() {
        return valueNoiseDensity;
    }

    public void setValueNoiseDensity(float valueNoiseDensity) {
        this.valueNoiseDensity = valueNoiseDensity;
    }

    public float normalizedvalueNoiseDensity;

    // Getter and setter for normalized valueNoiseDensity
    public float getNormalizedvalueNoiseDensity() {
        return valueNoiseDensity;
    }

    public void setNormalizedvalueNoiseDensity(float valueNoiseDensity) {
        this.valueNoiseDensity = valueNoiseDensity;
    }

    public float valueCrossAxisSensitivity;

    // Getter and setter for valueCrossAxisSensitivity
    public float getValueCrossAxisSensitivity() {
        return valueCrossAxisSensitivity;
    }

    public void setValueCrossAxisSensitivity(float valueCrossAxisSensitivity) {
        this.valueCrossAxisSensitivity = valueCrossAxisSensitivity;
    }

    public float normalizedvalueCrossAxisSensitivity;

    // Getter and setter for normalizedvalueCrossAxisSensitivity
    public float getNormalizedvalueCrossAxisSensitivity() {
        return normalizedvalueCrossAxisSensitivity;
    }

    public void setNormalizedvalueCrossAxisSensitivity(float normalizedvalueCrossAxisSensitivity) {
        this.normalizedvalueCrossAxisSensitivity = normalizedvalueCrossAxisSensitivity;
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

    @ColumnInfo(name = "finalScore")
    public float finalScore;

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }
}
