package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.TestDto;
import com.example.springcourses.entity.Teacher;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.TestMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.TestRepository;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final TestMapper mapper;

    @Override
    public TestDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(TestDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<TestDto> findAll() {
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
