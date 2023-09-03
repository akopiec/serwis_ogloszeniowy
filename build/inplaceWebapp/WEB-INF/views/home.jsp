
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h1 style="text-align:center; background: yellow;">Witamy na stronie z ogłoszeniami <em>OLZ.pl</em>
</h1>
<a href="/">
</br></br></br>
<table style="margin: 0 auto;border"><tr><td><p><a style="font-family:Verdana;color: green" href="doMotoryzacji">Przejdź do ogłoszeń Motoryzacyjnych</a></p></td>
<td><p><a style="font-family:Verdana;color: red" href="doNieruchomosci">Przejdź do ogłoszeń z Nieruchomościami</a></p></td>
</tr></table>
<p><a style="font-family:Verdana" href="doMotoryzacji"></a></p>
<p><a href="${pageContext.request.contextPath}/userAccount">Konto użytkownika</a></p>
<p><a href="${pageContext.request.contextPath}/login">Zaloguj</a></p>
<p><a href="${pageContext.request.contextPath}/logout">Wyloguj</a></p>
<p><a href="${pageContext.request.contextPath}/addAdvertisementMotorization">Dodaj ogłoszenie</a></p>
<p><a href="${pageContext.request.contextPath}/searchCars">Wyszukaj samochody</a></p>
<p><a href="${pageContext.request.contextPath}/register">Zaluż konto uzytkownika</a></p>
</body>
</html>
