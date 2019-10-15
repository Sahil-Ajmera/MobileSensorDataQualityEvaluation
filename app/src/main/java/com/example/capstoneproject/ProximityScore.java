/**
 *  ProximityScore table description in Room database format
 *
 *  All the fields have been defined as per table in .db file provided to app or room database
 */
package com.example.capstoneproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ProximityScore implements Serializable {

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

    public float resolution;

    // Getter and setter for Resolution field
    public float getResolution() {
        return resolution;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public float normalizedResolution;

    // Getter and setter for normalizedResolution field
    public float getNormalizedResolution() {
        return normalizedResolution;
    }

    public void setNormalizedResolution(float normalizedResolution) {
        this.normalizedResolution = normalizedResolution;
    }


    public float valueRange;

    // Getter and setter for valueRange
    public float getValueRange() {
        return valueRange;
    }

    public void setValueRange(float valueRange) {
        this.valueRange = valueRange;
    }

    public float normalizedvalueRange;

    // Getter and setter for normalizedvalueRange
    public float getNormalizedvalueRange() {
        return normalizedvalueRange;
    }

    public void setNormalizedvalueRange(float normalizedvalueRange) {
        this.normalizedvalueRange = normalizedvalueRange;
    }

    public float absoluteResponse;

    // Getter and setter for absoluteResponse
    public float getAbsoluteResponse() {
        return absoluteResponse;
    }

    public void setAbsoluteResponse(float absoluteResponse) {
        this.absoluteResponse = absoluteResponse;
    }

    public float normalizedabsoluteResponse;

    // Getter and setter for normalizedabsoluteResponse
    public float getNormalizedabsoluteResponse() {
        return normalizedabsoluteResponse;
    }

    public void setNormalizedabsoluteResponse(float normalizedabsoluteResponse) {
        this.normalizedabsoluteResponse = normalizedabsoluteResponse;
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
