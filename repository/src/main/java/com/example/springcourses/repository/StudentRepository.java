package com.example.springcourses.repository;

import com.example.springcourses.entity.Student;
import com.example.springcourses.specification.SearchableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, SearchableRepository<Student, Long> {

    @Override
    Optional<Student> findById(Long aLong);

    @Query("SELECT s FROM Student s WHERE s IN (SELECT u.student FROM UserEntity u WHERE u.login = ?1)")
    Optional<Student> findStudentByLogin(String login);

}
