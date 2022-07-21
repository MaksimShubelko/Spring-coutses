package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.User;
import com.example.springcourses.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class UserJpaService extends AbstractJpaService<User, UUID> implements UserService {
    @Override
    public JpaRepository<User, UUID> getRepository() {
        throw new UnsupportedOperationException();

    }
}
