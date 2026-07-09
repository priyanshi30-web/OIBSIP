package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    Button btnGK, btnScience, btnGeography, btnComputer, btnSports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btnGK = findViewById(R.id.btnGK);
        btnScience = findViewById(R.id.btnScience);
        btnGeography = findViewById(R.id.btnGeography);
        btnComputer = findViewById(R.id.btnComputer);
        btnSports = findViewById(R.id.btnSports);

        btnGK.setOnClickListener(v -> openQuiz("general_knowledge.json"));
        btnScience.setOnClickListener(v -> openQuiz("science.json"));
        btnGeography.setOnClickListener(v -> openQuiz("geography.json"));
        btnComputer.setOnClickListener(v -> openQuiz("computer.json"));
        btnSports.setOnClickListener(v -> openQuiz("sports.json"));
    }

    private void openQuiz(String fileName) {
        Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
        intent.putExtra("jsonFile", fileName);
        startActivity(intent);
    }
}