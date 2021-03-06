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
            <c:out value="${pourcentage} %" />
        </div>
        <div>
            <c:if test="${pourcentage<100}">
            <form action="/LO54/Inscriptions?id=${session.id}" method="post">
                <div>
                    <label for="last_name">Nom :</label>
                    <input type="text" id="last_name" minlength="3" name="user_name">
                </div>
                <div>
                    <label for="first_name">Prénom :</label>
                    <input type="text" id="first_name" minlength="3" name="user_firstname">
                </div>
                <div>
                    <label for="address">Adresse complète :</label>
                    <input type="text" id="address" minlength="10" name="user_address">
                </div>
                <div>
                    <label for="phone">Numéro de téléphone :</label>
                    <input type="text" id="phone" pattern="[0-9]{10}" name="user_phone">
                </div>
                <div>
                    <label for="mail">e-mail :</label>
                    <input type="email" id="mail" name="user_mail">
                </div>
                <div class="button">
                    <button type="submit">S inscrire</button>
                </div>
            </form>
            </c:if>
                <c:if test="${pourcentage==100}"> Le cours est plein, essayez en un autre:<a href="/LO54" >Retour à l'accueil</a> </c:if>
        </div>
    </body>
</html>