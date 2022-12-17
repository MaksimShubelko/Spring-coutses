package com.example.springcourses.dto;

import com.example.springcourses.entity.Theme;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CourseDto {

    private Long courseId;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "The length should be from 3 to 50")
    private String courseName;
    @Valid
    private List<ThemeDto> themesDto;
    @Valid
    private List<GroupDto> groupsDto;
}
