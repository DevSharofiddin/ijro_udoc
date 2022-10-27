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
@Table(name = "company")
public class Company {

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

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "head_name", length = 255)
    private String head_name;

    @Column(name = "logo", length = 255)
    private String logo;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "phone", length = 255)
    private String phone;

    public Company() {
    }
}
