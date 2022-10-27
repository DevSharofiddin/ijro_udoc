package com.ijro_udoc.model;

import com.ijro_udoc.model.enums.MonthlyWork;
import com.ijro_udoc.model.enums.Type;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "employment_type")
public class Employment_type {

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

    @Column(name = "has_deadline", nullable = false)
    private Boolean has_deadline;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "monthly_work")
    private MonthlyWork monthlyWork;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;

    public Employment_type() {
    }
}

