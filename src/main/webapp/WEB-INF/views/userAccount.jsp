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
</c:url>
</c:forEach>
<form:form  modelAttribute="listMotorization">
<c:forEach var="listMotorization" items="${listMotorization}">
<h1>${listMotorization.title}</h1>
<input type="hidden" path="id"/>
<a href="${update}">Zaktualizuj</a><br/><hr/>
</c:forEach>
</form:form>
<br/>
<br/>
</body>
</html>
