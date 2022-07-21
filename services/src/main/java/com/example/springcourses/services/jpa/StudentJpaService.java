package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Student;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@JpaImplementation
public class StudentJpaService extends AbstractJpaService<Student, UUID> implements StudentService {
    @Override
    public JpaRepository<Student, UUID> getRepository() {
        throw new UnsupportedOperationException();
    }
}
