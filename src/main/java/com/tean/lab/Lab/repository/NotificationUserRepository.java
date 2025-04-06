package com.tean.lab.Lab.repository;

import com.tean.lab.Lab.entity.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationUserRepository extends JpaRepository<NotificationUser, UUID> {
}
