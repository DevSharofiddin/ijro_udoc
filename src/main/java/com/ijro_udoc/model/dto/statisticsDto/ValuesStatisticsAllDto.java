package com.ijro_udoc.model.dto.statisticsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuesStatisticsAllDto {

    // итого
    private Integer day_all;
    private Integer hour_all;
    private Integer full_day_all;
    private Integer full_hour_all;
    // средняя численность
    private Integer average_population;

    private List<ValuesStatisticsDto> Statistics;

}
