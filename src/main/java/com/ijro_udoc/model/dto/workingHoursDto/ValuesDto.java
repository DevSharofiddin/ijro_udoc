package com.ijro_udoc.model.dto.workingHoursDto;

import com.ijro_udoc.model.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuesDto {

    private Integer day;
    private Integer months;
    private Integer hour;
    private WeekDays week_day;
}
