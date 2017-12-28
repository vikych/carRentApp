package servlets;

import entities.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        UserService service = new UserService();

        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        String email = req.getParameter("Email");
        response.setContentType("text/html");

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        if (service.addUser(user)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.html");
            dispatcher.forward(req, response);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("registration_errorpage.html");
            dispatcher.forward(req, response);
        }
    }

    private Date convertStringToDate(String strDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;

        try {
            d = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date(d.getTime());
    }

}