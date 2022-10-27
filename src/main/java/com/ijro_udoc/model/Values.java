package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.ValuesRequestDto;
import com.ijro_udoc.model.enums.WeekDays;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "values")
public class Values {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at = null;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at = null;

    @ManyToOne
    @JoinColumn(name = "employees_id", nullable = false)
    private Employees employeesId;

    @Column(name = "Years")
    private Integer years;

    @Column(name = "months")
    private Integer months;

    @Column(name = "days_of_month")
    private Integer daysOfMonth;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "days_of_week")
    private WeekDays daysOfWeek;

    @Column(name = "work_time")
    private Integer workTime;

    @ManyToOne
    @JoinColumn(name = "leave_types_id")
    private Leave_types leaveTypesId;

    public Values() {
    }

    public Values(ValuesRequestDto valuesRequestDto, Employees employees, Leave_types leave_types) {
        this.id = valuesRequestDto.getId();
        this.created_at = valuesRequestDto.getCreated_at();
        this.deleted = valuesRequestDto.getDeleted();
        this.employeesId = employees;
        this.years = valuesRequestDto.getYears();
        this.months = valuesRequestDto.getMonths();
        this.daysOfMonth = valuesRequestDto.getDaysOfMonth();
        this.daysOfWeek = valuesRequestDto.getDaysOfWeek();
        this.workTime = valuesRequestDto.getWorkTime();
        this.leaveTypesId = leave_types;
    }
}