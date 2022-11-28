package com.example.system.entity;

import com.example.listener.SystemOptionalEntityListener;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(SystemOptionalEntityListener.class)
@Entity
@Table(name = "SYSTEM_OPTION")
public class SystemOptionEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "value")
    private String value;

}

