package com.example.josh.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josh.myapplication.R;
import com.example.josh.myapplication.models.Game;
import com.example.josh.myapplication.ui.MainActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameViewHolder extends RecyclerView.ViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    @Bind(R.id.discImageView) ImageView mDiscImageView;
    @Bind(R.id.roundNameTextView) TextView mRoundNameTextView;
    @Bind(R.id.courseNameTextView) TextView mCourseNameTextView;
    @Bind(R.id.ratingTextView) TextView mRatingTextView;
    @Bind(R.id.holeScoresTextView) TextView mHoleScoresTextView;
    @Bind(R.id.totalScoreTextView) TextView mTotalScoreTextView;

    private Context mContext;
    private ArrayList<Game> mGames = new ArrayList<>();

    public GameViewHolder(View itemView, ArrayList<Game> games) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mGames = games;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("games", Parcels.wrap(mGames));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindGame(Game game) {
        mRoundNameTextView.setText(game.getGameName());
        mCourseNameTextView.setText(game.getCourseName());
        mRatingTextView.setText("Rating: "+game.getGameRating()+ "/10");
        mHoleScoresTextView.setText(formatHoleScores(game));
        mTotalScoreTextView.setText("Total: " + game.getTotalScore());
    }

    public String formatHoleScores(Game game) {
       return game.getHoleScores().get(0) + ", "
                + game.getHoleScores().get(1) + ", "
                + game.getHoleScores().get(2) + ", "
                + game.getHoleScores().get(3) + ", "
                + game.getHoleScores().get(4) + ", "
                + game.getHoleScores().get(5) + ", "
                + game.getHoleScores().get(6) + ", "
                + game.getHoleScores().get(7) + ", "
                + game.getHoleScores().get(8) + ", "
                + game.getHoleScores().get(9) + ", "
                + game.getHoleScores().get(10) + ", "
                + game.getHoleScores().get(11) + ", "
                + game.getHoleScores().get(12) + ", "
                + game.getHoleScores().get(13) + ", "
                + game.getHoleScores().get(14) + ", "
                + game.getHoleScores().get(15) + ", "
                + game.getHoleScores().get(16) + ", "
                + game.getHoleScores().get(17);
    }
}
