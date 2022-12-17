package com.example.springcourses.repository;

import com.example.springcourses.entity.Course;
import com.example.springcourses.entity.Group;
import com.example.springcourses.entity.Request;
import com.example.springcourses.entity.Student;
import com.example.springcourses.specification.SearchableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, SearchableRepository<Student, Long> {

    @Override
    Optional<Student> findById(Long aLong);

    @Query("SELECT s FROM Student s WHERE s.request.course = ?1")
    List<Student> findByRequestNewAndCourse(Course course);

    @Query("SELECT s FROM Student s WHERE s IN (SELECT u.student FROM UserEntity u WHERE u.login = ?1)")
    Optional<Student> findStudentByLogin(String login);

    @Query("SELECT s FROM Student s WHERE s.request = ?1")
    Optional<Student> findByRequest(Request request);

    List<Student> findByGroup(Group group);
}
