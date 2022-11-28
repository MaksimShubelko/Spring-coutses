package com.example.springcourses.repository;

import com.example.springcourses.entity.Teacher;
import com.example.springcourses.entity.UserEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserEntityRepositoryIT {

    @Autowired
    UserRepository userRepository;

    @Order(1)
    @Test
    public void test0_findAll() {
        List<UserEntity> result = userRepository.findAll();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Order(2)
    @Test
    public void test1_save() {
        //given
        UserEntity userEntity = UserEntity.builder()
                .firstName("fn")
                .lastName("ln")
                .phoneNumber("+375292150297")
                .teacher(new Teacher())
                .build();
        //when
        UserEntity result = userRepository.save(userEntity);


        //then
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getCreatedAt());
        assertEquals("fn", result.getFirstName());
        assertEquals("ln", result.getLastName());
        assertEquals("+375292150297", result.getPhoneNumber());
    }

    @Order(3)
    @Test
    public void test2_findAll() {
        List<UserEntity> result = userRepository.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Order(4)
    @Test
    public void test3_delete() {
        List<UserEntity> result = userRepository.findAll();
        UserEntity userEntity = result.stream().filter(u -> u.getFirstName().equals("fn")).collect(Collectors.toList()).get(0);
        userRepository.delete(userEntity);

    }

    @Order(5)
    @Test
    public void test4_findAll() {
        List<UserEntity> result = userRepository.findAll();
        assertNotNull(result);
        assertEquals(0, result.size());

    }


}