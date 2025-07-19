package org.skypro.examiner_service.controller;

import org.skypro.examiner_service.model.Question;
import org.skypro.examiner_service.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/exam/java")
    public Collection<Question> getAllQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/exam/java/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return javaQuestionService.add(new Question(question, answer));
    }

    @GetMapping("/exam/java/remove")
    public Question deleteQuestion(@RequestParam String question, @RequestParam String answer){
        return javaQuestionService.delete(new Question(question, answer));
    }


}
