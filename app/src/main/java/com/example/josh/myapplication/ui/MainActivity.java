package com.example.josh.myapplication.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    int scoreHolder;

    private SharedPreferences mSharedPreferences;


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

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);
        holeScores.add(3);

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
            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            Firebase userGamesFirebaseRef = new Firebase(Constants.FIREBASE_URL_GAMES).child(userUid);
            Firebase pushRef = userGamesFirebaseRef.push();
            String gamePushId = pushRef.getKey();
            mGame.setPushId(gamePushId);
            pushRef.setValue(mGame);
            Toast.makeText(MainActivity.this, "Game Saved", Toast.LENGTH_SHORT).show();
        }

        if (v == mPlusOnePointBtn) {
            if(holeScoreCounter < 10 && holeScoreCounter > -1) {
                holeScoreCounter = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
                holeScoreCounter++;
                mCurrentHoleScoreView.setText(Integer.toString(holeScoreCounter));
            }
        }

        if (v == mMinusOnePointBtn) {
            if(holeScoreCounter < 11 && holeScoreCounter > 0) {
                holeScoreCounter = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
                holeScoreCounter--;
                mCurrentHoleScoreView.setText(Integer.toString(holeScoreCounter));
            }
        }

        if (v == mNextHoleBtn) {
           if(holeCounter == 0) {
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(0, scoreHolder);
               mCurrentHoleView.setText(holes[1]);
               mCurrentHoleScoreView.setText(holeScores.get(1).toString());
               holeCounter++;
           } else if(holeCounter == 1){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(1, scoreHolder);
               mCurrentHoleView.setText(holes[2]);
               mCurrentHoleScoreView.setText(holeScores.get(2).toString());
               holeCounter++;
           } else if(holeCounter == 2){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(2, scoreHolder);
               mCurrentHoleView.setText(holes[3]);
               mCurrentHoleScoreView.setText(holeScores.get(3).toString());
               holeCounter++;
           } else if(holeCounter == 3){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(3, scoreHolder);
               mCurrentHoleView.setText(holes[4]);
               mCurrentHoleScoreView.setText(holeScores.get(4).toString());
               holeCounter++;
           } else if(holeCounter == 4){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(4, scoreHolder);
               mCurrentHoleView.setText(holes[5]);
               mCurrentHoleScoreView.setText(holeScores.get(5).toString());
               holeCounter++;
           }else if(holeCounter == 5){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(5, scoreHolder);
               mCurrentHoleView.setText(holes[6]);
               mCurrentHoleScoreView.setText(holeScores.get(6).toString());
               holeCounter++;
           }else if(holeCounter == 6){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(6, scoreHolder);
               mCurrentHoleView.setText(holes[7]);
               mCurrentHoleScoreView.setText(holeScores.get(7).toString());
               holeCounter++;
           }else if(holeCounter == 7){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(7, scoreHolder);
               mCurrentHoleView.setText(holes[8]);
               mCurrentHoleScoreView.setText(holeScores.get(8).toString());
               holeCounter++;
           }else if(holeCounter == 8){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(8, scoreHolder);
               mCurrentHoleView.setText(holes[9]);
               mCurrentHoleScoreView.setText(holeScores.get(9).toString());
               holeCounter++;
           }else if(holeCounter == 9){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(9, scoreHolder);
               mCurrentHoleView.setText(holes[10]);
               mCurrentHoleScoreView.setText(holeScores.get(10).toString());
               holeCounter++;
           }else if(holeCounter == 10){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(10, scoreHolder);
               mCurrentHoleView.setText(holes[11]);
               mCurrentHoleScoreView.setText(holeScores.get(11).toString());
               holeCounter++;
           }else if(holeCounter == 11){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(11, scoreHolder);
               mCurrentHoleView.setText(holes[12]);
               mCurrentHoleScoreView.setText(holeScores.get(12).toString());
               holeCounter++;
           }else if(holeCounter == 12){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(12, scoreHolder);
               mCurrentHoleView.setText(holes[13]);
               mCurrentHoleScoreView.setText(holeScores.get(13).toString());
               holeCounter++;
           }else if(holeCounter == 13){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(13, scoreHolder);
               mCurrentHoleView.setText(holes[14]);
               mCurrentHoleScoreView.setText(holeScores.get(14).toString());
               holeCounter++;
           }else if(holeCounter == 14){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(14, scoreHolder);
               mCurrentHoleView.setText(holes[15]);
               mCurrentHoleScoreView.setText(holeScores.get(15).toString());
               holeCounter++;
           }else if(holeCounter == 15){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(15, scoreHolder);
               mCurrentHoleView.setText(holes[16]);
               mCurrentHoleScoreView.setText(holeScores.get(16).toString());
               holeCounter++;
           }else if(holeCounter == 16){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(16, scoreHolder);
               mCurrentHoleView.setText(holes[17]);
               mCurrentHoleScoreView.setText(holeScores.get(17).toString());
               holeCounter++;
           }

        }if (v == mPreviousHoleBtn) {
           if(holeCounter == 0) {

           } else if(holeCounter == 1){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(1, scoreHolder);
               mCurrentHoleView.setText(holes[0]);
               mCurrentHoleScoreView.setText(holeScores.get(0).toString());
               holeCounter--;
           } else if(holeCounter == 2){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(2, scoreHolder);
               mCurrentHoleView.setText(holes[1]);
               mCurrentHoleScoreView.setText(holeScores.get(1).toString());
               holeCounter--;
           } else if(holeCounter == 3){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(3, scoreHolder);
               mCurrentHoleView.setText(holes[2]);
               mCurrentHoleScoreView.setText(holeScores.get(2).toString());
               holeCounter--;
           } else if(holeCounter == 4){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(4, scoreHolder);
               mCurrentHoleView.setText(holes[3]);
               mCurrentHoleScoreView.setText(holeScores.get(3).toString());
               holeCounter--;
           }else if(holeCounter == 5){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(5, scoreHolder);
               mCurrentHoleView.setText(holes[4]);
               mCurrentHoleScoreView.setText(holeScores.get(4).toString());
               holeCounter--;
           }else if(holeCounter == 6){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(6, scoreHolder);
               mCurrentHoleView.setText(holes[5]);
               mCurrentHoleScoreView.setText(holeScores.get(5).toString());
               holeCounter--;
           }else if(holeCounter == 7){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(7, scoreHolder);
               mCurrentHoleView.setText(holes[6]);
               mCurrentHoleScoreView.setText(holeScores.get(6).toString());
               holeCounter--;
           }else if(holeCounter == 8){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(8, scoreHolder);
               mCurrentHoleView.setText(holes[7]);
               mCurrentHoleScoreView.setText(holeScores.get(7).toString());
               holeCounter--;
           }else if(holeCounter == 9){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(9, scoreHolder);
               mCurrentHoleView.setText(holes[8]);
               mCurrentHoleScoreView.setText(holeScores.get(8).toString());
               holeCounter--;
           }else if(holeCounter == 10){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(10, scoreHolder);
               mCurrentHoleView.setText(holes[9]);
               mCurrentHoleScoreView.setText(holeScores.get(9).toString());
               holeCounter--;
           }else if(holeCounter == 11){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(11, scoreHolder);
               mCurrentHoleView.setText(holes[10]);
               mCurrentHoleScoreView.setText(holeScores.get(10).toString());
               holeCounter--;
           }else if(holeCounter == 12){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(12, scoreHolder);
               mCurrentHoleView.setText(holes[11]);
               mCurrentHoleScoreView.setText(holeScores.get(11).toString());
               holeCounter--;
           }else if(holeCounter == 13){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(13, scoreHolder);
               mCurrentHoleView.setText(holes[12]);
               mCurrentHoleScoreView.setText(holeScores.get(12).toString());
               holeCounter--;
           }else if(holeCounter == 14){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(14, scoreHolder);
               mCurrentHoleView.setText(holes[13]);
               mCurrentHoleScoreView.setText(holeScores.get(13).toString());
               holeCounter--;
           }else if(holeCounter == 15){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(15, scoreHolder);
               mCurrentHoleView.setText(holes[14]);
               mCurrentHoleScoreView.setText(holeScores.get(14).toString());
               holeCounter--;
           }else if(holeCounter == 16){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(16, scoreHolder);
               mCurrentHoleView.setText(holes[15]);
               mCurrentHoleScoreView.setText(holeScores.get(15).toString());
               holeCounter--;
           }else if(holeCounter == 17){
               scoreHolder = Integer.parseInt(mCurrentHoleScoreView.getText().toString());
               holeScores.set(17, scoreHolder);
               mCurrentHoleView.setText(holes[16]);
               mCurrentHoleScoreView.setText(holeScores.get(16).toString());
               holeCounter--;
           }

        }
    }
}
