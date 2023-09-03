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
<form:form method="post" modelAttribute="additionalClass" >
<table><tbody>
<tr>
<td><label>Cena</label></td>
<td><label>od</label>

<form:input path="motorizationFirst.price" id="motorizationFirst.price"/><label>do</label>

<form:input path="motorizationSecond.price" id="motorizationSecond.price"/></td></tr>
<tr><td><label>Rok produkcji</label></td><td><label>od</label><form:input path="motorizationFirst.year" id="motorizationFirst.year" />
<label>do</label>
<form:input path="motorizationSecond.year" id="motorizationSecond" /></td></tr>
<tr><td><label for="type">Typ nadwozia</label></td><td><form:select path="motorizationFirst.type" name="nadwozie" id="nadwozie">
<form:option value="wszystkie"></form:option><form:option value="kombi">
</form:option><form:option value="sedan">
</form:option></form:select></td></tr>
<tr><td><label>Kolor</label></td><td><form:select path="motorizationFirst.color" value="kolor">
<form:option value="wszystkie"></form:option><form:option value="czerwony">czerwony</form:option><form:option value="zielony">zielony</form:option></form:select></td></tr>
<tr><td><label>Marka</label></td><td><form:select path="motorizationFirst.brand">
<form:option value="Audi"></form:option><form:option value="BMW">
</form:option><form:option value="Mercedes"></form:option></form:select></td></tr>
<tr><td><button type="submit" >Szukaj</button></td></tr></tbody></table>
</form:form>
<c:if test="${not empty validator_of_price}"><p style="color:red" ><c:out value="${validator_of_price}"/></p></c:if>
<c:if test="${not empty validator_of_year}"><p style="color:red"><c:out value="${validator_of_year}"/></p></c:if>
<c:forEach var="listOfMotorization" items="${listOfMotorization}">
<h1>${listOfMotorization.title}</h1><br/><h4>${listOfMotorization.description}</h4><br/><p>Rok produkcji :</p><h3>${listOfMotorization.year}</h3>
<p>Cena wynosi:</p><h3>${listOfMotorization.price}<h3><br/>
<p>Typ nadwozia to:</p><h3>${listOfMotorization.type}</h3>
<hr/>
</c:forEach></tr>
<p><a href="/serwis_ogloszeniowy/">wroc do strony glownej</a></p>
</body>
</html>