package com.example.springcourses.dto;

import com.example.springcourses.entity.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class RequestDto {

    private Long requestId;
    private RequestStatus requestStatus;
    private CourseDto courseDto;
    private StudentDto studentDto;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedAt;

}
