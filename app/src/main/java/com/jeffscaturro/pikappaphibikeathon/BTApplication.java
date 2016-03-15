package com.jeffscaturro.pikappaphibikeathon;

import android.app.Application;

import com.jeffscaturro.pikappaphibikeathon.Models.Bike;
import com.jeffscaturro.pikappaphibikeathon.Models.Day;
import com.jeffscaturro.pikappaphibikeathon.Models.TimeSlot;
import com.parse.Parse;
import com.parse.ParseObject;

public class BTApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Parse Configuration
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Bike.class);
        ParseObject.registerSubclass(Day.class);
        ParseObject.registerSubclass(TimeSlot.class);
        Parse.initialize(this, "LQ4axs1j6w2wQAkgLbxsBSy3QVuCzeSSBSqYZKYO", "D48MVgGzQK8fYrzaWO3p9zuhXnhCcjwKatnbZ5Nz");
    }
}