<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Kirjautuminen</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>
	<h1>
		Käyttäjän kirjautuminen
	</h1>
		<fieldset>
			<form:form modelAttribute="kayttaja" method="post">
				
<!-- 				Kommentoin tämän pois koska se näkyy aina eikä vain tarvittaessa: -->
<!-- 				<spring:hasBindErrors name="kayttaja"> -->
<!-- 					<p class="Virheotsikko">Jotain vialla:</p> -->
<%-- 					<div class="Virheblokki"><form:errors path="*"/></div> --%>
<!-- 				</spring:hasBindErrors> -->
				
				<p>
					<form:label	path="nimi">Käyttäjän nimi</form:label><br/>
					<form:input path="nimi" value="Otto" cssErrorClass="VirheellinenKentta"/> <form:errors path="nimi" cssClass="Virheteksti"/>
				</p>
				<p>
					<form:label	path="salasana">Salasana</form:label><br/>
					<form:input path="salasana" value="opettaja" cssErrorClass="VirheellinenKentta"/> <form:errors path="salasana" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<button type="submit">Kirjaudu</button>
				</p>
				
			</form:form>
			<form:form action="../">
    			<button type="submit">Takaisin alkuun / "kirjaudu ulos"</button>
			</form:form>
		</fieldset>
		
</body>
</html>