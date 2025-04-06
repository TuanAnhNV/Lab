package com.tean.lab.Lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tean.lab.Lab.entity.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByCode(String code);

    List<User> findByCreateTimeBetween(LocalDate createTimeAfter, LocalDate createTimeBefore);

}
