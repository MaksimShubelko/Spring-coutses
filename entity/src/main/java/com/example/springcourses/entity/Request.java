package com.example.springcourses.entity;

import com.example.springcourses.converter.ReceiptRequestConverter;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "requests")
@Entity
public class Request extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long requestId;

    @Convert(converter = ReceiptRequestConverter.class)
    @Column(name = "request_status")
    private RequestStatus requestStatus;

    @OneToOne(mappedBy = "request")
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @Override
    public Long getId() {
        return requestId;
    }
}
