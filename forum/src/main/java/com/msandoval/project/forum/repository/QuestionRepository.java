package com.msandoval.project.forum.repository;

import com.msandoval.project.forum.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTitleContainingIgnoreCase(String title);
}
