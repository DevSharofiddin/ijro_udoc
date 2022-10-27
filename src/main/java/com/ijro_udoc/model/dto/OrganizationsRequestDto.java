package com.ijro_udoc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationsRequestDto {
    private Integer id;
    private LocalDateTime created_at;
    private Boolean deleted;
    private String name;
    private String name_ru;
    private String address;
    private String document_number_prefix;
    private String email;
    private String head_name;
    private String phone;
    private String tin;
    private Integer organization_typesId;
}
