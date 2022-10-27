package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.RegionRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "region")
public class Region {

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

    @Column(name = "admin_center_oz", length = 255)
    private String admin_center_oz;

    @Column(name = "admin_center_ru", length = 255)
    private String admin_center_ru;

    @Column(name = "admin_center_uz", length = 255)
    private String admin_center_uz;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "district_id")
    private Integer district_id;

    @Column(name = "name_oz", length = 255)
    private String name_oz;

    @Column(name = "name_ru", length = 255)
    private String name_ru;

    @Column(name = "name_uz", length = 255)
    private String name_uz;

    @Column(name = "region_id")
    private Integer region_id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

    public Region() {
    }

    public Region(RegionRequestDto body, Country country) {
        this.id = body.getId();
        this.created_at = body.getCreated_at();
        this.deleted = body.getDeleted();
        this.admin_center_oz = body.getAdmin_center_oz();
        this.admin_center_ru = body.getAdmin_center_ru();
        this.admin_center_uz = body.getAdmin_center_uz();
        this.code = body.getCode();
        this.district_id = body.getDistrict_id();
        this.name_oz = body.getName_oz();
        this.name_ru = body.getName_ru();
        this.name_uz = body.getName_uz();
        this.region_id = body.getRegion_id();
        this.countryId = country;
    }
}
