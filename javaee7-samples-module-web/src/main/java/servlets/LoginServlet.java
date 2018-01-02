package servlets;

import common.AuthenticationHelper;
import common.SessionStore;
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
public class LoginServlet extends HttpServlet {

    @Inject
    private SessionStore sessionStore;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        response.setContentType("text/html");

        UserService service = new UserService();

        if (AuthenticationHelper.isAllowed(uname, pword)) {
            sessionStore.setUser(service.getUserByUsername(uname));
            RequestDispatcher dispatcher = request.getRequestDispatcher("app");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("authorization_errorpage.html");
            dispatcher.include(request, response);
        }
    }
}
