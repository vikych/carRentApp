import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        response.setContentType("text/html");

        if (AuthHelper.isAllowed(uname, pword)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("app");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("authorization_errorpage.html");
            rd.include(request, response);
        }
    }

}
