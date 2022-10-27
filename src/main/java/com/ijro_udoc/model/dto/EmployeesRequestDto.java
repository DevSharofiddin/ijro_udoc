package com.ijro_udoc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesRequestDto {
    private LocalDate fired_date;
    private LocalDate hired_date;

    private LocalDate birth_date;
    private LocalDate deadline;
    private LocalDate passport_expiry;
    private LocalDate read_responsibility_at;

    private Long id;
    private LocalDateTime created_at;
    private Boolean deleted = false;
    private String email;
    private String home_phone;
    private String mobile_phone;
    private String name;
    private String office_phone;
    private String patronymic;
    private String photo;
    private String pin;
    private String surname;
    private String telegram;
    private String card_number;
    private String gender;
    private String marital;
    private String passport_serial;
    private Boolean read_responsibility;
    private Boolean has_deadline;
    private Integer departmentId;
    private Integer employment_typeId;
    private Integer officeId;
    private Long userId;
    private Integer positionId;
}
