package com.example.springcourses.controller;

import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.entity.UserRole;
import com.example.springcourses.repository.*;
import com.example.system.repository.SystemLogRepository;
import com.example.system.repository.SystemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public abstract class BaseIT {

    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @MockBean
    CourseRepository courseRepository;
    @MockBean
    GroupRepository groupRepository;
    @MockBean
    StudentRepository studentRepository;
    @MockBean
    TeacherRepository teacherRepository;
    @MockBean
    ThemeRepository themeRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    SystemRepository systemRepository;
    @MockBean
    SystemLogRepository systemLogRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();

        UserEntity teacher = UserEntity.builder().login("teacher").password("{noop}1111")
                .userRole(UserRole.TEACHER).build();
        UserEntity student = UserEntity.builder().login("badstud").password("{noop}2150297mM@")
                .userRole(UserRole.STUDENT).build();

        when(userRepository.findByLogin("teacher")).thenReturn(Optional.of(teacher));
        when(userRepository.findByLogin("student")).thenReturn(Optional.of(student));
    }

    public static Stream<Arguments> getAllUsers() {
        return Stream.of(Arguments.of("teacher", "1111"),
                Arguments.of("badstud", "2222"));
    }

    public static Stream<Arguments> getTeacher() {
        return Stream.of(Arguments.of("badstud", "2150297mM@"));
    }

    public static Stream<Arguments> getStudent() {
        return Stream.of(Arguments.of("badstud", "2150297mM@"));
    }
}
