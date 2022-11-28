package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.OptionalDouble;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "students")
@Entity
public class Student extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "academic_performance")
    private List<AcademicPerformance> academicPerformances;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, mappedBy = "student")
    @Column(updatable = false, name = "receipt")
    private List<Receipt> receipts;

    @Column(name = "total_mark")
    private Double totalMark;

    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER)
    private Request request;

    @OneToOne(mappedBy = "student")
    private UserEntity userEntity;

    @Override
    public Long getId() {
        return studentId;
    }

    @PostLoad
    @PostUpdate
    private void calculateMiddleMark() {
        OptionalDouble average = academicPerformances.stream()
                .mapToDouble(AcademicPerformance::getMark)
                .average();

        totalMark = average.orElse(0);
    }
}
