package com.example.springcourses.dto;

import com.example.springcourses.entity.Receipt;
import com.example.springcourses.entity.RequestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RequestDto {

    private Long requestId;
    private RequestStatus requestStatus;
    private CourseDto courseDto;
    private StudentDto studentDto;
}
