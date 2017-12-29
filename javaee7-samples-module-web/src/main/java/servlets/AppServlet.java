package servlets;

import common.JPAUtil;
import entities.*;
import services.CarService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
        rd.include(request, response);


        JPAUtil util = null;
        try {
            util = new JPAUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarService service = new CarService(em);

        em.getTransaction().begin();

        Manufacturer manufacturer = new Manufacturer("audi");
        Model model = new Model(manufacturer, "name");
        VehicleType vehicleType = new VehicleType("name");
        Transmission transmission = new Transmission( "name");

        Car car = service.createCar("lv-0001", model, 1999,
                vehicleType, transmission, "red", 200, null, true);

        em.persist(manufacturer);
        em.persist(model);
        em.persist(vehicleType);
        em.persist(transmission);
        em.persist(car);

        em.getTransaction().commit();


        System.out.println("Persisted " + car);

        try {
            if (util != null) {
                util.checkData("select * from Car");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        em.close();
        emf.close();
    }
}
