package com.example.springcourses.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

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

    @Builder.Default
    @UpdateTimestamp
    @Column(nullable = false, name = "last_modified_at", columnDefinition = "local date with timezone default now()")
    private OffsetDateTime lastModifiedAt = OffsetDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public abstract ID getId();

}
