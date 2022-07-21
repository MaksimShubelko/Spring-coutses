package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Teacher;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@JpaImplementation
public class TeacherJpaService extends AbstractJpaService<Teacher, UUID> implements TeacherService {
    @Override
    public JpaRepository<Teacher, UUID> getRepository() {
        throw new UnsupportedOperationException();
    }
}
