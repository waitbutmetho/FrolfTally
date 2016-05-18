package com.example.josh.myapplication.models;

import android.content.Intent;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Game {
    String gameName;
    String courseName;
    List<Integer> holeScores = new ArrayList<>();
    int totalScore;
    int gameRating;
    private String pushId;

    public Game() {}

public Game(String gameName, String courseName, int totalScore, int gameRating, ArrayList<Integer> holeScores) {
    this.gameName = gameName;
    this.holeScores = holeScores;
    this.totalScore = totalScore;
    this.gameRating = gameRating;
    this.courseName = courseName;
    }

    public String getGameName() {
        return gameName;
    }

    public List<Integer> getHoleScores() {
        return holeScores;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getGameRating() {
        return gameRating;
    }
}