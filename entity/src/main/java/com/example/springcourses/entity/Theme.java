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
@Table(name = "themes")
@Entity
public class Theme extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "theme_id")
    private Long themeId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public Long getId() {
        return themeId;
    }
}
