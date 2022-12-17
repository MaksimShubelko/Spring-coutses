package com.example.springcourses.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @Column(name = "group_id")
    private Long groupId;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @Column
    private List<Student> students;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private Course course;

    @Column(name = "description")
    private String description;

    @Override
    public Long getId() {
        return groupId;
    }
}
