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
public class Student extends User {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID studentId;*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "academic_performance")
    private List<AcademicPerformance> academicPerformances;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(updatable = false, name = "receipt_status")
    private Receipt receipt;

    @Column(name = "total_mark")
    private Double totalMark;

    /*@OneToOne(cascade = CascadeType.ALL)
    private User user;*/

    /*@Override
    public UUID getId() {
        return studentId;
    }*/

    @PostLoad
    @PostUpdate
    private void calculateMiddleMark() {
        OptionalDouble average = academicPerformances.stream()
                .mapToDouble(AcademicPerformance::getMark)
                .average();

        totalMark = average.orElse(0);
    }
}
