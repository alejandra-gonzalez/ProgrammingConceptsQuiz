package com.example.android.programmingconceptsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreExplanationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_explanation);

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        String scoreMessage = String.format(getResources().getString(R.string.score_message), score);
        TextView scoreDisplay = findViewById(R.id.score_display);
        scoreDisplay.setText(scoreMessage);
    }
}
