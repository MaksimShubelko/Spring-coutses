package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Request;
import com.example.springcourses.services.RequestService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class RequestJpaService extends AbstractJpaService<Request, Long> implements RequestService {
    @Override
    public JpaRepository<Request, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
