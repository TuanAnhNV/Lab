package com.tean.lab.Lab.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "\"user\"")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="code", updatable = false)
    private String code;

    @Column(name="create_time")
    private LocalDate createTime;
}
