package com.iKassa.servlets;

import com.iKassa.entity.User;
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

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject resultJson = new JSONObject();
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        try {
            TypedQuery<User> namedQuery = entityManager.createNamedQuery("USER.getAll", User.class);
            List<User> users = namedQuery.getResultList();
            for (User user : users) {
                if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                    resultJson.put("isValid", true);
                    break;
                }
                else resultJson.put("isValid", false);
            }
            out.println(resultJson);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
