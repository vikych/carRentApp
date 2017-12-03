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

public class Registration extends HttpServlet {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        UserService service = new UserService();

        firstName = req.getParameter("FirstName");
        lastName = req.getParameter("LastName");
        username = req.getParameter("Username");
        password = req.getParameter("Password");
        response.setContentType("text/html");

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);

        if (service.addUser(user)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
            dispatcher.forward(req, response);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("authorization_errorpage.html");
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