package com.msandoval.project.forum.service;

import com.msandoval.project.forum.model.Question;
import com.msandoval.project.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    public Question getQuestionById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found"));
    }

    public Question createQuestion(Question question) {
        return repository.save(question);
    }

    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}