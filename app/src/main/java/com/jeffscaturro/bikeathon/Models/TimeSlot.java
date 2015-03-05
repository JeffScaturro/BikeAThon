package com.jeffscaturro.bikeathon.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.ArrayList;


@ParseClassName("TimeSlot")
public class TimeSlot extends ParseObject {

    public TimeSlot() { }

    public TimeSlot(String time, ArrayList<Bike> bikes, boolean openBikes) {
        setTime(time);
        setBikes(bikes);
        setHasOpenBike(openBikes);
    }


    public String getTime() {
        return getString("time");
    }

    public void setTime(String time) {
        put("time", time);
    }

    public ArrayList<Bike> getBikes() {
        return (ArrayList<Bike>) get("bikes");
    }

    public void setBikes(ArrayList<Bike> bikes) {
        put("bikes", bikes);
    }

    public boolean isHasOpenBike() {
        return getBoolean("openBike");
    }

    public void setHasOpenBike(boolean hasOpenBike) {
        put("openBike", hasOpenBike);
    }
}
