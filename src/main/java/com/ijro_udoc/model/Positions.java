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
@Table(name = "positions")
public class Positions {

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

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "name_ru", length = 255)
    private String name_ru;

    @Column(name = "functional_responsibility")
    private String functional_responsibility;

    public Positions() {
    }
}
