package com.example.springcourses.services.map;

import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.services.CorrectAnswerService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class CorrectAnswerMapService extends AbstractMapService<CorrectAnswer, Long> implements CorrectAnswerService {

    private static final Map<Long, CorrectAnswer> resource = new HashMap<>();

    @Override
    public Map<Long, CorrectAnswer> getResource() {
        return resource;
    }
}
