package servlets;

import com.google.gson.Gson;
import common.DateUtil;
import common.SessionStore;
import entities.Car;
import entities.Rental;
import entities.User;
import services.CarService;
import services.RentalService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SessionScoped
@WebServlet("/carRent")
public class CarRentServlet extends HttpServlet {

    @Inject
    private SessionStore store;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateUtil dateUtil = new DateUtil();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarService carService = new CarService(em);
        RentalService rentalService = new RentalService(em);

        String registrationNumber = req.getParameter("RegistrationNumber");
        String pickUp = req.getParameter("PickUp");
        String dropOff = req.getParameter("DropOff");

        Date pickUpDate = dateUtil.formatDate(pickUp);
        Date dropOffDate = dateUtil.formatDate(dropOff);

        Map<TimeUnit, Long> dateDiff = dateUtil.computeDiff(pickUpDate, dropOffDate);

        Long days = dateDiff.get(TimeUnit.DAYS);

        User user = store.getUser();

        Car car = carService.getCarByRegistrationNumber(registrationNumber);

        Rental rental = new Rental();

        rental.setCarFk(car);
        rental.setPickUpTime(pickUpDate);
        rental.setDropOffTime(dropOffDate);
        rental.setUserFk(user);
        rental.setTotalPrice(car.getPrice() * days.intValue());
        rental.setStatusFk(rentalService.getRentalStatus(2));

        rentalService.save(rental);

        rental.setRentalID(rentalService.createRentalID(rental, car.getCarPk(), user.getUserPk(), days.intValue()));
        em.merge(rental);

        car.setAvailable(false);
        try {
            carService.updateCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<String> success = new ArrayList<>();
        success.add("Rent successfully completed.");
        success.add("Your rent ID is " + rental.getRentalID());
        success.add("Total price for " + days.intValue() + " days: " + rental.getTotalPrice() + "EUR.");
        success.add("Dear " + user.getFirstName() + ",");
        success.add("You can take your car " + "with registration number - " + car.getRegistrationNumber() + " from " +
                "our office at any time, date: " + pickUp);

        String json = new Gson().toJson(success);

        em.close();
        emf.close();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
