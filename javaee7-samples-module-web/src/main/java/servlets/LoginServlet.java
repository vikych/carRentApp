package servlets;

import com.google.gson.Gson;
import common.AuthenticationHelper;
import common.SessionStore;
import services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SessionScoped
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private SessionStore sessionStore;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("Username");
        String pword = request.getParameter("Password");
        response.setContentType("text/html");

        UserService service = new UserService();

        if (AuthenticationHelper.isAllowed(uname, pword)) {
            sessionStore.setUser(service.getUserByUsername(uname));
            String success = "Success";

            String json = new Gson().toJson(success);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            String failure = "Invalid credentials";

            String json = new Gson().toJson(failure);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
}
