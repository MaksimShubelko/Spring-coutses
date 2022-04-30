package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcademicPerformance implements BaseEntity<Long> {
    private Long academicPerformanceId;
    private Long testId;
    private Double mark;
    private Student student;
    private LocalDateTime dateTime;

    @Override
    public Long getId() {
        return academicPerformanceId;
    }
}
