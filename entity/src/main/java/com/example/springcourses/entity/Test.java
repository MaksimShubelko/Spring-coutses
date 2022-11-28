package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tests")
@Entity
public class Test extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "test_id")
    private Long testId;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    @Column(name = "question_id")
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "test")
    @Column(name = "academic_parformance_id")
    private List<AcademicPerformance> academicPerformances;

    @Override
    public Long getId() {
        return testId;
    }
}
