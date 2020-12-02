<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Projet LO54</title>
    <meta charset="utf8">
</head>
<body>
    <p><c:forEach var="localisation" items="${ location }"> <c:out value="${localisation.city}"/> </c:forEach></p>
    <p><c:forEach var="cours" items="${ course }"><c:out value="${cours.code }"/><c:out value="${ cours.title}"/> </c:forEach></p>
    <p><c:forEach var="session" items="${ course_session }">
        <c:out value="${session.start_date}"/>
        <c:out value="${session.location.city}"/>
        <c:out value="${session.course.code}"/>
    </c:forEach></p>
    <c:forEach var="utilisateur" items="${ user }"> <c:out value="${utilisateur.id}"/> </c:forEach>
    <p></p>
</body>
</html>
