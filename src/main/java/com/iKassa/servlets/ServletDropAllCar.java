package com.iKassa.servlets;

import com.iKassa.entity.Car;
import com.iKassa.util.Crud;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/dropAllCar")
public class ServletDropAllCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Crud crud = new Crud();
        JSONObject resultJson = new JSONObject();
        PrintWriter out = resp.getWriter();

        try {
            System.out.println("Drop All Car");
            List<Object> cars = crud.getAll("CAR.getAll");
            for (Object object : cars) {
                Car car = (Car) object;
                crud.delete(car, car.getId());
            }
            resultJson.put("stan", "ok");
            out.println(resultJson);
            out.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}