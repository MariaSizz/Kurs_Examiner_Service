package org.skypro.examiner_service.service;

import org.skypro.examiner_service.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        final Collection<Question> questions = questionService.getAll();
        if (amount > questions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Set<Question> result = new HashSet<>();
        while (result.size()<amount){
            final Question randomQuestion = questionService.getRandomQuestion();
            result.add(randomQuestion);
        }
        return result;
    }
}
