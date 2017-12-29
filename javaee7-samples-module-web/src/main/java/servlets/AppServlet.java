package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // request attributes to be sent to JSP
        String username = null;

        try {
            // set username value
            username = request.getParameter("username");

            // set username as request attribute
            request.setAttribute("tusername", username);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // forward request (along with its attributes) to the status JSP
        RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
        rd.forward(request, response);
    }
}
