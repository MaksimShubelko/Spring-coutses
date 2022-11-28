package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.entity.Course;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.CourseMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.CourseRepository;
import com.example.springcourses.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {


    @Override
    public CourseDto findById(Long aLong) {
        return null;
    }

    @Override
    public void save(CourseDto entity) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
