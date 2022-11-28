package com.example.springcourses.services.impl;

import com.example.springcourses.dto.AnswerDto;
import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.mapper.AnswerMapper;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.repository.AnswerRepository;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.services.CorrectAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CorrectAnswerServiceImpl implements CorrectAnswerService {

    private final CorrectAnswerRepository repository;
    private final CorrectAnswerMapper mapper;

    @Override
    public CorrectAnswerDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(CorrectAnswerDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<CorrectAnswerDto> findAll() {
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
