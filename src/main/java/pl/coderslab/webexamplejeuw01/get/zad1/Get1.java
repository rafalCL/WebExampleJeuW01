package pl.coderslab.webexamplejeuw01.get.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");

        if (startStr == null || endStr == null) {
            response.getWriter().println("BRAK");
            return;
        }

        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);

        for (int i = start; i<=end; i++) {
            response.getWriter().println(i + "<br>\r\n");
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
}
