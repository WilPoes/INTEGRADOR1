<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="/paginas/comunes/cabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso de Usuarios</title>
</head>
<body>
<div style="font-size: 14px; font-weight: bold;">
	<form action="${pageContext.request.contextPath}/ServletLogin" method="POST" align="center">
		Ingrese usuario: <input type="text" name="uname" required><br>
		Ingrese Contraseña: <input type="password" name="pass" required><br>
		<input type="submit" name="submit" value="Ingresar" class="btn btn-primary btn-sm">
		<input type="reset" value="Limpiar" class="btn btn-primary btn-sm">
	</form>
</div>
</body>

<jsp:directive.include file="/paginas/comunes/piedepagina.jsp"/>
</html>