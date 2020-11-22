<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf8">
</head>
<body>
    <c:forEach var="localisation" items="${ location }"> <c:out value="${localisation}"/> </c:forEach>
    <p></p>
</body>
</html>
