package com.tean.lab.Lab.service;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public long getPreparedStatementCount() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory.getStatistics().getPrepareStatementCount();
    }
}