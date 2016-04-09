package com.iKassa.util;

import com.iKassa.entity.Route;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 08.04.2016.
 */
public class CrudRoute {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Route add(Route route){
        em.getTransaction().begin();
        Route carFromDB = em.merge(route);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Route get(long id){
        return em.find(Route.class, id);
    }

    public void update(Route user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<Route> getAll(){
        TypedQuery<Route> namedQuery = em.createNamedQuery("ROUTE.getAll", Route.class);
        return namedQuery.getResultList();
    }
}
