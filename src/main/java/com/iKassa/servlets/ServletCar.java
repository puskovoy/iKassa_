package com.iKassa.servlets;

import com.iKassa.entity.Car;
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
import java.util.Date;
import java.util.List;

@WebServlet("/car")
public class ServletCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=windows-1251");
        PrintWriter out = resp.getWriter();
        Crud crud = new Crud();
        Car car = new Car();

        if (req.getParameter("name") == null) {
            System.out.println("�������� ����!");
            try {
                out.println(getAllCar());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            String name = req.getParameter("name");
            float cost = Float.valueOf(req.getParameter("cost"));
            String number = req.getParameter("number");
            try {
                car.setName(name);
                car.setCost(cost);
                car.setNumber(number);
                car.setReleaseDate(new Date());
                crud.add(car);
                out.println(getAllCar());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    private JSONArray getAllCar() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

        TypedQuery<Car> namedQuery = entityManager.createNamedQuery("CAR.getAll", Car.class);
        List<Car> cars = namedQuery.getResultList();
        for (Car car : cars) {
            jsonObject = new JSONObject();
            jsonObject.put("id", car.getId());
            jsonObject.put("name", car.getName());
            jsonObject.put("cost", car.getCost());
            jsonObject.put("number", car.getNumber());
            jsonObject.put("date", car.getReleaseDate());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
