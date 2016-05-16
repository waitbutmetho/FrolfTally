package com.example.josh.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.josh.myapplication.Constants;
import com.example.josh.myapplication.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = HomeActivity.class.getSimpleName();
    @Bind(R.id.scoreTrackerBtn) Button mScoreTrackerBtn;
    @Bind(R.id.discVideosBtn) Button mDiscVideosBtn;
    @Bind(R.id.logoutBtn) Button mLogoutBtn;

    private Firebase mFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);

        mScoreTrackerBtn.setOnClickListener(this);
        mDiscVideosBtn.setOnClickListener(this);
        mLogoutBtn.setOnClickListener(this);
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
        if (v == mLogoutBtn) {
            logout();
            takeUserToLoginScreenOnUnAuth();
        }

    }

    protected void logout() {
        mFirebaseRef.unauth();
    }

    private void takeUserToLoginScreenOnUnAuth() {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
