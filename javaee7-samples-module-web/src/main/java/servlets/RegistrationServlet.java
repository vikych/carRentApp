package servlets;

import com.google.gson.Gson;
import common.SessionStore;
import entities.User;
import services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SessionScoped
@WebServlet("/registration")
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
            sessionStore.setUser(service.getUserByUsername(username));
            String success = "Success";

            String json = new Gson().toJson(success);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            String failure = "Username already exists";

            String json = new Gson().toJson(failure);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

}