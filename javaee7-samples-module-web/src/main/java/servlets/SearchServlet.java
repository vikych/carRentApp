package servlets;

import com.google.gson.Gson;
import entities.Car;
import services.CarService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchCar")
public class SearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarService service = new CarService(em);

        List<Car> list = new ArrayList<>();

        String manufacturer = req.getParameter("Manufacturer");
        String model = req.getParameter("Model");
        String yearSt = req.getParameter("Year");
        String color = req.getParameter("Color");
        int year = -1;
        if (!yearSt.isEmpty()) {
            year = Integer.valueOf(yearSt);
        }

        for (Car car : service.findAllCars()) {
            if (car.getYear() == year
                    || car.getModel().getModelName().equalsIgnoreCase(model)
                    || car.getModel().getManufacturerFk().getManufacturerName().equalsIgnoreCase(manufacturer)
                    || car.getColor().equalsIgnoreCase(color)) {
                list.add(car);
            }
        }
        String json;
        if (manufacturer.isEmpty() && model.isEmpty() && color.isEmpty() && yearSt.isEmpty()) {
            json = new Gson().toJson(service.findAllCars());
        } else {
            json = new Gson().toJson(list);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
