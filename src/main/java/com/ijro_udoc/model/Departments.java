package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.DepartmentsRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Departments {

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

    @Column(name = "is_head")
    private Boolean is_head;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "name_ru", length = 255)
    private String name_ru;

    @Column(name = "parent_id")
    private Integer parent_id;

    @ManyToOne
    @JoinColumn(name = "curator_id")
    private Users curatorId;

    @ManyToOne
    @JoinColumn(name = "head_id")
    private Users headId;

    public Departments() {
    }

    public Departments(DepartmentsRequestDto body, Users curatorId, Users headId) {
        this.id = body.getId();
        this.created_at = body.getCreated_at();
        this.deleted = body.getDeleted();
        this.code = body.getCode();
        this.is_head = body.getIs_head();
        this.name = body.getName();
        this.name_ru = body.getName_ru();
        this.parent_id = body.getParent_id();
        this.curatorId = curatorId;
        this.headId = headId;
    }
}
