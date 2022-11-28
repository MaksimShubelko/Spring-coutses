package com.example.springcourses.controller;

import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collection;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    @Mock
    UserService userService;

    @Test
    public void index() {
        //given
        Model model = mock(Model.class);
        Collection<UserDto> userDtos = mock(Collection.class);
        when(userService.findAll()).thenReturn(userDtos);

        //when
        String result = indexController.index(model);

        //then
        Assertions.assertEquals("index", result);
        verify(model, times(1)).addAttribute(eq("test_attr"), eq("test_val"));
        verify(model, times(1)).addAttribute(eq("users"), anyCollection());


    }
}