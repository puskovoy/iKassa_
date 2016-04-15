package com.iKassa.servlets;

import com.iKassa.entity.Inkassator;
import com.iKassa.util.Crud;
import org.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/dropAllInkassator")
public class ServletDropAllInkassator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Crud crud = new Crud();
        JSONObject resultJson = new JSONObject();
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();
        PrintWriter out = resp.getWriter();

        try {
            System.out.println("Drop All Inkassators");
            TypedQuery<Inkassator> namedQuery = entityManager.createNamedQuery("INKASSATOR.getAll", Inkassator.class);
            List<Inkassator> inkassators = namedQuery.getResultList();
            for (Inkassator inkassator1 : inkassators) {
                crud.delete(inkassator1, inkassator1.getId());
            }
            resultJson.put("stan", "ok");
            out.println(resultJson);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

