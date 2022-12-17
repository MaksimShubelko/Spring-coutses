package com.example.springcourses.repository;

import com.example.springcourses.entity.Course;
import com.example.springcourses.entity.Request;
import com.example.springcourses.entity.RequestStatus;
import com.example.springcourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {


    @Query("SELECT r FROM Request r WHERE r.requestStatus = 'New' AND r.course = ?1")
    List<Request> findAllByCourseWithRequestStatusNew(Course course);

    Optional<Request> findByStudent(Student student);

    Optional<Request> findById(Long requestId);
}
