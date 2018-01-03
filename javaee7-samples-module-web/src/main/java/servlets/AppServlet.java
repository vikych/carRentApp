package servlets;

import com.google.gson.Gson;
import common.SessionStore;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SessionScoped
@WebServlet("/app")
public class AppServlet extends HttpServlet {

    @Inject
    private SessionStore sessionStore;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String json = new Gson().toJson(sessionStore.getUser().getUsername());

        response.setContentType("application/json");

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
