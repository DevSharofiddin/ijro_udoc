package com.ijro_udoc.controller;

import com.ijro_udoc.model.Employees;
import com.ijro_udoc.model.Leave_types;
import com.ijro_udoc.model.Values;
import com.ijro_udoc.model.dto.statisticsDto.LeaveTypesOneMonthDto;
import com.ijro_udoc.model.dto.statisticsDto.StatisticsOneMonthDto;
import com.ijro_udoc.model.dto.statisticsDto.ValuesStatisticsAllDto;
import com.ijro_udoc.model.dto.statisticsDto.ValuesStatisticsDto;
import com.ijro_udoc.model.dto.workingHoursDto.ValuesDto;
import com.ijro_udoc.model.dto.ValuesRequestDto;
import com.ijro_udoc.model.dto.workingHoursDto.WorkingHoursDto;
import com.ijro_udoc.model.enums.Type;
import com.ijro_udoc.service.EmployeesService;
import com.ijro_udoc.service.Leave_tupesService;
import com.ijro_udoc.service.ValuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/")
public class ValuesController {

    private final ValuesService valuesService;
    private final Leave_tupesService leave_tupesService;
    private final EmployeesService employeesService;

    public ValuesController(ValuesService valuesService, Leave_tupesService leave_tupesService, EmployeesService employeesService) {
        this.valuesService = valuesService;
        this.leave_tupesService = leave_tupesService;
        this.employeesService = employeesService;
    }

    @GetMapping("/employees_work_time_statistics_all/{department_id}")
    public ResponseEntity<?> employeesWorkTimeStatisticsAll(
            @PathVariable Integer department_id, @RequestParam Integer year, @RequestParam Integer month
    ) {
        // How many users in the department
        Integer average = 0;
        for (Employees employee: employeesService.findAll()) {
            if (employee.getDepartmentId().getId() == department_id) {
                average += 1;
            }
        }

        List<ValuesStatisticsAllDto> valuesStatisticsAllDtoList = new ArrayList<>();
        List<ValuesStatisticsDto> valuesStatisticsDtoList = new ArrayList<>();
        ValuesStatisticsAllDto valuesStatisticsAllDto = new ValuesStatisticsAllDto();

        Integer day_all=0, hour_all=0, full_day_all=0, full_hour_all=0;

        for (Employees employee: employeesService.findAll()) {
            if (employee.getDepartmentId().getId() == department_id) {

                ValuesStatisticsDto valuesStatisticsDto = new ValuesStatisticsDto();
                valuesStatisticsDto.setEmployee_name(employee.getName());
                valuesStatisticsDto.setPosition(employee.getPositionId().getName_ru());

                List<Integer> valuesLeaveTypes = new ArrayList<>(List.of(0,0,0,0,0,0,0,0));
                LeaveTypesOneMonthDto leaveTypesOneMonthDto = new LeaveTypesOneMonthDto();

                Integer hour = 0, day = 0, full_hour = 0, full_day = 0;
                for (Values value: valuesService.findAll()) {
                    if (Objects.equals(value.getEmployeesId().getId(), employee.getId())){
                        if (Objects.equals(year, value.getYears())) {
                            if (value.getMonths() <= month) {
                                if (value.getWorkTime() != null) {
                                    hour += value.getWorkTime();
                                    day += 1;
                                    full_day += 1;
                                    full_hour += value.getWorkTime();
                                }
                                else if (value.getLeaveTypesId() != null) {
                                    full_day += 1;

                                    if (employee.getEmployment_typeId().getType() == Type.full_time){
                                        full_hour += 8;
                                    }else full_hour += 4;

                                    Integer k = (value.getLeaveTypesId().getId());
                                    valuesLeaveTypes.set(k-1, valuesLeaveTypes.get(k-1)+1);
                                }
                            }
                        }
                    }
                }
                if (day != 0 & full_day != 0) {
                    valuesStatisticsDto.setPercentage(day * 100 / full_day);
                }
                else {
                    valuesStatisticsDto.setPercentage(0);
                }

                leaveTypesOneMonthDto.setОт(valuesLeaveTypes.get(0));
                leaveTypesOneMonthDto.setДо(valuesLeaveTypes.get(1));
                leaveTypesOneMonthDto.setБр(valuesLeaveTypes.get(2));
                leaveTypesOneMonthDto.setМ(valuesLeaveTypes.get(3));
                leaveTypesOneMonthDto.setУ(valuesLeaveTypes.get(4));
                leaveTypesOneMonthDto.setБс(valuesLeaveTypes.get(5));
                leaveTypesOneMonthDto.setПр(valuesLeaveTypes.get(6));
                leaveTypesOneMonthDto.setБ(valuesLeaveTypes.get(7));

                valuesStatisticsDto.setLeave_types(leaveTypesOneMonthDto);

                valuesStatisticsDto.setDay(day);
                valuesStatisticsDto.setHour(hour);
                valuesStatisticsDto.setFull_day(full_day);
                valuesStatisticsDto.setFull_hour(full_hour);
                valuesStatisticsDto.setUnit_per_period(1.0);

                valuesStatisticsDtoList.add(valuesStatisticsDto);

                day_all += day; full_day_all += full_day; hour_all += hour; full_hour_all += full_hour;
            }
        }

        valuesStatisticsAllDto.setDay_all(day_all);
        valuesStatisticsAllDto.setHour_all(hour_all);
        valuesStatisticsAllDto.setFull_day_all(full_day_all);
        valuesStatisticsAllDto.setFull_hour_all(full_hour_all);
        valuesStatisticsAllDto.setAverage_population(average);

        valuesStatisticsAllDto.setStatistics(valuesStatisticsDtoList);

        valuesStatisticsAllDtoList.add(valuesStatisticsAllDto);
        return ResponseEntity.ok(valuesStatisticsAllDtoList);
    }

