package com.iKassa.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Validation {
    public static boolean checkUser(String login, String password) {
        boolean st = false;
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();
            Query namedQuery = entityManager.createQuery("from User where login = :paramNameLogin and password = :paramNamePassword");
            namedQuery.setParameter("paramNameLogin", login);
            namedQuery.setParameter("paramNamePassword", password);
            List obj = namedQuery.getResultList();
            System.out.println(obj.isEmpty());
            st = obj.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
