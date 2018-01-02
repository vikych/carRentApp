package servlets;

import common.SessionStore;
import entities.User;
import services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SessionScoped
public class RegistrationServlet extends HttpServlet {

    @Inject
    private SessionStore sessionStore;

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
            try {
                req.setAttribute("tusername", username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sessionStore.setUser(service.getUserByUsername(username));
            RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
            dispatcher.forward(req, response);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("registration_errorpage.html");
            dispatcher.forward(req, response);
        }
    }

}