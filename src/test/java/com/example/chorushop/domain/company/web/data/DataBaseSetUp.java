package com.example.chorushop.domain.company.web.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class DataBaseSetUp {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ResourceLoader resourceLoader;

    @Transactional
    public void clean() {
        entityManager.flush();
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;").executeUpdate();

        List<String> results = entityManager.createNativeQuery("show tables").getResultList();
        List<String> tableNames = results;

        tableNames.sort(Collections.reverseOrder());
        for (String tableName : tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
        }

        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;").executeUpdate();
    }
}
