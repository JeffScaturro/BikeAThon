package com.jeffscaturro.pikappaphibikeathon.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Bike")
public class Bike extends ParseObject {

    public Bike() { }

    public Bike(int num, String name, String org, boolean open, String day, String time) {
        setBikeNumber(num);
        setRiderName(name);
        setOpen(open);
        setRidingDay(day);
        setRidingTime(time);
    }

    public int getBikeNumber() {
        return getInt("bikeNumber");
    }

    public void setBikeNumber(int num) {
        put("bikeNumber", num);
    }

    public String getRiderName() {
        return getString("riderName");
    }

    public void setRiderName(String name) {
        put("riderName", name);
        if (!name.trim().equals("")) {
            setOpen(false);
        }
    }

    public String getRiderOrg() {
        return getString("riderOrg");
    }

    public void setRiderOrg(String org) {
        put("riderOrg", org);
    }

    public boolean getOpen() {
        return getBoolean("isOpen");
    }

    public void setOpen(boolean value) {
        put("isOpen", value);
    }

    public void setRidingDay(String day) {
        put("Day", day);
    }

    public void setRidingTime(String time) {
        put("Time", time);
    }

    public String getRidingDay(){
        return getString("Day");
    }
    public String getRidingTime(){
        return getString("Time");
    }
}
