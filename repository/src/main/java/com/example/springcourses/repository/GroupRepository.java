package com.example.springcourses.repository;

import com.example.springcourses.entity.Course;
import com.example.springcourses.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g FROM Group g WHERE g.course = ?1")
    List<Group> findAllByCourse(Course course);

    @Query("SELECT g FROM Group g WHERE g.course.courseId = ?1")
    List<Group> findAllByCourseId(Long courseId);

    @Modifying
    @Query("DELETE FROM Group g WHERE g.course.courseId = ?1")
    void deleteByCourse(Long courseId);
}
