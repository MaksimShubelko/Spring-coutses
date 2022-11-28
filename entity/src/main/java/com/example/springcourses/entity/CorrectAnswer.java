package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "correct_answers")
@Entity
public class CorrectAnswer extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correct_answer_id")
    private Long correctAnswerId;

    @OneToOne(mappedBy = "correctAnswer")
    @JoinColumn(updatable = false, nullable = false, name = "question_id")
    private Question question;

    @Column(nullable = false, name = "correct_answer")
    private String correctAnswer;

    @Override
    public Long getId() {
        return correctAnswerId;
    }
}
