package com.ijro_udoc.model.dto;

import com.ijro_udoc.model.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuesRequestDto {
    private Integer id;
    private LocalDateTime created_at;
    private Boolean deleted;
    private Long employeesId;
    private Integer years;
    private Integer months;
    private Integer daysOfMonth;
    private WeekDays daysOfWeek;
    private Integer workTime;
    private Integer leaveTypesId;
}
