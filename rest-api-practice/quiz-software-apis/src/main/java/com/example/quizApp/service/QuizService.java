package com.example.quizApp.service;

import com.example.quizApp.dto.QuizQuestionRequestDTO;
import com.example.quizApp.dto.QuizQuestionResponseDTO;
import com.example.quizApp.dto.QuizSubmitRequestDTO;
import com.example.quizApp.dto.QuizSubmitResponseDTO;
import com.example.quizApp.exception.ResourceNotFoundException;
import com.example.quizApp.model.QuizQuestion;
import com.example.quizApp.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }


    public List<QuizQuestionResponseDTO> getQuestions() {

        List<QuizQuestion> questionList = quizRepository.findAll();
        List<QuizQuestionResponseDTO> responseList = new ArrayList<>();

        for (QuizQuestion q : questionList) {

            QuizQuestionResponseDTO dto = new QuizQuestionResponseDTO();
            dto.setId(q.getId());
            dto.setQuestion(q.getQuestion());

            List<String> options = new ArrayList<>();
            options.add(q.getOptionA());
            options.add(q.getOptionB());
            options.add(q.getOptionC());
            options.add(q.getOptionD());

            dto.setOptions(options);

            responseList.add(dto);
        }

        return responseList;
    }


    public QuizSubmitResponseDTO submitQuiz(QuizSubmitRequestDTO request) {

        int score = 0;
        int total = request.getAnswers().size();

        for (Map.Entry<Integer, String> entry : request.getAnswers().entrySet()) {

            int questionId = entry.getKey();
            String selectedOption = entry.getValue();

            QuizQuestion question = quizRepository.findById(questionId);

            if (question == null) {
                throw new ResourceNotFoundException(
                        "Invalid question ID: " + questionId
                );
            }

            String correct = String.valueOf(question.getCorrectOption());

            if (correct.equalsIgnoreCase(selectedOption)) {
                score++;
            }
        }

        return new QuizSubmitResponseDTO(score, total);
    }

    public void addQuestion(QuizQuestionRequestDTO dto) {

        QuizQuestion question = new QuizQuestion();
        question.setQuestion(dto.getQuestion());
        question.setOptionA(dto.getOptionA());
        question.setOptionB(dto.getOptionB());
        question.setOptionC(dto.getOptionC());
        question.setOptionD(dto.getOptionD());
        question.setCorrectOption(dto.getCorrectOption());

        quizRepository.save(question);
    }
}
