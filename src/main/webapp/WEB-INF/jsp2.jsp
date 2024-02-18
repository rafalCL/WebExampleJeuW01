<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>zad2 mvc</title>
    <style>
        .dark {
            background-color: darkseagreen;
        }
    </style>
</head>
<body>
<c:if test="${not empty start}">
    <table border="1">
        <tr>
            <th>number</th>
        </tr>
        <c:forEach var="number" begin="${start}" end="${end}" varStatus="stat">
            <tr ${stat.count % 2 == 0 ? "class='dark'" : ""}>
                <td>${number}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
