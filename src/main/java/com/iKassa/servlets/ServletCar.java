package com.iKassa.servlets;

import com.iKassa.entity.Car;
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
import java.util.Date;
import java.util.List;

@WebServlet("/car")
public class ServletCar extends HttpServlet {
    private Crud crud = new Crud();
    private Car car = new Car();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        List<Object> cars = crud.getAll("CAR.getAll");
        for (Object object : cars) {
            car = (Car) object;
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
