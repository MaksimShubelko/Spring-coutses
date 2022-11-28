package com.example.springcourses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SystemOptionDto {

    private String id;
    private String value;
}
