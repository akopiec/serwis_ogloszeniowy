<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
 <title>Rejestracja</title>
</head>
<body>
<nav>
 <div >
 <a href="${pageContext.request.contextPath}">Strona główna</a>
 </div>
</nav>
<h3>Rejestracja</h3>
<c:if test="${not empty validator}"><p><c:out value="${validator}"/></p></c:if>
<form:form method="post" modelAttribute="motorization">
 <table>
 <tbody>
 <tr><td><label for="title">Tytuł:</label></td>
 <td><form:input path="title" id="title"/></td></tr>
 <tr>
 <td><label for="price">Price:</label></td>
 <td><form:input path="price" id="price"/>
</td>
 </tr>
 <tr>
 <td><label for="year">Rok produkcji:</label></td>
 <td><form:input path="year" id="year" /></td>
 </tr>
 <tr>
  <td><label for="description">Opis:</label></td>
  <td><form:textarea lang="2" rows="5" cols="20" path="description" id="description" /></td>
  </tr>
  <tr>
  <td><label for="color">Kolor:</label></td>
  <td><form:input path="color" id="color" /></td>
  </tr>
  <tr><td><label for="brand">Marka samochodu:</label></td>
  <td><form:select path="brand" ><form:option value="Audi"></form:option><form:option value="BMW">
  </form:option><form:option value="Mercedes"></form:option></form:select></td>
 </tr>
 <tr><td><label for"type">Rodzaj nadwozia:</label></td><td><form:select path="type"><form:option value="kombi"></form:option>
 <form:option value="sedan"></form:option></form:select></td></tr>
 <td>
<button type="submit">dodaj ogłoszenie motoryzacyjne</button>
 </td>
 </tr>
 </tbody>
 </table>
</form:form>
<a href="${pageContext.request.contextPath}/userAccount" >Konto uzytkownika </a>
<a href="${pageContext.request.contextPath}/login">zaloguj</a>
</body>
</html>