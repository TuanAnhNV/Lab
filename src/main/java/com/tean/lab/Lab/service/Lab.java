package com.tean.lab.Lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class Lab implements ApplicationRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private NotificationService notificationService;

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Integer userId = 1;
//
//        Thread thread1 = new Thread(()->{
//           userService.testIsolation(userId);
//        });
//        Thread thread2 = new Thread(()->{
//           try{
//               userService.testIsolation2(userId);
//           }catch (Exception e){
//               try {
//                   Thread.sleep(3000);
//               } catch (InterruptedException ex) {
//                   throw new RuntimeException(ex);
//               }
//               System.out.println("======> saveError");
//           }
//        });
//        thread1.start();
//        thread2.start();

  /// /        userService.findBYId(userId);
//    }
  public static boolean isNumeric(String str) {
    if (str == null || str.trim().isEmpty()) {
      return false;
    }

    try {
      Double.parseDouble(str.trim());
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    userService.saveUser();
    LocalDate startDate = LocalDate.of(2025, 1, 1);
    LocalDate endDate = LocalDate.of(2025, 1, 9);

    userService.findByCreateTimeBetween(startDate, endDate);
//    isNumeric("");
//    Integer userId = 1;
//        Thread thread1 = new Thread(()->{
//           userService.testNotTransaction(userId);
//        });
//        Thread thread2 = new Thread(()->{
//           try{
//               userService.testNotTransaction2(userId);
//           }catch (Exception e){
//               try {
//                   Thread.sleep(3000);
//               } catch (InterruptedException ex) {
//                   throw new RuntimeException(ex);
//               }
//               System.out.println("======> saveError");
//           }
//        });
//        thread1.start();
//        thread2.start();
//        userService.testNotTransaction2(userId);
//        userService.getPhoneNumber();

//        userService.save();

//        userService.getSign();
//        Map<String, List<String>> newTasksByEvent = new HashMap<>();
//        if(!newTasksByEvent.containsKey("aaaa")){
//            newTasksByEvent.put("aaaa", new ArrayList<>());
//        }
//        List<String> list = newTasksByEvent.get("aaaa");
//        list.add("abcderfasd");
//        System.out.println(newTasksByEvent);


//        LocalDate today = LocalDate.now();
//        LocalDate date = LocalDate.from(today);
//        int daysToAdd = (5 - date.getDayOfWeek().getValue() + 7) % 7;
//        if (daysToAdd == 0) {
//            daysToAdd = 7; // Nếu hôm nay là thứ Sáu, lấy thứ Sáu tiếp theo
//        }
//        System.out.println("Hôm nay: " + date.plusDays(daysToAdd));
    // Tạo một TemporalAdjuster tùy chỉnh để lấy ngày thứ Sáu tiếp theo
//        TemporalAdjuster nextFriday = new TemporalAdjuster() {
//            @Override
//            public Temporal adjustInto(Temporal temporal) {
//                LocalDate date = LocalDate.from(temporal);
//                int daysToAdd = (5 - date.getDayOfWeek().getValue() + 7) % 7;
//                if (daysToAdd == 0) {
//                    daysToAdd = 7; // Nếu hôm nay là thứ Sáu, lấy thứ Sáu tiếp theo
//                }
//                return date.plusDays(daysToAdd);
//            }
//        };
//
//        LocalDate nextFridayDate = today.with(nextFriday);
//
//        System.out.println("Hôm nay: " + today);
//        System.out.println("Ngày thứ Sáu tiếp theo: " + nextFridayDate);

//        LocalDate today = LocalDate.now();
//
//        // Tạo một TemporalAdjuster để lấy ngày thứ Hai trước đó hoặc cùng ngày
//        LocalDate previousOrSameMonday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
//
//        System.out.println("Hôm nay: " + today);
//        System.out.println("Ngày thứ Hai trước đó hoặc cùng ngày: " + previousOrSameMonday);

//        LocalDate date = LocalDate.now();
//        System.out.println(date.getLong(ChronoField.EPOCH_DAY));
//        System.out.println(date.getLong(ChronoField.PROLEPTIC_MONTH));
////        System.out.println(date.getYear());
//        TemporalUnit unit = ChronoUnit.MONTHS;
//        System.out.println("sssssssssss"+unit.getDuration().toMillis());
//
//        LocalDateTime dateTime = DateTimeUtils.toLocalDateTime(1728972663924L);
//        System.out.println(dateTime.getLong(ChronoField.EPOCH_DAY));
//        userService.saveUser();
//        userService.updateUser();
//        userService.getCountUser();
//        notificationService.saveNotification();
  }

  //    public String methodTest(){
//        List<String> strs = Arrays.asList("ab","sd");
//        strs.forEach(str ->{
//            if(!str.equals("sd")){
//                return;
//            }
//            System.out.println(str);
//        });
//        return "a";
//    }
}
