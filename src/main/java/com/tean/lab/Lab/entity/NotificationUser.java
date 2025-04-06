package com.tean.lab.Lab.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "notification_user", schema = "common")
@Data
public class NotificationUser {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String content;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "created_at")
  private Long createdAt ;

  @Column(name = "updated_at")
  private Long updatedAt ;
}
