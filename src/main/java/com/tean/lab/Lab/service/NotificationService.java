package com.tean.lab.Lab.service;

import com.github.javafaker.Faker;
import com.tean.lab.Lab.entity.NotificationUser;
import com.tean.lab.Lab.repository.NotificationUserRepository;
import com.tean.lab.Lab.until.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

  @Autowired
  NotificationUserRepository notificationUserRepository;

  public void saveNotification() {
    Faker faker = new Faker();
    List<NotificationUser> notificationUsers = new ArrayList<>();
    int day = 0;
    for (int i = 0; i < 1000000; i++) {
      NotificationUser notificationUser = new NotificationUser();
      notificationUser.setContent(faker.name().name());
      notificationUser.setPhoneNumber(faker.phoneNumber().phoneNumber());
      notificationUser.setCreatedAt(Helper.getNowMillisAtUtc() + day);
      notificationUser.setUpdatedAt(Helper.getNowMillisAtUtc() + day);
      notificationUsers.add(notificationUser);

      day += 86400000;
    }
    notificationUserRepository.saveAll(notificationUsers);

  }
}
