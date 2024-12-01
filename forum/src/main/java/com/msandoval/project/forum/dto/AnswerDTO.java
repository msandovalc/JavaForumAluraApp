package com.msandoval.project.forum.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record AnswerDTO(
        Long id,
        @NotBlank
        String content,
        @NotNull(message = "El ID de la pregunta no puede ser nulo.")
        Long questionId,

        LocalDateTime createdAt
) {}