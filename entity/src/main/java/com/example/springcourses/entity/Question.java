package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "questions")
@Entity
public class Question extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @OneToOne(mappedBy = "question")
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(updatable = false, nullable = false, name = "test_id")
    private Test test;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correct_answer_id")
    private CorrectAnswer correctAnswer;

    @Override
    public Long getId() {
        return questionId;
    }
}
