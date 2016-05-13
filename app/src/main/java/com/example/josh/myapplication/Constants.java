package com.example.josh.myapplication;

public class Constants {
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;

    public static final String FIREBASE_LOCATION_GAMES = "games";
    public static final String FIREBASE_URL_GAMES = FIREBASE_URL + "/" + FIREBASE_LOCATION_GAMES;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
