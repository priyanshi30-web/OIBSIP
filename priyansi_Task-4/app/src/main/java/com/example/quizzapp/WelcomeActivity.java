package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button btnStartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnStartQuiz = findViewById(R.id.btnStartQuiz);

        btnStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, CategoryActivity.class);
            startActivity(intent);
        });
    }
}