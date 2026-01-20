package com.example.quizApp.dto;


import java.util.List;

public class QuizQuestionResponseDTO {

    private int id;
    private String question;
    private List<String> options;

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}

