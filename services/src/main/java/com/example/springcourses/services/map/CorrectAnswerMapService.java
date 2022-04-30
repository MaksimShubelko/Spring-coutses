package com.example.springcourses.services.map;

import com.example.springcourses.entity.CorrectAnswer;

import java.util.HashMap;
import java.util.Map;

public class CorrectAnswerMapService extends AbstractMapService<CorrectAnswer, Long> {

    private static final Map<Long, CorrectAnswer> resource = new HashMap<>();

    @Override
    public Map<Long, CorrectAnswer> getResource() {
        return resource;
    }
}
