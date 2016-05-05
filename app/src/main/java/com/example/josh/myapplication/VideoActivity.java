package com.example.josh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = HomeActivity.class.getSimpleName();
    @Bind(R.id.whatIsDiscGolfBtn)
    Button mWhatIsDiscGolfBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        mWhatIsDiscGolfBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mWhatIsDiscGolfBtn) {
            Intent intent = new Intent(VideoActivity.this, WhatIsDiscGolfVideoActivity.class);
            startActivity(intent);
        }
    }
}
