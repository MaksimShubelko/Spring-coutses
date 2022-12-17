package com.example.springcourses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GroupDto {

    private Long groupId;
    @Valid
    private List<StudentDto> studentsDto;
    @Valid
    private CourseDto courseDto;
    @Pattern(regexp = ".{3,50}", message = "The length should be from 3 to 50")
    private String description;


}
