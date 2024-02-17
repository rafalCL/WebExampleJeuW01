package pl.coderslab.webexamplejeuw01.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCookie")
public class Cookie1DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet Cookie1Del ma być dostępny pod adresem /deleteCookie ma kasować ciasteczko o nazwie User.
        // Jeżeli nie ma takiego ciasteczka, to powinien wyświetlić się napis: BRAK.
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if ("User".equals(c.getName())) {
                response.getWriter().println("server odesalal prośbę o usunięcie ciasteczka: " + c.getName() + " : " + c.getValue());
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
                return;
            }
        }

        response.getWriter().println("BRAK");
    }
}
