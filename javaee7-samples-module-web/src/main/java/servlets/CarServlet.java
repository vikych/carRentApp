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

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    private CarService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        service = new CarService(em);
        List<Car> list = service.findAllCars();

        String json = new Gson().toJson(list);

        resp.setContentType("application/json");

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
