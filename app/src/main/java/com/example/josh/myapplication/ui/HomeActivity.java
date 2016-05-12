package com.example.josh.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.josh.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = HomeActivity.class.getSimpleName();
    @Bind(R.id.scoreTrackerBtn) Button mScoreTrackerBtn;
    @Bind(R.id.discVideosBtn) Button mDiscVideosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mScoreTrackerBtn.setOnClickListener(this);
        mDiscVideosBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mScoreTrackerBtn) {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (v == mDiscVideosBtn) {
            Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
            startActivity(intent);
        }

    }
}
