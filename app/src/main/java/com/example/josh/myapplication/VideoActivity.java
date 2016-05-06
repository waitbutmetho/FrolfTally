package com.example.josh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private String GOOGLE_API_KEY = "AIzaSyCgpp39acbHjGYieMlUhkBaejHSQYpFCSs";
    private String YOUTUBE_VIDEO_ID = "TLowvHyhSWU";

    public static final String TAG = HomeActivity.class.getSimpleName();
    @Bind(R.id.whatIsDiscGolfBtn) Button mWhatIsDiscGolfBtn;
    @Bind(R.id.howToThrowBackhandBtn) Button mHowToThrowBackhandBtn;
    @Bind(R.id.howToPuttBtn) Button mHowToPuttBtn;
    @Bind(R.id.howToThrowSidearmBtn) Button mHowToThrowSidearmBtn;
    @Bind(R.id.howToThrowOverheadBtn) Button mHowToThrowOverheadBtn;
    @Bind(R.id.homeBtn) Button mHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        mWhatIsDiscGolfBtn.setOnClickListener(this);
        mHowToThrowBackhandBtn.setOnClickListener(this);
        mHowToThrowSidearmBtn.setOnClickListener(this);
        mHowToThrowOverheadBtn.setOnClickListener(this);
        mHowToPuttBtn.setOnClickListener(this);
        mHomeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch(v.getId()) {
            case R.id.whatIsDiscGolfBtn:
                intent = new Intent(VideoActivity.this, WhatIsDiscGolfVideoActivity.class);
                break;

            case R.id.homeBtn:
                intent = new Intent(VideoActivity.this, HomeActivity.class);
                break;

            case R.id.howToPuttBtn:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;

            case R.id.howToThrowBackhandBtn:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, "rCs5u9ecVis");
                break;

            case R.id.howToThrowSidearmBtn:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, "x7ewCoZ8BwM");
                break;

            case R.id.howToThrowOverheadBtn:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, "n7ZQbxrr1v8");
                break;
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
