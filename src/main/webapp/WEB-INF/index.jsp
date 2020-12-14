<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<html>
<head>
    <title>Projet LO54</title>
    <meta charset="utf8">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Formation</th>
                <th>Date</th>
                <th>Lieu</th>
                <th>Inscription</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="session" items="${ sessions }">
                <tr>
                     <td>
                        <c:out value="${session.course.code }"/> - <c:out value="${ session.course.title}"/>
                     </td>
                    <td>
                        <d:formatDate value="${session.start_date }" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <c:out value="${session.location.city}"/>
                    </td>
                    <td>
                        <a href="/LO54/Inscriptions?id=${session.id}">Inscription</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
