package servlets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import common.AuthenticationHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class MobileIntegrationServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        JsonObject jsonObject = new JsonParser().parse(request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))).getAsJsonObject();
        JsonObject loggingResult = new JsonObject();
        if (AuthenticationHelper.isAllowed(jsonObject.get("username").getAsString(), jsonObject.get("password").getAsString())) {
            try {
                loggingResult.addProperty("isExisting", true);
                response.getWriter().write(loggingResult.toString());
            } catch (IOException e) {
            }
        } else {
            try {
                loggingResult.addProperty("isExisting", false);
                response.getWriter().write(loggingResult.toString());
            } catch (IOException e) {
            }
        }
    }
}
