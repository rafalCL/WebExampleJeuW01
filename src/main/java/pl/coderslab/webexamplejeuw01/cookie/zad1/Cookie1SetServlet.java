package pl.coderslab.webexamplejeuw01.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class Cookie1SetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet Cookie1Set ma być dostępny pod adresem /setCookie.
        // Ma nastawiać ciasteczko o nazwie User na CodersLab, z ważnością 24h.
        Cookie cookie = new Cookie("User", "CodersLab");
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        response.getWriter().println("zapisano ciasteczko!");
    }
}
