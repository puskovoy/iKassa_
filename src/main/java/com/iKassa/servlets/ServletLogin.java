package com.iKassa.servlets;

import com.iKassa.entity.User;
import com.iKassa.util.Validation;
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
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject resultJson = new JSONObject();
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        try {
            if (Validation.checkUser(name,password)){
                resultJson.put("isValid", false);
            } else {
                resultJson.put("isValid", true);
            }
            out.println(resultJson);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
