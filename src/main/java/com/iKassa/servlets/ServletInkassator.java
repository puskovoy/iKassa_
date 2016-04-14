package com.iKassa.servlets;

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
        Inkassator inkassator = new Inkassator();
        Crud crud = new Crud();
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
            System.out.println(name);
            System.out.println(age);
            try {
                inkassator.setName(name);
                inkassator.setAge(age);
                //Записали в БД и вернули с id
                Inkassator inkassator1 = (Inkassator) crud.add(inkassator);
                //Вывели записанную в БД запись
                System.out.println(inkassator1);

                out.println(getAllInkassator());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    private JSONArray getAllInkassator() {
        JSONArray jsonArray = new JSONArray();
        JSONObject object;
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

        TypedQuery<Inkassator> namedQuery = entityManager.createNamedQuery("INKASSATOR.getAll", Inkassator.class);
        List<Inkassator> inkassators = namedQuery.getResultList();
        for (Inkassator inkassator1 : inkassators) {
            object = new JSONObject();
            object.put("id", inkassator1.getId());
            object.put("name", inkassator1.getName());
            object.put("age", inkassator1.getAge());
            jsonArray.put(object);
        }
        return jsonArray;
    }
}
