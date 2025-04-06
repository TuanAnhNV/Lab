package com.tean.lab.Lab.entity;

import lombok.Data;

@Data
public class NotificationRequest {
    private String title;
    private String body;
    private String topic;
    private String token;
}
