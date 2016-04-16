package com.iKassa.testing;

import com.iKassa.entity.Bag;
import com.iKassa.entity.Inkassator;
import com.iKassa.entity.User;
import com.iKassa.util.Crud;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class MainTest {
    EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();
    @Test
    public void testJson() {

        /*TypedQuery<Inkassator> namedQuery = (TypedQuery<Inkassator>) findWithName("Andrey");
        List<Inkassator> inkassators = namedQuery.getResultList();
        for (Inkassator inkassator1 : inkassators) {
            System.out.println(inkassator1);
        }*/
        /*TypedQuery<Bag> namedQuery = entityManager.createNamedQuery("BAG.getAll", Bag.class);
        List<Bag> bags = namedQuery.getResultList();
        for (Bag bag : bags) {
            System.out.println(bag.toString());
        }*/

    }

    public List findWithName(String name) {
        return entityManager.createQuery(
                "SELECT c FROM Inkassator c WHERE c.name LIKE :custName")
                .setParameter("custName", name)
                .getResultList();
    }
}

