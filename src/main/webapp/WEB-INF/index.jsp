<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<html>
<head>
    <title>Projet LO54</title>
    <meta charset="utf8">
</head>
<body>
    <h2>Ajoutez des filtres à vos recherches !</h2>
      <div>
        <form id ="filterForm" action="" method="post">
          <div>
          <label for="keyWord">Mot clé</label>
            <input type="text" id="keyWord" name="keyWord" onchange="document.getElementById('filterForm').submit();console.log(this.value);">
          </div>
          <div>
            <label for="date">Date</label>
            <input type="date" id="date" name="dateStart" onchange="document.getElementById('filterForm').submit();console.log(this.value);">
          </div>
          <div>
            <label for="city">Ville</label>
            <select name="city" id="city" onchange="document.getElementById('filterForm').submit();console.log(this.value);">
                         <option value="" disabled selected >Sélectionnez une ville</option>
              <c:forEach var="ville" items="${location}">
                <option value="<c:out value='${ville.id}' />"><c:out value="${ville.city}" /></option>
              </c:forEach>
            </select>
          </div>
        </form>
      </div>
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
