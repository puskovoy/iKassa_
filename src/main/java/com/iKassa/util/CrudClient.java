package com.iKassa.util;

import com.iKassa.entity.Bag;
import com.iKassa.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CrudClient {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Client add(Client client){
        em.getTransaction().begin();
        Client carFromDB = em.merge(client);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Client get(long id){
        return em.find(Client.class, id);
    }

    public void update(Client user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<Client> getAll(){
        TypedQuery<Client> namedQuery = em.createNamedQuery("CLIENT.getAll", Client.class);
        return namedQuery.getResultList();
    }
}
