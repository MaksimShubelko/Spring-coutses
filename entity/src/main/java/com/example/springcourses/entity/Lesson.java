package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "lessons")
@Entity
public class Lesson extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "date_lesson")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany
    @Column(name = "teacher_id")
    private List<Teacher> teachers;

    @Column(name = "theme")
    private String theme;

    @Override
    public Long getId() {
        return lessonId;
    }
}
