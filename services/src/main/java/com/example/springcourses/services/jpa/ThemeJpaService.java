package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Theme;
import com.example.springcourses.services.ThemeService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class ThemeJpaService extends AbstractJpaService<Theme, Long> implements ThemeService {
    @Override
    public JpaRepository<Theme, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
