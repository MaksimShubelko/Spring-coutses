package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "courses")
@Entity
public class Course extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(nullable = false, name = "theme_id")
    private List<Theme> themes;

    @OneToMany(mappedBy = "course")
    @Column(name = "request_id")
    private List<Request> requests;

    @Override
    public Long getId() {
        return courseId;
    }
}
