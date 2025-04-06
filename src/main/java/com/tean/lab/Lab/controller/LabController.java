package com.tean.lab.Lab.controller;

import com.tean.lab.Lab.service.FCMService;
import com.tean.lab.Lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/lab")
public class LabController {

    @Autowired
    private UserService userService;

    @Autowired
    private FCMService fcmService;

    @PostMapping("test-not-transaction")
    public Boolean testNotTransaction() {
        userService.save();
        return true;
    }
//
//    @PostMapping("/notification")
//    public void sendNotification(@RequestBody NotificationRequest request) throws ExecutionException, InterruptedException {
//        fcmService.sendPushNotificationService(request);
//    }

}
