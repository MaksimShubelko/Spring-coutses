package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "teachers")
@Entity
public class Teacher extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "hour")
    private Integer hours;

    @Column(name = "salary_per_hour")
    private Double salaryPerHour;

    @ManyToMany(mappedBy = "teachers")
    @Column(name = "lesson_id")
    private List<Lesson> lessons;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    private UserEntity userEntity;

    @Override
    public Long getId() {
        return teacherId;
    }
}
