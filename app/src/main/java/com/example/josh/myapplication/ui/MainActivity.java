package com.example.josh.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.josh.myapplication.Constants;
import com.example.josh.myapplication.R;
import com.example.josh.myapplication.models.Game;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] holes = {"Hole 1", "Hole 2", "Hole 3", "Hole 4", "Hole 5", "Hole 6", "Hole 7", "Hole 8", "Hole 9", "Hole 10", "Hole 11", "Hole 12", "Hole 13", "Hole 14", "Hole 15", "Hole 16", "Hole 17", "Hole 18"};
    int holeCounter = 0;
    int holeScoreCounter = 0;


    ArrayList<Integer> holeScores = new ArrayList<>();
    int totalScore = 50;
    String gameName = "Game Name";


    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.homeBtn) Button mHomeBtn;
    @Bind(R.id.previousHoleBtn) Button mPreviousHoleBtn;
    @Bind(R.id.nextHoleBtn) Button mNextHoleBtn;
    @Bind(R.id.plusOnePointBtn) Button mPlusOnePointBtn;
    @Bind(R.id.minusOnePointBtn) Button mMinusOnePointBtn;
    @Bind(R.id.currentHoleView) TextView mCurrentHoleView;
    @Bind(R.id.currentHoleScoreView) TextView mCurrentHoleScoreView;
    @Bind(R.id.saveRoundBtn) TextView mSaveRoundBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        holeScores.add(1);
        holeScores.add(2);
        holeScores.add(3);
        holeScores.add(4);
        holeScores.add(5);
        holeScores.add(6);
        holeScores.add(7);
        holeScores.add(8);
        holeScores.add(9);
        holeScores.add(10);
        holeScores.add(11);
        holeScores.add(12);
        holeScores.add(13);
        holeScores.add(14);
        holeScores.add(15);
        holeScores.add(16);
        holeScores.add(17);
        holeScores.add(18);

        mHomeBtn.setOnClickListener(this);
        mNextHoleBtn.setOnClickListener(this);
        mPreviousHoleBtn.setOnClickListener(this);
        mPlusOnePointBtn.setOnClickListener(this);
        mMinusOnePointBtn.setOnClickListener(this);
        mSaveRoundBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mHomeBtn) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        if (v == mSaveRoundBtn) {
            Game mGame = new Game(gameName, holeScores, totalScore);
            Firebase ref = new Firebase(Constants.FIREBASE_URL_GAMES);
            ref.push().setValue(mGame);
            Toast.makeText(MainActivity.this, "Game Saved", Toast.LENGTH_SHORT).show();
        }

        if (v == mPlusOnePointBtn) {
            holeScoreCounter++;
            mCurrentHoleScoreView.setText(Integer.toString(holeScoreCounter));
        }

        if (v == mMinusOnePointBtn) {
            holeScoreCounter--;
            mCurrentHoleScoreView.setText(Integer.toString(holeScoreCounter));
        }

        if (v == mNextHoleBtn) {
           if(holeCounter == 0) {
               mCurrentHoleView.setText(holes[1]);
               holeCounter++;
           } else if(holeCounter == 1){
               mCurrentHoleView.setText(holes[2]);
               holeCounter++;
           } else if(holeCounter == 2){
               mCurrentHoleView.setText(holes[3]);
               holeCounter++;
           } else if(holeCounter == 3){
               mCurrentHoleView.setText(holes[4]);
               holeCounter++;
           } else if(holeCounter == 4){
               mCurrentHoleView.setText(holes[5]);
               holeCounter++;
           }else if(holeCounter == 5){
               mCurrentHoleView.setText(holes[6]);
               holeCounter++;
           }else if(holeCounter == 6){
               mCurrentHoleView.setText(holes[7]);
               holeCounter++;
           }else if(holeCounter == 7){
               mCurrentHoleView.setText(holes[8]);
               holeCounter++;
           }else if(holeCounter == 8){
               mCurrentHoleView.setText(holes[9]);
               holeCounter++;
           }else if(holeCounter == 9){
               mCurrentHoleView.setText(holes[10]);
               holeCounter++;
           }else if(holeCounter == 10){
               mCurrentHoleView.setText(holes[11]);
               holeCounter++;
           }else if(holeCounter == 11){
               mCurrentHoleView.setText(holes[12]);
               holeCounter++;
           }else if(holeCounter == 12){
               mCurrentHoleView.setText(holes[13]);
               holeCounter++;
           }else if(holeCounter == 13){
               mCurrentHoleView.setText(holes[14]);
               holeCounter++;
           }else if(holeCounter == 14){
               mCurrentHoleView.setText(holes[15]);
               holeCounter++;
           }else if(holeCounter == 15){
               mCurrentHoleView.setText(holes[16]);
               holeCounter++;
           }else if(holeCounter == 16){
               mCurrentHoleView.setText(holes[17]);
               holeCounter++;
           }

        }if (v == mPreviousHoleBtn) {
           if(holeCounter == 0) {

           } else if(holeCounter == 1){
               mCurrentHoleView.setText(holes[0]);
               holeCounter--;
           } else if(holeCounter == 2){
               mCurrentHoleView.setText(holes[1]);
               holeCounter--;
           } else if(holeCounter == 3){
               mCurrentHoleView.setText(holes[2]);
               holeCounter--;
           } else if(holeCounter == 4){
               mCurrentHoleView.setText(holes[3]);
               holeCounter--;
           }else if(holeCounter == 5){
               mCurrentHoleView.setText(holes[4]);
               holeCounter--;
           }else if(holeCounter == 6){
               mCurrentHoleView.setText(holes[5]);
               holeCounter--;
           }else if(holeCounter == 7){
               mCurrentHoleView.setText(holes[6]);
               holeCounter--;
           }else if(holeCounter == 8){
               mCurrentHoleView.setText(holes[7]);
               holeCounter--;
           }else if(holeCounter == 9){
               mCurrentHoleView.setText(holes[8]);
               holeCounter--;
           }else if(holeCounter == 10){
               mCurrentHoleView.setText(holes[9]);
               holeCounter--;
           }else if(holeCounter == 11){
               mCurrentHoleView.setText(holes[10]);
               holeCounter--;
           }else if(holeCounter == 12){
               mCurrentHoleView.setText(holes[11]);
               holeCounter--;
           }else if(holeCounter == 13){
               mCurrentHoleView.setText(holes[12]);
               holeCounter--;
           }else if(holeCounter == 14){
               mCurrentHoleView.setText(holes[13]);
               holeCounter--;
           }else if(holeCounter == 15){
               mCurrentHoleView.setText(holes[14]);
               holeCounter--;
           }else if(holeCounter == 16){
               mCurrentHoleView.setText(holes[15]);
               holeCounter--;
           }else if(holeCounter == 17){
               mCurrentHoleView.setText(holes[16]);
               holeCounter--;
           }

        }
    }
}
