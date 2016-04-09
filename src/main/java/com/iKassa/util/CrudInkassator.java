package com.iKassa.util;

import com.iKassa.entity.Inkassator;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CrudInkassator {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Inkassator add(Inkassator inkassator){
        em.getTransaction().begin();
        Inkassator carFromDB = em.merge(inkassator);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Inkassator get(long id){
        return em.find(Inkassator.class, id);
    }

    public void update(Inkassator user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<Inkassator> getAll(){
        TypedQuery<Inkassator> namedQuery = em.createNamedQuery("INKASSATOR.getAll", Inkassator.class);
        return namedQuery.getResultList();
    }
}
