package org.skypro.examiner_service.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.examiner_service.model.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @BeforeEach
    void setUp(){
        service = new JavaQuestionService();
    }
    @Test
    void testAddQuestion(){
        Question question = new Question("Сколько", "Много");
        service.add(question);

        final Collection<Question> questions = service.getAll();

        assertTrue(questions.contains(question));
        assertEquals(6, questions.size());
    }

    @Test
    void testRemoveQuestion(){
        Question question = new Question("Сколько", "Мало");
        service.add(question);

        Collection<Question> questions = service.getAll();

        assertEquals(6, questions.size());

        service.delete(question);

        questions = service.getAll();

        assertEquals(5, questions.size());
        assertFalse(questions.contains(question));
    }
    @Test
    void testGetAllQuestions(){
        Question question1 = new Question("Сколько", "Мало");
        Question question2 = new Question("Сколько", "Нормально");
        service.add(question1);
        service.add(question2);

        Collection<Question> questions = service.getAll();

        assertEquals(7, questions.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }
    @Test
    void testGetRandomQuestion(){
        final Question randomQuestion = service.getRandomQuestion();

        assertNotNull(randomQuestion);

        Collection<Question> questions = service.getAll();

        assertTrue(questions.contains(randomQuestion));
    }
}
