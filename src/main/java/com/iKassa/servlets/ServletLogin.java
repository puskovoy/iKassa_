package com.iKassa.servlets;

import com.iKassa.entity.User;
import com.iKassa.util.CrudCar;
import com.iKassa.util.CrudUser;

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
@WebServlet("/web")
public class ServletLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CrudUser userFromDB = new CrudUser();

        PrintWriter out = resp.getWriter();
        System.out.println("doGet");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        requestDispatcher.forward(req, resp);

        out.println("<h2>Привет Servlet doGet</h2><br> Again");
        List<User> users = userFromDB.getAll();

        //Выводим полученый список авто
        for(User c : users){
            out.println(c);
        }
        out.close();

        /*RequestDispatcher rd = req.getRequestDispatcher(MAIN_PAGE);
        rd.forward(req, resp);*/
        /*LoginBean bean = new LoginBean();

        boolean status = bean.validate(name, password);

        if (status) {
            RequestDispatcher rd = req.getRequestDispatcher(MAIN_PAGE);
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(TEST_PAGE);
            rd.forward(req, resp);
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
