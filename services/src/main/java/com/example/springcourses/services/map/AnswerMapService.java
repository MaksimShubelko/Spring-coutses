package com.example.springcourses.services.map;

import com.example.springcourses.entity.Answer;

import java.util.HashMap;
import java.util.Map;

public class AnswerMapService extends AbstractMapService<Answer, Long> {

    private static final Map<Long, Answer> resource = new HashMap<>();

    @Override
    public Map<Long, Answer> getResource() {
        return resource;
    }
}
