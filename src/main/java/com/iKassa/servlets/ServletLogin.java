package com.iKassa.servlets;

import com.iKassa.entity.User;
import com.iKassa.util.CrudUser;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Shevtsov on 028 28.03.16.
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CrudUser userFromDB = new CrudUser();
        JSONObject resultJson = new JSONObject();

        PrintWriter out = resp.getWriter();

        String s = req.getParameter("name");
        String n = req.getParameter("number");

        System.out.println("doGet");
        System.out.println(s + " " + n);

        userFromDB.getAll();
        //Получаем все авто с БД
        List<User> users = userFromDB.getAll();

        //Выводим полученый список авто
        for(User c : users){
            resultJson.put("user", c.getName());
        }

        out.println(resultJson);
        out.close();
    }
}
