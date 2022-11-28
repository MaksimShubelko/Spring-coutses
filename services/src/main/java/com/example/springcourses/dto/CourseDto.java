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
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CourseDto {

    private Long courseId;
    @NotBlank
    private String courseName;
    @Valid
    private List<ThemeDto> themesDto;
}
