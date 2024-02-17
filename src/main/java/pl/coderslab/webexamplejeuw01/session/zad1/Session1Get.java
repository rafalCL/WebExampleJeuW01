package pl.coderslab.webexamplejeuw01.session.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz trzy servlety:
//
//Session1Set dostępny pod adresem /session1Set,
//Session1Get dostępny pod adresem /session1Get ,
//Session1Del dostępny pod adresem /session1Del.
//Pierwszy ma ustawiać atrybut sesji pod kluczem counter na 0.
//Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać go o 1. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
//Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem counter).

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać go o 1.
        // Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null) {
            response.getWriter().println("EMPTY");
            return;
        }
        session.setAttribute("counter", ++counter);
        response.getWriter().println("counter=" + counter);
    }
}
