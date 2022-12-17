package com.example.springcourses.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
public class TeacherDetailsDto {

    private Integer hours;
    private Double salaryPerHour;
    private String description;
}
