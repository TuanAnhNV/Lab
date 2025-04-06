package com.tean.lab.Lab.service;

import com.google.firebase.messaging.*;
import com.tean.lab.Lab.entity.NotificationRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FCMService {

//    public void sendMessageToToken(NotificationRequest request)
//            throws InterruptedException, ExecutionException {
//        Message message = getPreconfiguredMessageToToken(request);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonOutput = gson.toJson(message);
//        System.out.println("jsonOutput"+jsonOutput);
//        String response = sendAndGetResponse(message);
//        System.out.println("Sent message to token. Device token: " + request.getToken() + ", " + response+ " msg "+jsonOutput);
//    }
//
//    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
//        return FirebaseMessaging.getInstance().sendAsync(message).get();
//    }
//
//    private Message.Builder getPreconfiguredMessageBuilder(NotificationRequest request) {
//        AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
//        ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
//        Notification notification = Notification.builder()
//                .setTitle(request.getTitle())
//                .setBody(request.getBody())
//                .build();
//        return Message.builder()
//                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(notification);
//    }
//    private ApnsConfig getApnsConfig(String topic) {
//        return ApnsConfig.builder()
//                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
//    }
//
//    private AndroidConfig getAndroidConfig(String topic) {
//        return AndroidConfig.builder()
//                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
//                .setPriority(AndroidConfig.Priority.HIGH)
//                .setNotification(AndroidNotification.builder()
//                        .setTag(topic).build()).build();
//    }
//
//    private Message getPreconfiguredMessageToToken(NotificationRequest request) {
//        return getPreconfiguredMessageBuilder(request).setToken(request.getToken())
//                .build();
//    }
public String sendPushNotificationService(NotificationRequest request) {
    Map<String, String> firebaseMessageBody = new HashMap<>();
    firebaseMessageBody.put("title", request.getTitle());
    firebaseMessageBody.put("body", request.getBody());
    try {
        Message message = Message
                .builder()
                .setToken(request.getToken())
                .putAllData(firebaseMessageBody)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        return response;
    } catch (FirebaseMessagingException e) {
        System.out.println("Firebase error sending: {}"+e);

        return "Firebase error sending";
    }
}
}