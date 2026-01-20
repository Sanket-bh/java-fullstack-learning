package com.example.quizApp.dto;


import java.util.Map;

public class QuizSubmitRequestDTO {
    private Map<Integer, String> answers;

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }
}
