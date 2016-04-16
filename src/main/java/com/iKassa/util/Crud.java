package com.iKassa.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Crud {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Object add(Object object){
        entityManager.getTransaction().begin();
        Object dataFromDB = entityManager.merge(object);
        entityManager.getTransaction().commit();
        return dataFromDB;
    }

    public Object get(Object object, long id){
        return entityManager.find(object.getClass(), id);
    }

    public void delete (Object object, long id){
        entityManager.getTransaction().begin();
        entityManager.remove(get(object, id));
        entityManager.getTransaction().commit();
    }

    public void update(Object object){
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    public List<Object> getAll(String query){
        TypedQuery<Object> namedQuery = entityManager.createNamedQuery(query, Object.class);
        return namedQuery.getResultList();
    }
}
