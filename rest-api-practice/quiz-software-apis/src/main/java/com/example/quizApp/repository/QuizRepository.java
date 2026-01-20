package com.example.quizApp.repository;

import com.example.quizApp.model.QuizQuestion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRepository {

    private final JdbcTemplate jdbcTemplate;

    public QuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<QuizQuestion> findAll() {
        String sql = "SELECT * FROM quiz_question";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(QuizQuestion.class));
    }

    public QuizQuestion findById(int id) {
        String sql = "SELECT * FROM quiz_question WHERE id=?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(QuizQuestion.class),
                id
        );
    }

    public void save(QuizQuestion q) {
        String sql = """
                INSERT INTO quiz_question
                (question, option_a, option_b, option_c, option_d, correct_option)
                VALUES (?,?,?,?,?,?)
                """;

        jdbcTemplate.update(
                sql,
                q.getQuestion(),
                q.getOptionA(),
                q.getOptionB(),
                q.getOptionC(),
                q.getOptionD(),
                q.getCorrectOption()
        );
    }
}
