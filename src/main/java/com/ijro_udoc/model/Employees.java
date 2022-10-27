package com.ijro_udoc.model;

import com.ijro_udoc.model.dto.EmployeesRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at = null;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at = null;

    @Column(name = "birth_date")
    private LocalDate birth_date;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "fired_date")
    private LocalDate fired_date;

    @Column(name = "hired_date")
    private LocalDate hired_date;

    @Column(name = "home_phone", length = 255)
    private String home_phone;

    @Column(name = "mobile_phone", length = 255)
    private String mobile_phone;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "office_phone", length = 255)
    private String office_phone;

    @Column(name = "patronymic", length = 255)
    private String patronymic;

    @Column(name = "photo", length = 255)
    private String photo;

    @Column(name = "pin", length = 255)
    private String pin;

    @Column(name = "surname", length = 255)
    private String surname;

    @Column(name = "telegram", length = 255)
    private String telegram;

    @Column(name = "card_number", length = 255)
    private String card_number;

    @Column(name = "gender", length = 255)
    private String gender;

    @Column(name = "marital", length = 255)
    private String marital;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "passport_expiry")
    private LocalDate passport_expiry;

    @Column(name = "passport_serial", length = 255)
    private String passport_serial;

    @Column(name = "read_responsibility", nullable = false)
    private Boolean read_responsibility;

    @Column(name = "read_responsibility_at")
    private LocalDate read_responsibility_at;

    @Column(name = "has_deadline", nullable = false)
    private Boolean has_deadline;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @ManyToOne
    @JoinColumn(name = "employment_type_id")
    private Employment_type employment_typeId;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Offices officeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Positions positionId;

    public Employees() {
    }

    public Employees(
            EmployeesRequestDto body,
            Departments departmentId,
            Employment_type employment_typeId,
            Offices officeId,
            Users userId,
            Positions positionId
            ){
        this.fired_date = body.getFired_date();
        this.hired_date = body.getHired_date();
        this.birth_date = body.getBirth_date();
        this.deadline = body.getDeadline();
        this.passport_expiry = body.getPassport_expiry();
        this.read_responsibility_at = body.getRead_responsibility_at();
        this.id = body.getId();
        this.created_at = body.getCreated_at();
        this.deleted = body.getDeleted();
        this.email = body.getEmail();
        this.home_phone = body.getHome_phone();
        this.mobile_phone = body.getMobile_phone();
        this.name = body.getName();
        this.office_phone = body.getOffice_phone();
        this.patronymic = body.getPatronymic();
        this.photo = body.getPhoto();
        this.pin = body.getPin();
        this.surname = body.getSurname();
        this.telegram = body.getTelegram();
        this.card_number = body.getCard_number();
        this.gender = body.getGender();
        this.marital = body.getMarital();
        this.passport_serial = body.getPassport_serial();
        this.read_responsibility = body.getRead_responsibility();
        this.has_deadline = body.getHas_deadline();
        this.employment_typeId = employment_typeId;
        this.officeId = officeId;
        this.userId = userId;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }
}
