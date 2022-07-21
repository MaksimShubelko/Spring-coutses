package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
/*
@Table(name = "receipt")
*/
@Entity
public class Receipt extends BaseEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID receiptId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Column(name = "cost")
    private BigDecimal cost;

    @Override
    public UUID getId() {
        return receiptId;
    }
}
