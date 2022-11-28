package com.example.springcourses.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityDtoTest {

    UserDto userDto;

    @BeforeEach
    public void setUp() throws Exception {
        userDto = new UserDto();
    }

    @Test
    public void getUserId() {
        //given
        Long id = 123L;

        //when
        userDto.setUserId(id);

        //then
        assertEquals(id, userDto.getUserId());
    }

    @Test
    public void getFirstName() {
        //given
        String firstName = "first_name";

        //when
        userDto.setFirstName(firstName);

        //then
        assertEquals(firstName, userDto.getFirstName(), "Not eq");
    }
}