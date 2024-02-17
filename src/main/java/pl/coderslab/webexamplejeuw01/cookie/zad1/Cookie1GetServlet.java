package pl.coderslab.webexamplejeuw01.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet Cookie1Get ma być dostępny pod adresem /showCookie.
        // Ma wyświetlać zawartość ciasteczka User.
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if ("User".equals(c.getName())) {
                response.getWriter().println("odczytano ciasteczko: " + c.getName() + " : " + c.getValue());
                return;
            }
        }


        response.getWriter().println("brak ciasteczka");
    }
}
