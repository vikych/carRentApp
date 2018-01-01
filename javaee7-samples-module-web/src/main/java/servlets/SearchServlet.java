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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/searchCar")
public class SearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarService service = new CarService(em);

        String manufacturer = req.getParameter("Manufacturer");
        String model = req.getParameter("Model");
        String yearSt = req.getParameter("Year");
        String color = req.getParameter("Color");
        if (yearSt.isEmpty()) {
            yearSt = "-1";
        }
        int year = Integer.valueOf(yearSt);

        List<Car> list = service.findAllCars();
        if (year != -1) {
            list = list.stream()
                    .filter(car -> car.getYear() == year)
                    .collect(Collectors.toList());
        }
        if (!model.isEmpty()) {
            list = list.stream()
                    .filter(car -> car.getModel().getModelName().equalsIgnoreCase(model))
                    .collect(Collectors.toList());
        }
        if (!manufacturer.isEmpty()) {
            list = list.stream()
                    .filter(car -> car.getModel().getManufacturerFk().getManufacturerName().equalsIgnoreCase(manufacturer))
                    .collect(Collectors.toList());
        }
        if (!color.isEmpty()) {
            list = list.stream()
                    .filter(car -> car.getColor().equalsIgnoreCase(color))
                    .collect(Collectors.toList());
        }

        String json = new Gson().toJson(list);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
