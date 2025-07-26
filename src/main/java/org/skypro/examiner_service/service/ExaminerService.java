package org.skypro.examiner_service.service;

import org.skypro.examiner_service.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection <Question> getQuestions (int amount);
}
