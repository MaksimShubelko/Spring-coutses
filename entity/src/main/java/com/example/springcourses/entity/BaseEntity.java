package com.example.springcourses.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private OffsetDateTime createdAt;

    @CreatedBy
    @Column(updatable = false, name = "created_by")
    private String createdBy;

    @UpdateTimestamp
    @Column(nullable = false, name = "last_modified_at")
    private OffsetDateTime lastModifiedAt;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public abstract ID getId();

}
