package com.question.repositories;

import com.question.entities.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
    List<Question> findByQuizId(Long quizId);
}
