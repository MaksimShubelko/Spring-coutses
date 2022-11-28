package com.example.springcourses.repository;

import com.example.springcourses.entity.Request;
import com.example.springcourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<Request> findByStudent(Student student);
}
