package com.msandoval.project.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

public record QuestionDTO(
        @NotBlank
        Long id,
        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotBlank
        LocalDateTime createdAt,
        @NotBlank
        List<AnswerDTO> answers
) {}