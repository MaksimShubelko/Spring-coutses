package com.example.springcourses.services.map;

import com.example.springcourses.entity.Answer;
import com.example.springcourses.services.AnswerService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class AnswerMapService extends AbstractMapService<Answer, Long> implements AnswerService {

    private static final Map<Long, Answer> resource = new HashMap<>();

    @Override
    public Map<Long, Answer> getResource() {
        return resource;
    }
}
