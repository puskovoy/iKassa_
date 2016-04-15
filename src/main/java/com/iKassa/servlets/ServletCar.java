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
import java.util.Date;
import java.util.List;

@WebServlet("/car")
public class ServletCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        Crud crud = new Crud();
        PrintWriter out = resp.getWriter();

        if (req.getParameter("name") == null) {
            System.out.println("Загружаю авто");
            try {
                out.println(getAllCar());
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
                car.setName(name);
                car.setCost(50000);
                car.setNumber("AX7777SS");
                car.setReleaseDate(new Date());
                //Записали в БД и вернули с id
                Car car1 = (Car) crud.add(car);
                //Вывели записанную в БД запись
                System.out.println(car1);

                out.println(getAllCar());
                out.close();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    private JSONArray getAllCar() {
        JSONArray jsonArray = new JSONArray();
        JSONObject object;
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

        TypedQuery<Car> namedQuery = entityManager.createNamedQuery("CAR.getAll", Car.class);
        List<Car> cars = namedQuery.getResultList();
        for (Car car1 : cars) {
            object = new JSONObject();
            object.put("id", car1.getId());
            object.put("name", car1.getName());
            object.put("cost", car1.getCost());
            object.put("number", car1.getNumber());
            object.put("date", car1.getReleaseDate());
            jsonArray.put(object);
        }
        return jsonArray;
    }
}
