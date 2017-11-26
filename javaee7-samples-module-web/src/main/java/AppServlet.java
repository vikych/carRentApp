import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
        rd.include(request, response);

//        PrintWriter out = response.getWriter();
//        String uname = request.getParameter("username");
//        out.print("Hello " + uname);
//        out.close();

    }
}
