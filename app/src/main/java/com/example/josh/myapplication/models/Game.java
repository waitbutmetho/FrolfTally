package com.example.josh.myapplication.models;

import android.content.Intent;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Game {
    String gameName;
    List<Integer> holeScores = new ArrayList<>();
    int totalScore;
    private String pushId;


    public Game() {}

public Game(String gameName, ArrayList<Integer> holeScores, int totalScore) {
    this.gameName = gameName;
    this.holeScores = holeScores;
    this.totalScore = totalScore;
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
}