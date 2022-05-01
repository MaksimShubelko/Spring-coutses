package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Student;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class StudentJpaService extends AbstractJpaService<Student, Long> implements StudentService {
    @Override
    public JpaRepository<Student, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
