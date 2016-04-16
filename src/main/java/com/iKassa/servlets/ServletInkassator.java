package com.iKassa.servlets;

import com.iKassa.entity.Inkassator;
import com.iKassa.util.Crud;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private Crud crud = new Crud();
    private Inkassator inkassator = new Inkassator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

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
            String age = req.getParameter("age");
            try {
                inkassator.setName(name);
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
        List<Object> inkassators = crud.getAll("INKASSATOR.getAll");
        for (Object object : inkassators) {
            inkassator = (Inkassator) object;
            jsonObject = new JSONObject();
            jsonObject.put("id", inkassator.getId());
            jsonObject.put("name", inkassator.getName());
            jsonObject.put("age", inkassator.getAge());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
