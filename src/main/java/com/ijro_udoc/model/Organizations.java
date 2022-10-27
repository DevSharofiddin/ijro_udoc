package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.OrganizationsRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organizations {

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

    @Column(name = "address")
    private String address;

    @Column(name = "document_number_prefix")
    private String document_number_prefix;

    @Column(name = "email")
    private String email;

    @Column(name = "head_name")
    private String head_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tin")
    private String tin;

    @ManyToOne
    @JoinColumn(name = "organization_type_id")
    private Organization_types organization_typesId;

    public Organizations() {
    }

    public Organizations(OrganizationsRequestDto organizations, Organization_types organization_types) {
        this.id = organizations.getId();
        this.created_at = organizations.getCreated_at();
        this.deleted = organizations.getDeleted();
        this.name = organizations.getName();
        this.name_ru = organizations.getName_ru();
        this.address = organizations.getAddress();
        this.document_number_prefix = organizations.getDocument_number_prefix();
        this.email = organizations.getEmail();
        this.head_name = organizations.getHead_name();
        this.phone = organizations.getPhone();
        this.tin = organizations.getTin();
        this.organization_typesId = organization_types;
    }
}
