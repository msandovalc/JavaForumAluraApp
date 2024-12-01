package com.msandoval.project.forum.controller;

import com.msandoval.project.forum.model.Question;
import com.msandoval.project.forum.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping
    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return service.getQuestionById(id);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question created = service.createQuestion(question);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        service.deleteQuestion(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("DELETED");
    }
}
