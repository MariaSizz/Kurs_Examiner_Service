package org.skypro.examiner_service.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.examiner_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExaminerServiceImplTest {
    @Autowired
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetQuestions(){
        when(questionService.getAll()).thenReturn(List.of(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3")
        ));
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3")
        );

        final Collection<Question> questions = examinerService.getQuestions(2);

        assertEquals(2,questions.size());
    }
}
