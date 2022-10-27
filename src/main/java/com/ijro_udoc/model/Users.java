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
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at = null;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at = null;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "role", length = 255)
    private String role;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "resolution_user_id")
    private Long resolution_user_id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;

    public Users() {
    }
}
