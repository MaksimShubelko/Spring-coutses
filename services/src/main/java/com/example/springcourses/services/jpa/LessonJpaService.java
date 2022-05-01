package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Lesson;
import com.example.springcourses.services.LessonService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class LessonJpaService extends AbstractJpaService<Lesson, Long> implements LessonService {

    @Override
    public JpaRepository<Lesson, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
