package com.iKassa.servlets;

import com.iKassa.entity.Inkassator;
import org.json.JSONArray;
import org.json.JSONObject;
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

@WebServlet("/inkassator")
public class ServletInkassator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONArray jsonArray = new JSONArray();
        JSONObject object;
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();
        PrintWriter out = resp.getWriter();

        try {
            TypedQuery<Inkassator> namedQuery = entityManager.createNamedQuery("INKASSATOR.getAll", Inkassator.class);
            List<Inkassator> inkassators = namedQuery.getResultList();
            for (Inkassator inkassator : inkassators) {
                object = new JSONObject();
                object.put("id", inkassator.getId());
                object.put("name", inkassator.getName());
                object.put("age", inkassator.getAge());
                jsonArray.put(object);
            }
            out.println(jsonArray);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
