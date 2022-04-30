package com.example.springcourses.services.map;

import com.example.springcourses.entity.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionMapService extends AbstractMapService<Question, Long> {
    private static final Map<Long, Question> resource = new HashMap<>();

    @Override
    public Map<Long, Question> getResource() {
        return resource;
    }
}
