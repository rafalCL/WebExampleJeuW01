package pl.coderslab.webexamplejeuw01.get.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/get2")
public class Get2 extends HttpServlet {
    // W projekcie stwórz servlet Get2, dostępny pod adresem /get2, który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość (niezależnie od liczby przesłanych parametrów). Wykorzystaj poniższy kod:
    // Map<String, String[]> parameterMap = request.getParameterMap();
    //
    //Przykład:
    //
    //Dla adresu /get2?a=2&b=3&a=12
    //
    //powinniśmy otrzymać:
    //
    //a
    //[2, 12]
    //b
    //[3]
    //
    //dla adresu: /get2?car=audi&user=john&age=33&user=mark powinniśmy otrzymać:
    //
    //car
    //[audi]
    //user
    //[john, mark]
    //age
    //[33]

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            response.getWriter().println(
                    String.format("%s : %s<br>\r\n",
                            entry.getKey(),
                            Arrays.toString(entry.getValue())
                    )
            );
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
}
