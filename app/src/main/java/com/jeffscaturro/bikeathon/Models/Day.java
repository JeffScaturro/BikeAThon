package com.jeffscaturro.bikeathon.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.ArrayList;

@ParseClassName("Day")
public class Day extends ParseObject {

    public Day() { }

    public Day(String dayName, ArrayList<TimeSlot> slots) {
        setDay(dayName);
        setTimeSlots(slots);
    }

    public String getDay() {
        return getString("dayTitle");
    }

    public void setDay(String day) {
        put("dayTitle", day);
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return (ArrayList<TimeSlot>) get("timeSlots");
    }

    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        put("timeSlots", timeSlots);
    }
}
