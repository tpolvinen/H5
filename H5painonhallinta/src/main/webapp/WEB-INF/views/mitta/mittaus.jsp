<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Mittauksen lisääminen</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>
	<h1>
		Luo Mittaus
	</h1>
		<fieldset>
			<form:form modelAttribute="mittaus" method="post">
				
				<p>
					<form:label	path="paino">Paino</form:label><br/>
					<form:input path="paino" cssErrorClass="VirheellinenKentta"/> <form:errors path="paino" cssClass="Virheteksti"/>
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</form:form>
			
			<form:form action="javascript:history.back()">
    			<p><button type="submit">Takaisin edelliseen</button></p>
			</form:form>
			
			<form:form action="../">
    			<p><button type="submit">Takaisin alkuun / "kirjaudu ulos"</button></p>
			</form:form>
		</fieldset>
</body>
</html>