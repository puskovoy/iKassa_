package com.iKassa.util;

import com.iKassa.entity.Car;
import com.iKassa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CrudUser {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public User add(User user){
        em.getTransaction().begin();
        User carFromDB = em.merge(user);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public User get(long id){
        return em.find(User.class, id);
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("USER.getAll", User.class);
        return namedQuery.getResultList();
    }
}
