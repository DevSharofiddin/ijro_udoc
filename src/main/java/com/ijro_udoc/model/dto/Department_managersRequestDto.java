package com.ijro_udoc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department_managersRequestDto {
    private Integer id;
    private LocalDateTime created_at;
    private Boolean deleted;
    private Integer departmentId;
    private Long userId;
}
