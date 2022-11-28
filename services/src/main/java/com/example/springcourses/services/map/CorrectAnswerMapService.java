package com.example.springcourses.services.map;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.services.CorrectAnswerService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class CorrectAnswerMapService extends AbstractMapService<CorrectAnswerDto, Long> implements CorrectAnswerService {

    private static final Map<Long, CorrectAnswerDto> resource = new HashMap<>();

    @Override
    public Map<Long, CorrectAnswerDto> getResource() {
        return resource;
    }
}
