package com.example.springcourses.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "course", cascade = {CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(nullable = false, name = "theme_id")
    private List<Theme> themes;

    @Column(name = "group_id")
    @OneToMany
    private List<Group> groups;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "request_id")
    private List<Request> requests;

    @Override
    public Long getId() {
        return courseId;
    }
}
