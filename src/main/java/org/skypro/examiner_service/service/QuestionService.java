package org.skypro.examiner_service.service;

import org.skypro.examiner_service.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question getRandomQuestion();
    Collection <Question> getAll();

    Question add(Question question);

    Question delete(Question question);
}
