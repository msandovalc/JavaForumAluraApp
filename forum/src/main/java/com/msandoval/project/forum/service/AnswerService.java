package com.msandoval.project.forum.service;

import com.msandoval.project.forum.dto.AnswerDTO;
import com.msandoval.project.forum.model.Answer;
import com.msandoval.project.forum.model.Question;
import com.msandoval.project.forum.repository.AnswerRepository;
import com.msandoval.project.forum.repository.QuestionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<AnswerDTO> getAllAnswers() {
        return repository.findAll()  // Obtenemos todas las respuestas desde el repositorio
                .stream()  // Convertimos el resultado a un stream
                .map(answer -> new AnswerDTO(  // Transformamos cada entidad 'Answer' a un DTO
                        answer.getId(),  // ID de la respuesta
                        answer.getContent(),  // Contenido de la respuesta
                        answer.getQuestion().getId(),  // ID de la pregunta asociada
                        answer.getCreatedAt()  // Fecha de creación
                ))
                .collect(Collectors.toList());  // Convertimos el stream de vuelta a una lista
    }

    public List<AnswerDTO> getAnswersByQuestionId(Long questionId) {
        return repository.findByQuestionId(questionId)
                .stream()
                .map(answer -> new AnswerDTO(
                        answer.getId(),
                        answer.getContent(),
                        answer.getQuestion().getId(),
                        answer.getCreatedAt()
                ))
                .toList();
    }

    public AnswerDTO createAnswer(@Valid AnswerDTO answerDTO) {
        Question question = questionRepository.findById(answerDTO.questionId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found"));

        Answer answer = new Answer();
        answer.setContent(answerDTO.content());
        answer.setQuestion(question);
        repository.save(answer);

        return new AnswerDTO(
                answer.getId(),
                answer.getContent(),
                answer.getQuestion().getId(),
                answer.getCreatedAt()
        );
    }

    public void deleteAnswer(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found");
        }
        repository.deleteById(id);
    }
}
