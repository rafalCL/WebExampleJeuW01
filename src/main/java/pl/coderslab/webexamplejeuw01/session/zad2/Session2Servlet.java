package pl.coderslab.webexamplejeuw01.session.zad2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Session2 dostępny pod adresem /session2.
//
//W metodzie doGet wyświetl formularz z możliwością wpisania oceny.
//Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w liście, którą będziesz wkładać do sesji.
//Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
//Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane po zatwierdzeniu formularza.

@WebServlet("/session2")
public class Session2Servlet extends HttpServlet {
    final static String FORM_TEMPLATE = "<form method='post'>" +
            "Ocena: <input type='number' name='grade'/>" +
            "<input type='submit'/>" +
            "</form>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(FORM_TEMPLATE);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(FORM_TEMPLATE);

        String gradeStr = request.getParameter("grade");
        try {
            int grade = Integer.parseInt(gradeStr);
            HttpSession session = request.getSession();
            List<Integer> grades = (List<Integer>) session.getAttribute("grades");
            if (grades == null) { // if data NOT in session
                grades = new ArrayList<>(); // create list
            }
            grades.add(grade); // add to list
            session.setAttribute("grades", grades); // add to session
            // generate response for client
            response.getWriter().println("Oceny: " + grades.toString());
            // calculate avg
            final double avg = calculateAvg(grades);
            response.getWriter().println("avg=" + avg);
        } catch (NumberFormatException e) {
            response.getWriter().println("Nieprawidlowe dane: " + gradeStr);
        }
    }

    static double calculateAvg(List<Integer> integers) {
        // read: java 8 streams, method references
        final double result = integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        return result;
    }
}
