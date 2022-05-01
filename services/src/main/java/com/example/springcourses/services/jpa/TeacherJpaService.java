package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Teacher;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class TeacherJpaService extends AbstractJpaService<Teacher, Long> implements TeacherService {
    @Override
    public JpaRepository<Teacher, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
