package com.example.springcourses.entity;

import com.example.springcourses.converter.RequestConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "requests")
@Entity
public class Request extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "request_id")
    private Long requestId;

    @Convert(converter = RequestConverter.class)
    @Builder.Default
    @Column(name = "request_status")
    private RequestStatus requestStatus = RequestStatus.NEW;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public Long getId() {
        return requestId;
    }
}
