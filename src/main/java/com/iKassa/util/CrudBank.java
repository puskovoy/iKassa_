package com.iKassa.util;

import com.iKassa.entity.Bank;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 08.04.2016.
 */
public class CrudBank {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Bank add(Bank bank){
        em.getTransaction().begin();
        Bank carFromDB = em.merge(bank);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Bank get(long id){
        return em.find(Bank.class, id);
    }

    public void update(Bank car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
        em.close();
    }

    public List<Bank> getAll(){
        TypedQuery<Bank> namedQuery = em.createNamedQuery("CAR.getAll", Bank.class);
        return namedQuery.getResultList();
    }
}
