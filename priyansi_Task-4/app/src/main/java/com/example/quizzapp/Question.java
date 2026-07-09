package com.example.quizzapp;

import java.util.List;

public class Question {

    private String question;
    private List<String> options;
    private int answer;

    // Empty constructor (required by Gson)
    public Question() {
    }

    public Question(String question, List<String> options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}