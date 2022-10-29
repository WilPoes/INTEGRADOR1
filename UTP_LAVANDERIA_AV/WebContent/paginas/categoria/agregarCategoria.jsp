<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="../comunes/cabecera.jsp" />
<!-- ./comunes/cabecera.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario de la
			nueva categoria</h2>
		<hr>
	</div>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<div class="navbar navbar-default" role="navigation"
			style="font-size: 16px;">
			<div class="container-fluid">
				<form
					action="${pageContext.request.contextPath}/ServletCategoria?accion=insertar"
					method="POST" class="was-validated">
					<table align="center">
						<tr>
							<td style="width: 200px;">Titulo de Categoria:</td>
							<td><input type="text" name="titulo" required></td>
						</tr>
						<tr>
							<td>Descripcion:</td>
							<td><input type="text" name="descripcion" required></td>
						</tr>
						<tr>
							<td>Estado:</td>
							<td><input type="checkbox"
								onchange="matchEstadoBool(this.checked)" id="estado"
								value="chckestado"
								style="position: relative; left: 6px; top: -4px;"> <input
								type="text" name="estadostring" id="estadostring"
								style="position: relative; left: 6px; top: 2px; max-width: 85%; background-color: #EAB008; pointer-events: none;" required></td>
						</tr>
					</table>
					<br>
					<div align="center">
						<table>
							<tr>
								<td></td>
								<td><input type="submit" value="Agregar nueva categoría"
									class="btn btn-primary btn-sm"></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		function matchEstadoBool(checked) {
			const valorestado = document.getElementById('estadostring');
			if (checked == true) {
				valorestado.setAttribute('value', 'activo');
			} else {
				valorestado.setAttribute('value', 'inactivo');
			}
		}
	</script>
</body>
<!-- FOOTER -->
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>