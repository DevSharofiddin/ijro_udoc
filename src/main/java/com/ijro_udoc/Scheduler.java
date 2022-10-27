package com.ijro_udoc;

import com.ijro_udoc.model.Employees;
import com.ijro_udoc.model.Leave_types;
import com.ijro_udoc.model.Values;
import com.ijro_udoc.model.dto.ValuesRequestDto;
import com.ijro_udoc.model.enums.MonthlyWork;
import com.ijro_udoc.model.enums.Type;
import com.ijro_udoc.model.enums.WeekDays;
import com.ijro_udoc.service.EmployeesService;
import com.ijro_udoc.service.Leave_tupesService;
import com.ijro_udoc.service.ValuesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Component
public class Scheduler {

    private final EmployeesService employeesService;
    private final ValuesService valuesService;

    public Scheduler(EmployeesService employeesService, ValuesService valuesService) {
        this.employeesService = employeesService;
        this.valuesService = valuesService;
    }

    // Fire at 59:23 AM on the last day of every month
    //@Scheduled(cron = "0 40 21 * * ?") //test 21 = hour  40 = minutes
    @Scheduled(cron = "0 59 23 L * ?")
    public void employeesFindAll() {
        ValuesRequestDto body = new ValuesRequestDto();
        LocalDate localDate = LocalDate.now();
        LocalDate monthDayMax = LocalDate.MAX;

        List<Employees> employeesAll = employeesService.findAll();
        for (Employees employee: employeesAll) {

            Employees employees = employeesService.findById(employee.getId());
            body.setEmployeesId(employee.getId());
            body.setDeleted(false);
            body.setYears(localDate.getYear());
            body.setMonths(localDate.getMonthValue());

            // Type = full_time
            if (employee.getEmployment_typeId().getType() == Type.full_time) {

                // MonthlyWork = full
                if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.full) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            body.setWorkTime(8);
                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }

                // MonthlyWork = first_half
                else if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.first_half) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            if (i <= 15) {
                                body.setWorkTime(8);
                            } else body.setWorkTime(null);

                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }

                // MonthlyWork = second_half
                else if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.second_half) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            if (i > 15) {
                                body.setWorkTime(8);
                            } else body.setWorkTime(null);

                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }
            }

            // Type = half_time
            else if (employee.getEmployment_typeId().getType() == Type.half_time) {

                // MonthlyWork = full
                if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.full) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            body.setWorkTime(4);
                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }

                // MonthlyWork = second_half
                else if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.second_half) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            if (i > 15) {
                                body.setWorkTime(8);
                            } else body.setWorkTime(null);

                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }

                // MonthlyWork = first_half
                else if (employee.getEmployment_typeId().getMonthlyWork() == MonthlyWork.first_half) {
                    for (int i = 1; i <= monthDayMax.getDayOfMonth(); i++) {
                        LocalDate weekDaysAll = LocalDate.of(localDate.getYear(), localDate.getMonth(), i);

                        // setDaysOfMonth for column
                        body.setDaysOfMonth(i);

                        // setDaysOfWeek for column
                        if (weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY){
                            body.setDaysOfWeek(WeekDays.MONDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY) {
                            body.setDaysOfWeek(WeekDays.TUESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                            body.setDaysOfWeek(WeekDays.WEDNESDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY) {
                            body.setDaysOfWeek(WeekDays.THURSDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY) {
                            body.setDaysOfWeek(WeekDays.FRIDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            body.setDaysOfWeek(WeekDays.SATURDAY);
                        }
                        else if (weekDaysAll.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            body.setDaysOfWeek(WeekDays.SUNDAY);
                        }

                        // setWorkTime for column
                        if (
                                weekDaysAll.getDayOfWeek() == DayOfWeek.MONDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.TUESDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.THURSDAY ||
                                        weekDaysAll.getDayOfWeek() == DayOfWeek.FRIDAY
                        ) {
                            if (i <= 15) {
                                body.setWorkTime(8);
                            } else body.setWorkTime(null);

                        } else
                            body.setWorkTime(null);

                        if (body.getMonths() == 1) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 3) {
                            if (body.getDaysOfMonth() == 8 & body.getDaysOfMonth() == 21){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 5) {
                            if (body.getDaysOfMonth() == 9){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 9) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 10) {
                            if (body.getDaysOfMonth() == 1){
                                body.setWorkTime(null);
                            }
                        }

                        if (body.getMonths() == 12) {
                            if (body.getDaysOfMonth() == 8){
                                body.setWorkTime(null);
                            }
                        }

                        Values values = new Values(body,employees, null);
                        valuesService.save(values);
                    }
                }
            }
        }
    }
}