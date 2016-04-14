package com.iKassa.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Crud {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Object add(Object object){
        entityManager.getTransaction().begin();
        Object dataFromDB = entityManager.merge(object);
        entityManager.getTransaction().commit();
        return dataFromDB;
    }

    public Object get(long id){
        return entityManager.find(Object.class, id);
    }

    public void delete (long id){
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    public void update(Object object){
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    /*public List<Object> getAll(Object object){
        TypedQuery<Object> namedQuery = entityManager.createNamedQuery("USER.getAll", Object.class);
        return namedQuery.getResultList();
    }*/
}
