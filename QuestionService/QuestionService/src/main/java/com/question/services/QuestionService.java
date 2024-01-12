package com.question.services;

import com.question.entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    Iterable<Question> getAll();

    Question getOneById(Integer id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
