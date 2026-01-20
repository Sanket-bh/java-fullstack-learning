package com.example.quizApp.controller;

import com.example.quizApp.dto.*;
import com.example.quizApp.model.QuizQuestion;
import com.example.quizApp.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // GET /questions
    @GetMapping("/questions")
    public ResponseEntity<List<QuizQuestionResponseDTO>> getQuestions() {
        return ResponseEntity.ok(quizService.getQuestions());
    }

    // POST /submit
    @PostMapping("/submit")
    public ResponseEntity<QuizSubmitResponseDTO> submitQuiz(
            @RequestBody QuizSubmitRequestDTO request) {

        return ResponseEntity.ok(quizService.submitQuiz(request));
    }

    @PostMapping("/question")
    public ResponseEntity<String> addQuestion(
            @RequestBody QuizQuestionRequestDTO dto) {

        quizService.addQuestion(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Question added successfully");
    }
}
