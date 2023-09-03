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
<!--<c:if test="${not empty validator}"><p><c:out value="${validator}"/></p></c:if>-->
<form:form method="post" modelAttribute="motorization">
 <table>
 <tbody>
 <tr><td><label for="title">Title:</label></td>
 <td><form:input path="title" id="title"/></td></tr>
 <tr>
 <td><label for="price">Price:</label></td>
 <td><form:input path="price" id="price"/>
</td>
 </tr>
 <tr>
 <td><label for="year">Year:</label></td>
 <td><form:input path="year" id="year" /></td>
 </tr>
 <tr>
  <td><label for="description">Description:</label></td>
  <td><form:textarea lang="2" rows="5" cols="20" path="description" id="description" /></td>
  </tr>
  <tr>
   <td><label for="color">Color:</label></td>
   <td><form:input path="color" id="color" /></td>
   </tr>
   <tr><td><label for="brand">Mark:</label></td>
   <td><form:select path="brand" ><form:options items="${brands}"></form:options></form:select></td>
 </tr>
 <tr><td><form:select path="type"><form:option value="kombi"></form:option><form:option value="sedan"></form:option></form:select></td></tr>
 <td>

 <button type="submit">dodaj ogłoszenie motoryzacyjne</button>
 </td>
 </tr>
 </tbody>
 </table>
</form:form>
<a href="${pageContext.request.contextPath}/conto" > return </a>
<a href="${pageContext.request.contextPath}/login">spraw</a>
</body>
</html>