package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements BaseEntity<Long> {
    private Long studentId;
    private User user;
    private AcademicPerformance academicPerformance;
    private Group group;
    private Receipt receipt;

    @Override
    public Long getId() {
        return studentId;
    }
}
