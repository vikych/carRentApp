package servlets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class MobileCarListServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        JsonObject jsonObject = new JsonParser().parse(request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))).getAsJsonObject();
        UserService userService = new UserService();
        response.getWriter().write(userService.getRentedCarByUsername(jsonObject.get("username").getAsString()).toString());
    }
}
