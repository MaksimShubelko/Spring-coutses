package com.example.springcourses.dto;

import com.example.springcourses.entity.Group;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
public class StudentDetailsDto extends UserDto {
    private Group group;
    private Double totalMark;
}
