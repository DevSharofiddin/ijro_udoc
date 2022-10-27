package com.ijro_udoc.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "organization_types ")
public class Organization_types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at = null;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at = null;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "inner_deadline")
    private Long inner_deadline;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "name_ru", length = 255)
    private String name_ru;

    @Column(name = "number", length = 255)
    private String number;

    @Column(name = "outer_deadline")
    private Long outer_deadline;

    @Column(name = "prefix", length = 255)
    private String prefix;

    public Organization_types() {
    }
}
