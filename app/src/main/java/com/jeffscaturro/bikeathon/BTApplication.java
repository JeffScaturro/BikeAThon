package com.jeffscaturro.bikeathon;

import android.app.Application;

import com.parse.Parse;

public class BTApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Parse Configuration
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "LQ4axs1j6w2wQAkgLbxsBSy3QVuCzeSSBSqYZKYO", "D48MVgGzQK8fYrzaWO3p9zuhXnhCcjwKatnbZ5Nz");
    }
}