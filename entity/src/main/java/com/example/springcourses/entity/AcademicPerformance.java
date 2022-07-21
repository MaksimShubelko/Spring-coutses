package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "academic_performances")
@Entity
public class AcademicPerformance extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicPerformanceId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(updatable = false, nullable = false, name = "test_id")
    private Test test;

    @Column(name = "student_mark")
    private Double mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "time_passed")
    private LocalDateTime timeOfPassed;

    @OneToMany(mappedBy = "academicPerformance")
    @Column(name = "answer_id")
    private List<Answer> answers;

    @Override
    public Long getId() {
        return academicPerformanceId;
    }

}


