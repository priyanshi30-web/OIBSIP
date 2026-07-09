package com.example.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tvScore, tvPercentage, tvMessage, tvHighScore;
    Button btnPlayAgain, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvScore = findViewById(R.id.tvScore);
        tvPercentage = findViewById(R.id.tvPercentage);
        tvMessage = findViewById(R.id.tvMessage);
        tvHighScore = findViewById(R.id.tvHighScore);

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnHome = findViewById(R.id.btnHome);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        tvScore.setText("Score: " + score + " / " + total);

        int percentage = (score * 100) / total;
        tvPercentage.setText("Percentage: " + percentage + "%");

        if (percentage >= 80) {
            tvMessage.setText("🏆 Excellent!");
        } else if (percentage >= 60) {
            tvMessage.setText("😊 Good Job!");
        } else if (percentage >= 40) {
            tvMessage.setText("🙂 Keep Practicing!");
        } else {
            tvMessage.setText("😔 Better Luck Next Time!");
        }

        // Save High Score
        SharedPreferences preferences = getSharedPreferences("QuizApp", MODE_PRIVATE);
        int highScore = preferences.getInt("highScore", 0);

        if (score > highScore) {
            preferences.edit().putInt("highScore", score).apply();
            highScore = score;
        }

        tvHighScore.setText("High Score: " + highScore);

        btnPlayAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, CategoryActivity.class);
            startActivity(intent);
            finish();
        });

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}