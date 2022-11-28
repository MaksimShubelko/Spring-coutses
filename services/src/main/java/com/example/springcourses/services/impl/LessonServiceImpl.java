package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.LessonDto;
import com.example.springcourses.entity.Group;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.LessonMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.LessonRepository;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository repository;
    private final LessonMapper mapper;

    @Override
    public LessonDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(LessonDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<LessonDto> findAll() {
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
