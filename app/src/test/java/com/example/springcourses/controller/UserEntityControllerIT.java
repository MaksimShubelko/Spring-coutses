package com.example.springcourses.controller;

import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest
class UserEntityControllerIT extends BaseIT {

    @MockBean
    UserService userService;

    @DisplayName("Process find user")
    @Nested
    class ProcessFind {

        @Test
        void findUsers_403() throws Exception {
            mockMvc.perform(get("/users/find").with(anonymous()))
                    .andExpect(status().isUnauthorized());
        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getTeacher")
        void findUsers(String login, String password) throws Exception {
            mockMvc.perform(get("/users/find").with(httpBasic(login, password)))
                    .andExpect(status().isOk())
                    .andExpect(view().name("users/findUsers"))
                    .andExpect(model().attributeExists("userFilter"));
        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getTeacher")
        void findUsers_withpwd(String login, String password) throws Exception {
            mockMvc.perform(get("/users/find").with(httpBasic(login, password)))
                    .andExpect(status().isOk())
                    .andExpect(view().name("users/findUsers"))
                    .andExpect(model().attributeExists("userFilter"));
        }
    }

    @Test
    void getUsers() throws Exception {
        mockMvc.perform(get("/users/index"))
                .andExpect(status().isOk());
    }

    @Test
    void getUsers_with() throws Exception {
        mockMvc.perform(get("/users/index").with(anonymous()))
                .andExpect(status().isOk());
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/users/new").with(anonymous()))
                .andExpect(status().isOk())
                .andExpect(view().name("users/createOrUpdateUser"))
                .andExpect(model().attributeExists("userDto"));
    }


    @DisplayName("Process create user")
    @Nested
    class ProcessCreate {

        @Test
        void processCreation_403anonymous() throws Exception {
            mockMvc.perform(post("/users/new").with(anonymous()))
                    .andExpect(status().isUnauthorized());
        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getStudent")
        void processCreation_403student(String login, String password) throws Exception {
            mockMvc.perform(post("/users/new").with(httpBasic(login, password)))
                    .andExpect(status().isForbidden());
        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getTeacher")
        void processCreation_found_teacher(String login, String password) throws Exception {
            mockMvc.perform(post("/users/new").with(httpBasic(login, password)))
                    .andExpect(status().isFound());
        }


    }

    @Test
    void initUpdateForm() throws Exception {
        when(userService.findById(1L)).thenReturn(UserDto.builder().build());
        mockMvc.perform(get("/users/1/edit").with(anonymous()))
                .andExpect(status().isOk())
                .andExpect(view().name("users/createOrUpdateUser"))
                .andExpect(model().attributeExists("userDto"));
    }

    @DisplayName("Process update user")
    @Nested
    class ProcessUpdate {
        @Test
        void initUpdateForm_403anonymous() throws Exception {
            mockMvc.perform(post("/users/1/edit").with(anonymous()))
                    .andExpect(status().isUnauthorized());

        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getStudent")
        void initUpdateForm_403student(String login, String password) throws Exception {
            mockMvc.perform(post("/users/1/edit").with(httpBasic(login, password)))
                    .andExpect(status().isForbidden());

        }

        @ParameterizedTest(name = "#{index} with [{arguments}]")
        @MethodSource("com.example.springcourses.controller.BaseIT#getTeacher")
        void initUpdateForm_ok_teacher(String login, String password) throws Exception {
            mockMvc.perform(post("/users/1/edit").with(httpBasic(login, password)))
                    .andExpect(status().isOk());

        }
    }

}