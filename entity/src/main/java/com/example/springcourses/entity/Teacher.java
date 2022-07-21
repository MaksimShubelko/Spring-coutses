package com.example.springcourses.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "teachers")
@Entity
public class Teacher extends User {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID teacherId;*/

    @Column(name = "hour")
    private Integer hours;

    @Column(name = "salary_per_hour")
    private Double salaryPerHour;

    @ManyToMany(mappedBy = "teachers")
    @Column(name = "lesson_id")
    private List<Lesson> lessons;

  /*  @OneToOne(cascade = CascadeType.ALL)
    private User user;*/

    @Column(name = "description")
    private String description;

    /*@Override
    public UUID getId() {
        return teacherId;
    }*/
}
