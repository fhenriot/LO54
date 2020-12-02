<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<html>
<head>
    <title>Projet LO54</title>
    <meta charset="utf8">
</head>
<body>
<div>
    <c:out value="${session.course.code }"/> <br>
    <c:out value="${session.course.title}"/><br>
    <d:formatDate value="${session.start_date }" pattern="dd/MM/yyyy"/><br>
    <d:formatDate value="${session.end_date }" pattern="dd/MM/yyyy"/><br>
    <c:out value="${session.location.city}"/><br>
    <c:out value="${pourcentage}"/>
</div>
<div>
<form action="/LO54/Inscriptions?id=${session.id}" method="post">
    <div>
        <label for="last_name">Nom :</label>
        <input type="text" id="last_name" name="user_name">
    </div>
    <div>
        <label for="first_name">Prénom :</label>
        <input type="text" id="first_name" name="user_firstname">
    </div>
    <div>
         <label for="address">Adresse complète :</label>
         <input type="text" id="address" name="user_address">
    </div>
    <div>
            <label for="phone">Numéro de téléphone :</label>
            <input type="text" id="phone" name="user_mphone">
        </div>
    <div>
        <label for="mail">e-mail :</label>
        <input type="email" id="mail" name="user_mail">
    </div>
    <div class="button">
        <button type="submit">S inscrire</button>
    </div>
</form>
</div>
</body>
</html>