package com.example.springcourses.repository;

import com.example.springcourses.entity.Course;
import com.example.springcourses.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Modifying
    @Query("DELETE FROM Theme th WHERE th.themeId = ?1")
    void deleteById(Long id);

    @Modifying
    @Query("DELETE FROM Theme th WHERE th.course.courseId = ?1")
    void deleteByCourseId(Long id);

    List<Theme> findByCourse(Course course);
}
