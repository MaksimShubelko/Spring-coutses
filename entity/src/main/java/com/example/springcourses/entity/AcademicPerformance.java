package com.example.springcourses.entity;

import java.time.LocalDateTime;

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
