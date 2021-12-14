package edu.highpoint.golfapp2;

import android.graphics.Path;

import java.lang.reflect.Type;

public class HoleModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String Name;
    private String lat;
    private String lon;
    private int id;

    // creating getter and setter methods
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getlat() {
        return lat;
    }

    public void setlat(String lat) {
        this.lat = lat;
    }


    public void setlon(String lon) {
        this.lon = lon;
    }

    public String getlon() {
        return lon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public HoleModal(String Name, String lat, String lon) {
        this.Name = Name;
        this.lat = lat;
        this.lon = lon;
    }
}