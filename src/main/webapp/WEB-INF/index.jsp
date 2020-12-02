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
        <body>
        <c:forEach var="cours" items="${ course }">
            <c:forEach var="session" items="${ cours.sessions }">
                <tr>
                     <td>
                        <c:out value="${cours.code }"/> - <c:out value="${ cours.title}"/>
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
        </c:forEach>
        </tbody>
    </table>
    <p></p>
</body>
</html>
