package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "total_mark")
    private Double totalMark;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Request request;

    @OneToOne(mappedBy = "student")
    private UserEntity userEntity;

    @Override
    public Long getId() {
        return studentId;
    }

}
