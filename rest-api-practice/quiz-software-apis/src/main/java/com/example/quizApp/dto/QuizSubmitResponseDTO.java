package com.example.quizApp.dto;


public class QuizSubmitResponseDTO {

    private int score;
    private int total;

    public QuizSubmitResponseDTO(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }

}
