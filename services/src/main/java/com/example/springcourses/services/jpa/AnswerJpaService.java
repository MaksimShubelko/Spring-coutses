package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.AnswerDto;
import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.entity.Answer;
import com.example.springcourses.services.AnswerService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

/*
@JpaImplementation
public class AnswerJpaService extends AbstractJpaService<AnswerDto, Answer, Long> implements AnswerService {
    @Override
    public JpaRepository<Answer, Long> getRepository() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AnswerDto mapToDto(Answer entity) {
        return null;
    }

    @Override
    public Answer mapToEntity(AnswerDto dto) {
        return null;
    }
}
*/
