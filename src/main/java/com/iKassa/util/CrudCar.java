package com.iKassa.util;

import com.iKassa.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CrudCar {
    public EntityManager em = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

    public Car add(Car car){
        em.getTransaction().begin();
        Car carFromDB = em.merge(car);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete (long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Car get(long id){
        return em.find(Car.class, id);
    }

    public void update(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
        em.close();
    }

    public List<Car> getAll(){
        TypedQuery<Car> namedQuery = em.createNamedQuery("CAR.getAll", Car.class);
        return namedQuery.getResultList();
    }
}
