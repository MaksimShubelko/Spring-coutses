package com.example.springcourses.services.map;

import com.example.springcourses.dto.QuestionDto;
import com.example.springcourses.entity.Question;
import com.example.springcourses.services.QuestionService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class QuestionMapService extends AbstractMapService<QuestionDto, Long> implements QuestionService {
    private static final Map<Long, QuestionDto> resource = new HashMap<>();

    @Override
    public Map<Long, QuestionDto> getResource() {
        return resource;
    }
}
