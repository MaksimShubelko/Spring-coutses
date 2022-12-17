package com.example.springcourses.dto;

import com.example.springcourses.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class StudentDto {

    private Long studentId;


    private GroupDto groupDto;


    private Double totalMark;

    private String createdBy;


    private OffsetDateTime lastModifiedAt;

    private RequestDto request;

}
