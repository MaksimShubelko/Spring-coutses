package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.StudentMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/*@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public StudentDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(StudentDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<StudentDto> findAll() {
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
}*/
