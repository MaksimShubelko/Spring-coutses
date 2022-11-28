package com.example.springcourses.services.impl;

import com.example.springcourses.dto.AcademicPerformanceDto;
import com.example.springcourses.dto.AnswerDto;
import com.example.springcourses.entity.Answer;
import com.example.springcourses.mapper.AcademicPerformanceMapper;
import com.example.springcourses.mapper.AnswerMapper;
import com.example.springcourses.repository.AcademicPerformanceRepository;
import com.example.springcourses.repository.AnswerRepository;
import com.example.springcourses.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;
    private final AnswerMapper mapper;

    @Override
    public AnswerDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(AnswerDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<AnswerDto> findAll() {
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
