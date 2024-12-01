package com.msandoval.project.forum.controller;

import com.msandoval.project.forum.dto.AnswerDTO;
import com.msandoval.project.forum.service.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService service;

    @GetMapping("/all")
    public List<AnswerDTO> getAllAnswers() {
        return service.getAllAnswers();
    }

    @GetMapping("/question/{questionId}")
    public List<AnswerDTO> getAnswersByQuestion(@PathVariable Long questionId) {
        return service.getAnswersByQuestionId(questionId);
    }

    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@Valid @RequestBody AnswerDTO answerDTO) {
        AnswerDTO created = service.createAnswer(answerDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        service.deleteAnswer(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("DELETED");
    }
}

