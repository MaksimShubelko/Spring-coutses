package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Test;
import com.example.springcourses.services.TestService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class TestJpaService extends AbstractJpaService<Test, Long> implements TestService {
    @Override
    public JpaRepository<Test, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}