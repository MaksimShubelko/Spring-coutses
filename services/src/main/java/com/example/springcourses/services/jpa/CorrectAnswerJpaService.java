package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.services.CorrectAnswerService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class CorrectAnswerJpaService extends AbstractJpaService<CorrectAnswer, Long> implements CorrectAnswerService {
    @Override
    public JpaRepository<CorrectAnswer, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}