package edu.highpoint.golfapp2;

import android.graphics.Path;

public class ShotModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String Direction;
    private String solid;
    private String type;
    private int id;

    // creating getter and setter methods
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }


    public String getSolid() {
        return solid;
    }

    public void setSolid(String solid) {
        this.solid = solid;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public ShotModal(String Direction, String solid, String type) {
        this.Direction = Direction;
        this.solid = solid;
        this.type = type;
    }
}