package com.example.springcourses.repository;

import com.example.springcourses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    @Query("DELETE FROM Course c WHERE c.courseId = ?1")
    void deleteById(Long courseId);
}
