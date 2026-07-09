package com.example.quizzapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvQuestion, tvQuestionNo;
    ProgressBar progressBar;

    Button btnOption1, btnOption2, btnOption3, btnOption4;

    ArrayList<Question> questionList;

    int currentQuestion = 0;
    int score = 0;
    boolean answered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvQuestionNo = findViewById(R.id.tvQuestionNo);
        progressBar = findViewById(R.id.progressBar);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);

        // Get selected JSON file
        String fileName = getIntent().getStringExtra("jsonFile");

        if (fileName == null) {
            fileName = "general_knowledge.json";
        }

        questionList = JsonUtils.loadQuestions(this, fileName);

        progressBar.setMax(questionList.size());

        loadQuestion();

        btnOption1.setOnClickListener(v -> checkAnswer(0, btnOption1));
        btnOption2.setOnClickListener(v -> checkAnswer(1, btnOption2));
        btnOption3.setOnClickListener(v -> checkAnswer(2, btnOption3));
        btnOption4.setOnClickListener(v -> checkAnswer(3, btnOption4));
    }
    private void loadQuestion() {

        answered = false;

        Question question = questionList.get(currentQuestion);

        tvQuestionNo.setText("Question " + (currentQuestion + 1) + "/" + questionList.size());

        progressBar.setProgress(currentQuestion + 1);

        tvQuestion.setText(question.getQuestion());

        btnOption1.setText(question.getOptions().get(0));
        btnOption2.setText(question.getOptions().get(1));
        btnOption3.setText(question.getOptions().get(2));
        btnOption4.setText(question.getOptions().get(3));

        resetButtons();
    }

    private void resetButtons() {

        Button[] buttons = {
                btnOption1,
                btnOption2,
                btnOption3,
                btnOption4
        };

        for (Button button : buttons) {

            button.setEnabled(true);

            button.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#6200EE"))
            );
        }
    }

    private void checkAnswer(int selectedIndex, Button clickedButton) {

        if (answered)
            return;

        answered = true;

        Button[] buttons = {
                btnOption1,
                btnOption2,
                btnOption3,
                btnOption4
        };

        for (Button button : buttons) {
            button.setEnabled(false);
        }

        int correctAnswer = questionList.get(currentQuestion).getAnswer();

        // Correct answer turns GREEN
        buttons[correctAnswer].setBackgroundTintList(
                ColorStateList.valueOf(Color.parseColor("#4CAF50"))
        );

        if (selectedIndex == correctAnswer) {

            score++;

        } else {

            // Wrong selected answer turns RED
            clickedButton.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#F44336"))
            );
        }

        new Handler(getMainLooper()).postDelayed(() -> {

            currentQuestion++;

            if (currentQuestion < questionList.size()) {

                loadQuestion();

            } else {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("score", score);
                intent.putExtra("total", questionList.size());

                startActivity(intent);
                finish();
            }

        }, 1500);
    }
}