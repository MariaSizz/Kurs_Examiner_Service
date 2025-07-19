package org.skypro.examiner_service.service;

import org.skypro.examiner_service.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private List<Question> questions = new ArrayList<>();
    private Random random = new Random();

    public JavaQuestionService() {
        questions.add(new Question("Сколько", "Много"));
        questions.add(new Question("Сколько денег", "Много денег"));
        questions.add(new Question("Сколько ждать", "Скоро"));
        questions.add(new Question("Сколько птиц", "Пять"));
        questions.add(new Question("Сколько стоит", "Со скидкой"));
    }

    @Override
    public Question getRandomQuestion() {
        final int i = random.nextInt(questions.size());
        return questions.get(i);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question delete(Question question) {
        questions.remove(question);
        return question;
    }


}