    @GetMapping("/employees_work_time_statistics_one_month/{department_id}")
    public ResponseEntity<?> employeesWorkTimeStatisticsOneMonth(
            @PathVariable Integer department_id, @RequestParam Integer year, @RequestParam Integer month
    ) {
        List<StatisticsOneMonthDto> statisticsOneMonthDtoList = new ArrayList<>();

        for (Employees employee : employeesService.findAll()) {
            StatisticsOneMonthDto statisticsOneMonthDto = new StatisticsOneMonthDto();
            statisticsOneMonthDto.setEmployee_name(employee.getName());
            statisticsOneMonthDto.setPosition(employee.getPositionId().getName_ru());

            if (Objects.equals(employee.getDepartmentId().getId(), department_id)) {
                List<Integer> valuesLeaveTypes = new ArrayList<>(List.of(0,0,0,0,0,0,0,0));
                List<LeaveTypesOneMonthDto> leaveTypesOneMonthDtoList = new ArrayList<>();
                LeaveTypesOneMonthDto leaveTypesOneMonthDto = new LeaveTypesOneMonthDto();
                Integer hour = 0, day = 0, full_hour = 0, full_day = 0;
                for (Values value: valuesService.findAll()) {
                    if (Objects.equals(value.getEmployeesId().getId(), employee.getId())){
                        if (Objects.equals(year, value.getYears())) {
                            if (value.getMonths() <= month) {
                                if (value.getWorkTime() != null) {
                                    full_hour += value.getWorkTime();
                                }
                            }
                            if (Objects.equals(value.getMonths(), month)) {
                                if (value.getWorkTime() != null) {
                                    hour+=value.getWorkTime();
                                    day+=1;
                                    full_day += 1;
                                }
                                else if (value.getLeaveTypesId() != null) {
                                    full_day += 1;
                                    Integer k = (value.getLeaveTypesId().getId());
                                    valuesLeaveTypes.set(k-1, valuesLeaveTypes.get(k-1)+1);
                                }
                            }
                        }
                    }
                }
                leaveTypesOneMonthDto.setОт(valuesLeaveTypes.get(0));
                leaveTypesOneMonthDto.setДо(valuesLeaveTypes.get(1));
                leaveTypesOneMonthDto.setБр(valuesLeaveTypes.get(2));
                leaveTypesOneMonthDto.setМ(valuesLeaveTypes.get(3));
                leaveTypesOneMonthDto.setУ(valuesLeaveTypes.get(4));
                leaveTypesOneMonthDto.setБс(valuesLeaveTypes.get(5));
                leaveTypesOneMonthDto.setПр(valuesLeaveTypes.get(6));
                leaveTypesOneMonthDto.setБ(valuesLeaveTypes.get(7));

                leaveTypesOneMonthDtoList.add(leaveTypesOneMonthDto);
                statisticsOneMonthDto.setLeave_types(leaveTypesOneMonthDtoList);
                statisticsOneMonthDto.setDay(day);
                statisticsOneMonthDto.setHour(hour);
                statisticsOneMonthDto.setFull_hour(full_hour);
                statisticsOneMonthDto.setFull_day(full_day);
                statisticsOneMonthDto.setNo(null);

                statisticsOneMonthDtoList.add(statisticsOneMonthDto);
            }
        }
        return ResponseEntity.ok(statisticsOneMonthDtoList);
    }

