package com.jeffscaturro.bikeathon.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Bike")
public class Bike extends ParseObject {

    public Bike() { }

    public Bike(int num, String name, boolean open) {
        setBikeNumber(num);
        setRiderName(name);
        setOpen(open);
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
    }

    public boolean getOpen() {
        return getBoolean("isOpen");
    }

    public void setOpen(boolean value) {
        put("isOpen", value);
    }
}
