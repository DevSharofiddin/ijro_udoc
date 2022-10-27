package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.Department_positionsRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "department_positions")
public class Department_positions {

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

    @Column(name = "work_place")
    private Integer work_place;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Positions positionId;

    public Department_positions() {
    }

    public Department_positions(Department_positionsRequestDto body, Departments departmentId, Positions positionId) {
        this.id = body.getId();
        this.created_at = body.getCreated_at();
        this.deleted = body.getDeleted();
        this.work_place = body.getWork_place();
        this.departmentId = departmentId;
        this.positionId = positionId;
    }
}
