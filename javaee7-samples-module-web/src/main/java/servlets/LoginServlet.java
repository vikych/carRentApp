package servlets;

import common.AuthenticationHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        response.setContentType("text/html");

        if (AuthenticationHelper.isAllowed(uname, pword)) {
            response.getWriter().write(uname);
            RequestDispatcher dispatcher = request.getRequestDispatcher("app");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("authorization_errorpage.html");
            dispatcher.include(request, response);
        }
    }
}
