<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zad1</title>
</head>
<body>
<%--Zadanie 1 - rozwiązywane z wykładowcą--%>
<%--W projekcie stwórz stronę first.jsp. Następnie:--%>
<%--za pomocą EL wyświetl zawartość parametru o nazwie km,
 który będzie wpisywany jako parametr w pasku adresu,--%>
<%--przelicz ile to mil (1km = 0.62 mili), a następnie wyświetl wartość.--%>
<p>${param.km}km =${param.km*0.62}mi</p>
</body>
</html>
