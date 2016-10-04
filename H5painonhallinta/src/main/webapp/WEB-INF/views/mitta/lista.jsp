<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Lista: kaikki mittaukset</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">

</head>	
<body>

	<h1>Lista!</h1>
<!-- 	<div id="contentbox"> -->
	<fieldset>
<!-- 	<div class="tableDiv"> -->
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>paino</th>
					<th>pvm</th>
				</tr>
				<c:forEach var="data" items="${mittauslista}">
					<tr>
						<td>${data.id}</td>
						<td>${data.paino}</td>
<%-- 						<td>${data.pvm}</td> --%>
						<td><fmt:formatDate value="${data.pvm}" pattern="dd.MM.YYYY"/></td>
					</tr>
				</c:forEach>
		</table>
		
		<form:form action="../mittaukset/uusimittaus" method="get">
   			<p><button type="submit">Uusi mittaus</button></p>
		</form:form>
		<form:form action="javascript:history.back()">
   			<p><button type="submit">Takaisin edelliseen</button></p>
		</form:form>
		
		<form:form action="../">
   			<p><button type="submit">Takaisin alkuun / "kirjaudu ulos"</button></p>
		</form:form>
	</fieldset>
<!-- 	</div> -->
	
</body>
</html>