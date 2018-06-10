package com.example.android.programmingconceptsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    int score = 0;
    RadioButton q1a;
    CheckBox q2o1;
    CheckBox q2o2;
    CheckBox q2o3;
    CheckBox q2o4;
    EditText q3a1;
    RadioButton q4a;
    String stringScore = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        q1a = findViewById(R.id.q1o3);
        q2o1 = findViewById(R.id.q2o1);
        q2o2 = findViewById(R.id.q2o2);
        q2o3 = findViewById(R.id.q2o3);
        q2o4 = findViewById(R.id.q2o4);
        q3a1 = findViewById(R.id.q3o1);
        q4a = findViewById(R.id.q4o4);
    }

    public void calculateScore(){
        if (q1a.isChecked()){
            score += 1;
        }
        if (!q2o1.isChecked() && q2o2.isChecked() && q2o3.isChecked() && q2o4.isChecked()){
            score += 1;
        }
        String q3a = q3a1.getText().toString().trim();
        if (q3a.equalsIgnoreCase("and") || q3a.equalsIgnoreCase("not") || q3a.equalsIgnoreCase("or")){
            score += 1;
        }
        if (q4a.isChecked()){
            score += 1;
        }
        stringScore = String.valueOf(score);
    }

    public void scoreOnly(View v) {
        score = 0;
        calculateScore();
        String scoreMessage = String.format(getResources().getString(R.string.score_message), stringScore);
        if (score <=2){
            scoreMessage = scoreMessage + " " + getResources().getString(R.string.low_score);
        } else {
            scoreMessage = scoreMessage + " " + getResources().getString(R.string.high_score);
        }
        Toast.makeText(this, scoreMessage, Toast.LENGTH_SHORT).show();
    }

    public void scoreExplanation(View v){
        score = 0;
        calculateScore();
        Intent intent = new Intent(QuizActivity.this, ScoreExplanationActivity.class);
        intent.putExtra("score", stringScore);
        startActivity(intent);
    }
}
