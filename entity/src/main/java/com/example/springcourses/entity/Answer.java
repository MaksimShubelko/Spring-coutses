package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "answers")
@Entity
public class Answer extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(updatable = false, nullable = false, name = "question_id")
    private Question question;

    @Column(name = "date_passed")
    private OffsetDateTime date;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "academic_performance_id")
    private AcademicPerformance academicPerformance;


    @Override
    public Long getId() {
        return answerId;
    }
}
