package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "receipts")
@Entity
public class Receipt extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private UUID receiptId;

    @Column(name = "favor_name")
    private String nameOfFavor;

    @Column(name = "date_of_payment", nullable = false)
    private OffsetDateTime dateOfPayment;

    @Column(name = "receipt_status", nullable = false)
    private ReceiptStatus receiptStatus;

    @ManyToOne
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
