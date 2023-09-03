<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h1>
 Jestes na swoim koncie!
</h1>


<c:forEach var="listMotorization" items="${listMotorization}">
<c:url  var="update" value="/userAccountToUpdate"><c:param name="MotorizationId" value="${listMotorization.id}"/>
</c:url></c:forEach>


<form:form  modelAttribute="listMotorization">
<table>
<c:forEach var="listMotorization" items="${listMotorization}">
<tr><td>${listMotorization.title}</td><td>${listMotorization.color}</td>
<td><input type="hidden" path="id"/></td><td>
<a href="${update}">update</a></td></tr>
</c:forEach>
</table>

</form:form>
</body>
</html>
