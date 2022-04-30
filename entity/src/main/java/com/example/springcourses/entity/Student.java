package com.example.springcourses.entity;

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
