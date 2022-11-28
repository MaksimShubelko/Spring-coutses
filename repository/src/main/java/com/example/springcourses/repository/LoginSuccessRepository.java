package com.example.springcourses.repository;

import com.example.springcourses.entity.LoginSuccess;
import com.example.springcourses.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginSuccessRepository extends JpaRepository<LoginSuccess, Integer> {

    Optional<LoginSuccess> findTopByUserOrderByLastModifiedDateDesc(UserEntity user);
}
