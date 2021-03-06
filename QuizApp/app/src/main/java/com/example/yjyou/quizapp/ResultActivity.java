package com.example.yjyou.quizapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel=(TextView)findViewById(R.id.resultLabel);
        TextView totalSoreLabel=(TextView)findViewById(R.id.totalSoreLabel);

        int score=getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalSore=settings.getInt("totalScore",0);
        totalSore += score;

        resultLabel.setText(score+" /5");
        totalSoreLabel.setText("Total Score : "+ totalSore);

        //Update total score
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("totalScore",totalSore);
        editor.commit();

    }
}
