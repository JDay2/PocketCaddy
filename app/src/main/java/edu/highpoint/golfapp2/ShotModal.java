package edu.highpoint.golfapp2;

import android.graphics.Path;

import java.lang.reflect.Type;

public class ShotModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String Direction;
    private String Solid;
    private String Type;
    private int id;

    // creating getter and setter methods
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }


    public String getSolid() {
        return Solid;
    }

    public void setSolid(String solid) {
        this.Solid = solid;
    }


    public void setType(String type) {
        this.Type = type;
    }

    public String getType() {
        return Type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public ShotModal(String Direction, String Solid, String Type) {
        this.Direction = Direction;
        this.Solid = Solid;
        this.Type = Type;
    }
}