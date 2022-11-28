//package com.example.springcourses.services.impl;
//
//import com.example.springcourses.dto.CorrectAnswerDto;
//import com.example.springcourses.dto.TeacherDto;
//import com.example.springcourses.entity.Teacher;
//import com.example.springcourses.mapper.CorrectAnswerMapper;
//import com.example.springcourses.mapper.TeacherMapper;
//import com.example.springcourses.repository.CorrectAnswerRepository;
//import com.example.springcourses.repository.TeacherRepository;
//import com.example.springcourses.repository.TestRepository;
//import com.example.springcourses.services.TeacherService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Service
//public class TeacherServiceImpl implements TeacherService {
//
//    private final TeacherRepository repository;
//    private final TeacherMapper mapper;
//
//    @Override
//    public TeacherDto findById(Long aLong) {
//
//        return repository
//                .findById(aLong)
//                .map(mapper::mapToDto)
//                .orElseThrow();
//    }
//
//    @Override
//    public void save(TeacherDto dto) {
//        repository.save(mapper.map(dto));
//    }
//
//    @Override
//    public Collection<TeacherDto> findAll() {
//        return repository
//                .findAll()
//                .stream()
//                .map(mapper::mapToDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete(Long aLong) {
//        repository.deleteById(aLong);
//    }
//}
