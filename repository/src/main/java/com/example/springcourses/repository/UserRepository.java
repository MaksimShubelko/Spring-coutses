package com.example.springcourses.repository;

import com.example.springcourses.entity.Group;
import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.specification.SearchableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, SearchableRepository<UserEntity, Long> {

    Optional<UserEntity> findById(Long userId);

    @Query("SELECT u FROM UserEntity u WHERE u.teacher IS NOT NULL AND u = ?1")
    UserEntity findByTeacher(UserEntity userEntity);

    @Query("SELECT u FROM UserEntity u WHERE u.student IS NOT NULL AND u = ?1")
    UserEntity findByStudent(UserEntity userEntity);

    @Query("SELECT u FROM UserEntity u WHERE u.student.group = ?1")
    List<UserEntity> findByGroup(Group group);

    boolean existsByLogin(String login);

    Optional<UserEntity> findByLogin(String login);

}
