package com.ijro_udoc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsRequestDto {
    private Integer id;
    private LocalDateTime created_at;
    private Boolean deleted;
    private String code;
    private Boolean is_head;
    private String name;
    private String name_ru;
    private Integer parent_id;
    private Long curatorId;
    private Long headId;
}
