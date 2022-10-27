package com.ijro_udoc.model.dto.workingHoursDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingHoursDto {
    private String employee_name;
    private String position;
    private List<ValuesDto> working_hours;
}
