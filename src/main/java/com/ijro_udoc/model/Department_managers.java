package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.Department_managersRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "department_managers")
public class Department_managers {

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

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    public Department_managers() {
    }

    public Department_managers(Department_managersRequestDto body, Departments departmentId, Users userId) {
        this.id = body.getId();
        this.created_at = body.getCreated_at();
        this.deleted = body.getDeleted();
        this.departmentId = departmentId;
        this.userId = userId;
    }
}
