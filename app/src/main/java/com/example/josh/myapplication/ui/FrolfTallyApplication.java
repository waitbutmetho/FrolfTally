package com.example.josh.myapplication.ui;

import android.app.Application;

import com.firebase.client.Firebase;

public class FrolfTallyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
