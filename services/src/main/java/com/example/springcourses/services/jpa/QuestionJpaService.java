package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.QuestionDto;
import com.example.springcourses.entity.Question;
import com.example.springcourses.services.QuestionService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

/*@JpaImplementation
public class QuestionJpaService extends AbstractJpaService<QuestionDto, Question, Long> implements QuestionService {
    @Override
    public JpaRepository<Question, Long> getRepository() {
        throw new UnsupportedOperationException();
    }

    @Override
    public QuestionDto mapToDto(Question entity) {
        return null;
    }

    @Override
    public Question mapToEntity(QuestionDto dto) {
        return null;
    }
}*/
