package com.iKassa.servlets;

import com.iKassa.entity.Car;
import com.iKassa.entity.Inkassator;
import com.iKassa.util.Crud;
import org.json.JSONArray;
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
        resp.setContentType("text/html; charset=windows-1251");
        PrintWriter out = resp.getWriter();
        Inkassator inkassator = new Inkassator();
        Crud crud = new Crud();

        resp.setContentType("text/html;charset=utf-8");
        if (req.getParameter("name") == null) {
            System.out.println("Загружаю инкассаторов");
            try {
                out.println(getAllInkassator());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            String name = req.getParameter("name");
            String surName = req.getParameter("surname");
            String age = req.getParameter("age");
            try {
                inkassator.setName(name);
                inkassator.setSurname(surName);
                inkassator.setAge(age);
                crud.add(inkassator);
                out.println(getAllInkassator());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    private JSONArray getAllInkassator() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

        TypedQuery<Inkassator> namedQuery = entityManager.createNamedQuery("INKASSATOR.getAll", Inkassator.class);
        List<Inkassator> inkassators = namedQuery.getResultList();
        for (Inkassator inkassator: inkassators) {
            jsonObject = new JSONObject();
            jsonObject.put("id", inkassator.getId());
            jsonObject.put("name", inkassator.getName());
            jsonObject.put("surname", inkassator.getSurname());
            jsonObject.put("age", inkassator.getAge());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
