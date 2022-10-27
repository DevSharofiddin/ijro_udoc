package com.ijro_udoc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionRequestDto {
   private Integer id;
   private LocalDateTime created_at;
   private Boolean deleted;
   private String admin_center_oz;
   private String admin_center_ru;
   private String admin_center_uz;
   private String code;
   private Integer district_id;
   private String name_oz;
   private String name_ru;
   private String name_uz;
   private Integer region_id;
   private Integer countryId;
}
