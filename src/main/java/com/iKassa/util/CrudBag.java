package com.iKassa.util;

import com.iKassa.entity.Bag;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CrudBag {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Bag add(Bag bag){
        em.getTransaction().begin();
        Bag carFromDB = em.merge(bag);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Bag get(long id){
        return em.find(Bag.class, id);
    }

    public void update(Bag user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<Bag> getAll(){
        TypedQuery<Bag> namedQuery = em.createNamedQuery("BAG.getAll", Bag.class);
        return namedQuery.getResultList();
    }
}
