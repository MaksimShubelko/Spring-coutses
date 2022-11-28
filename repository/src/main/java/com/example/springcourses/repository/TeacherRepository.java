package com.example.springcourses.repository;

import com.example.springcourses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Override
    Optional<Teacher> findById(Long aLong);

    @Query("SELECT t FROM Teacher t WHERE t.userEntity.userId = ?1")
    Teacher findByUserId(Long userId);
}
