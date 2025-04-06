package com.tean.lab.Lab.service;

import com.tean.lab.Lab.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

import com.tean.lab.Lab.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    @Lazy
//    private UserService self;
//
//    @Autowired
//    private StatisticsService statisticsService;
//
//    public int a = 5;
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void findBYId(Integer id) {
//        User user = userRepository.findById(id).orElse(null);
////        user.setAge("28");
////        try {
////            self.findBYId2(id);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        userRepository.save(user);
////        entityManager.detach(user);
//        System.out.println(user);
////        User user2 = userRepository.findById(id).orElse(null);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void findBYId2(Integer id) {
//        User user = userRepository.findById(2).orElse(null);
//    }
//
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
//    public void testIsolation(Integer id) {
//        User user = userRepository.findById(id).orElse(null);
//        System.out.println(user.toString());
//        entityManager.detach(user);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        User user2 = userRepository.findById(id).orElse(null);
//        System.out.println(user2.toString());
//    }
//
//    public void testIsolation2(Integer id) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        User user = userRepository.findById(id).orElse(null);
//        user.setAge("25");
//        System.out.println("======> saveUser");
//        userRepository.save(user);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //JpaTransactionManager
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void testNotTransaction(Integer id){
//        User user = userRepository.findById(id).orElse(null);
////        user.setCoin(user.getCoin()+1);
////        user.setIsChecked(false);
//        System.out.println("user1"+user.toString());
//
//    }


//    @Transactional()
//    public void testNotTransaction2(Integer id){
//        User user = new User();
//        user.setUsername("tean5");
//        user.setAge("18");
//        user.setCoin(200L);
//        user.setIsChecked(true);
//        User newUser =  userRepository.save(user);
//        entityManager.detach(newUser);
//        self.testNotTransaction(newUser.getId());
//        int a =0;
//        User user2 = userRepository.findById(newUser.getId()).get();
//        System.out.println("user2"+user2.toString());
////        System.out.println("jdbc query: "+ statisticsService.getPreparedStatementCount());;
//    }

//    @Transactional()
//    public void TestUnitOfWork(){
//        this.a = 15;
//    }
//
//    @Transactional()
//    public void TestUnitOfWork2(){
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("======> a= "+a);
//        Integer.parseInt("2a");
//    }
//    @Transactional()
//    public void TestUnitOfWork3(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("======> a= "+a);
//    }

    public String getPhoneNumber() {
        List<User> userList = userRepository.findAll();
        Set set = new HashSet();
        Set setPhone = new HashSet();
        String phoneNumber = "";
        for (int i = 0; i < 4000; i++) {
            int randomNum = (int) (Math.random() * 100000) + 1;
            while (set.contains(randomNum)&&setPhone.contains(userList.get(randomNum).getPhoneNumber())) {
                randomNum = (int) (Math.random() * 100000) + 1;
            }
            set.add(randomNum);
            setPhone.add(userList.get(randomNum).getPhoneNumber());
            phoneNumber += userList.get(randomNum).getPhoneNumber() + ",";
        }
        System.out.println(userList.size());
        System.out.println(set.size());
        System.out.println(phoneNumber);
        return phoneNumber;

//        for(User user : userList){
//            set.add(user.getPhoneNumber());
//        }
//        System.out.println(set.size());
//        return set.size() + "";
    }

    public void save() {
        List<User> userList = new ArrayList<>();
        Random random = new Random();
        Set setPhone = new HashSet();
        Set setCode = new HashSet();
        for (int i = 0; i < 2000000; i++) {
            String number = "84" + String.format("%08d", random.nextInt(100000000));
            while (setPhone.contains(number)) {
                number = "84" + String.format("%08d", random.nextInt(100000000));
            }
            setPhone.add(number);
            for (int j = 0; j < 2; j++) {
                User user = new User();
                user.setPhoneNumber(number);
                // Tạo số điện thoại bắt đầu bằng 84
                String code = String.format("%08d", random.nextInt(100000000));
                while (setCode.contains(code)) {
                    code = String.format("%08d", random.nextInt(100000000));
                }
                setCode.add(code);
                user.setCode(code);
                userList.add(user);
            }
        }
        System.out.println(userList.size());
        System.out.println(setPhone.size());
        System.out.println(setCode.size());
        userRepository.saveAll(userList);
    }

    @Transactional
    public void saveUser(){
        User user = new User();
        user.setPhoneNumber("0399602559");
        user.setCode("abced");
        user.setCreateTime(LocalDate.of(2025, 1, 4));
        userRepository.save(user);
    }

    public void updateUser(){
        User user = userRepository.findByCode("abc");
        user.setPhoneNumber("039960251");
        user.setCode("bdfef");
        userRepository.save(user);
    }

    public void getCountUser(){
        Long count = userRepository.count();
        System.out.println(count);
    }

    public List<User> findByCreateTimeBetween(LocalDate startDate, LocalDate endDate) {
        List<User> userList = userRepository.findByCreateTimeBetween(startDate, endDate);
        System.out.println(userList);
        return userList;
    }
}
