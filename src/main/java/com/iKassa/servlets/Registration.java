package com.iKassa.servlets;

import com.iKassa.entity.User;
import com.iKassa.util.Crud;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg")
public class Registration extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject resultJson = new JSONObject();
        PrintWriter out = resp.getWriter();
        User user = new User();
        Crud crud = new Crud();

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            user.setName(name);
            user.setLogin(login);
            user.setAddres(address);
            user.setEmail(email);
            user.setPassword(password);
            //Записали в БД и вернули с id
            User user1 = (User) crud.add(user);
            //Вывели записанную в БД запись
            System.out.println(user1);
            resultJson.put("stan", user1.getName());
            out.println(resultJson);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
