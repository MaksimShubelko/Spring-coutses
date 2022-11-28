package com.example.springcourses.repository;

import com.example.springcourses.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Modifying
    @Query("DELETE FROM Theme th WHERE th.themeId = ?1")
    void deleteById(Long id);
}
