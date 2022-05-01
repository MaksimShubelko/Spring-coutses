package com.example.springcourses.services.map;

import com.example.springcourses.entity.Question;
import com.example.springcourses.services.QuestionService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class QuestionMapService extends AbstractMapService<Question, Long> implements QuestionService {
    private static final Map<Long, Question> resource = new HashMap<>();

    @Override
    public Map<Long, Question> getResource() {
        return resource;
    }
}
