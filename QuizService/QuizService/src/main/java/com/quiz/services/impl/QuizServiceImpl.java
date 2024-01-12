package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private QuestionClient questionClient;


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz> quizList= quizzes.stream()
                .peek(quiz -> quiz.setQuestionList(questionClient
                        .getQuestionsOfQuiz(quiz.getId())))
                .collect(Collectors.toList());

        return quizList;
    }

    @Override
    public Quiz get(Integer id) {
        Quiz quiz= quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestionList(questionClient.getQuestionsOfQuiz(quiz.getId()));

        return quiz;
    }

}
