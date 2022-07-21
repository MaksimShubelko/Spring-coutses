package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "groups")
@Entity
public class Group extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @OneToMany
    @Column(name = "student_id")
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "lesson_id")
    private List<Lesson> lessons;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, mappedBy = "group")
    @Column(name = "test_id")
    private List<Test> tests;

    @Override
    public Long getId() {
        return groupId;
    }
}
