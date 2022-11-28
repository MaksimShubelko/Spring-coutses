package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.QuestionDto;
import com.example.springcourses.entity.Question;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.QuestionMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.QuestionRepository;
import com.example.springcourses.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final QuestionMapper mapper;

    @Override
    public QuestionDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(QuestionDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<QuestionDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
