package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Course;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class CourseJpaService extends AbstractJpaService<Course, Long> implements CourseService {

    @Override
    public JpaRepository<Course, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
