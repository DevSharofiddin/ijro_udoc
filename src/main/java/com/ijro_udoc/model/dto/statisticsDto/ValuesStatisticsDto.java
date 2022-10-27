package com.ijro_udoc.model.dto.statisticsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuesStatisticsDto {
    // user
    private String employee_name;
    private String position;
    // missing day
    private LeaveTypesOneMonthDto leave_types;
    // явка
    private Integer day;
    private Integer hour;
    // всего
    private Integer full_day;
    private Integer full_hour;
    // явка %
    private Integer percentage;
    // единица за период
    private Double unit_per_period;
}
