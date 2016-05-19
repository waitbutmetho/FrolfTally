package com.example.josh.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.josh.myapplication.Constants;
import com.example.josh.myapplication.R;
import com.example.josh.myapplication.adapters.FirebaseGameListAdapter;
import com.example.josh.myapplication.models.Game;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedGameListActivity extends AppCompatActivity {

    private Query mQuery;
    private Firebase mFirebaseGamesRef;
    private FirebaseGameListAdapter mAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ButterKnife.bind(this);

        mFirebaseGamesRef = new Firebase(Constants.FIREBASE_URL_GAMES);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        Firebase mainRef = new Firebase(Constants.FIREBASE_URL);
        String UID = mainRef.getAuth().getUid();
        String location = mFirebaseGamesRef.child(UID).toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseGameListAdapter(mQuery, Game.class);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