    @GetMapping("/employees_work_time/{department_id}")
    public ResponseEntity<?> employeesWorkTime(@PathVariable Integer department_id) {

        List<WorkingHoursDto> workingHoursDtoList = new ArrayList<>();

        for (Employees employee: employeesService.findAll()) {
            WorkingHoursDto workingHoursDto = new WorkingHoursDto();

            if (Objects.equals(employee.getDepartmentId().getId(), department_id)) {
                workingHoursDto.setEmployee_name(employee.getName());
                workingHoursDto.setPosition(employee.getPositionId().getName_ru());

                List<ValuesDto> list = new ArrayList<>();

                for (Values value: valuesService.findAll()) {
                    ValuesDto valuesDto = new ValuesDto();
                    if (Objects.equals(value.getEmployeesId().getId(), employee.getId())) {
                        valuesDto.setDay(value.getDaysOfMonth());
                        valuesDto.setMonths(value.getMonths());
                        valuesDto.setHour(value.getWorkTime());
                        valuesDto.setWeek_day(value.getDaysOfWeek());

                        if (valuesDto.getHour() != null) {
                            list.add(valuesDto);
                            workingHoursDto.setWorking_hours(list);
                        }
                    }
                }
                workingHoursDtoList.add(workingHoursDto);
            }
        }
        return ResponseEntity.ok(workingHoursDtoList);
    }

    @PutMapping("/values-put")
    public ResponseEntity<?> valuesPut(@RequestBody ValuesRequestDto body) {

        //created_at
        Values values1 = valuesService.findById(body.getId());
        body.setCreated_at(values1.getCreated_at());

        Leave_types leave_types = null;
        if (body.getLeaveTypesId() != null){
            leave_types = leave_tupesService.findById(body.getLeaveTypesId());
            body.setWorkTime(null);
        }
        Employees employees = employeesService.findById(body.getEmployeesId());
        Values values = new Values(body, employees, leave_types);

        return ResponseEntity.ok(valuesService.save(values));
    }

    @PostMapping("/values-post")
    public ResponseEntity<?> valuesPost(@RequestBody ValuesRequestDto body) {

        Leave_types leave_types = null;
        if (body.getLeaveTypesId() != null) {
            leave_types = leave_tupesService.findById(body.getLeaveTypesId());
            body.setWorkTime(null);
        }
        Employees employees = employeesService.findById(body.getEmployeesId());

        Values values = new Values(body, employees, leave_types);
        return ResponseEntity.ok(valuesService.save(values));
    }

    @GetMapping("/values")
    public ResponseEntity<?> valuesGet() {
        return ResponseEntity.ok(valuesService.findAll());
    }

    @GetMapping("/values/{id}")
    public ResponseEntity<?> valuesGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(valuesService.findById(id));
    }

    @DeleteMapping("/values-del/{id}")
    public ResponseEntity<?> valuesDelOne(@PathVariable Integer id) {
        valuesService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
