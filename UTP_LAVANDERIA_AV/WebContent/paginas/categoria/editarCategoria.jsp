<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="../comunes/cabecera.jsp" />
<!-- ./comunes/cabecera.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario para
			Actualizar Categoría</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<form
			action="${pageContext.request.contextPath}/ServletCategoria?accion=actualizar"
			method="post">
			<table align="center" class="tablas">
				<tr>
					<td>idCategoría:</td>
					<td><input type="text" name="id" style ="background-color: #00BBA8; pointer-events: none;" value="${categoria.getId()}"></td>
				</tr>
				<tr>
					<td>Titulo:</td>
					<td><input type="text" name="titulo"
						value="${categoria.getTitulo()}"></td>
				</tr>
				<tr>
					<td>Descripcion:</td>
					<td><input type="text" name="descripcion"
						value="${categoria.getDescripcion()}"></td>
				</tr>
				<tr>
					<td>Estado actual actual:</td>
					<td><input type="text" value="${categoria.getEstado()}"
						disabled="disabled" style="background-color: #00BBA8;"></td>
				</tr>
				<tr>
					<td>Estado nuevo:</td>
					<td><input type="checkbox"
						onchange="matchEstadoBool(this.checked)" id="estado" name="estado"
						value="chckestado"
						style="position: relative; left: 4px; top: -4px;"> <input
						type="text" class="non" name="estadostring" id="estadostring"
						style="position: relative; left: 6px; top: 2px; max-width: 85%; background-color: #EAB008; pointer-events: none;" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="accion"
						value="Actualizar categoría" class="btn btn-primary btn-sm"
						onclick="
								if (confirm('Desea modificar la categoria?')) 
									form.action='${pageContext.request.contextPath}/ServletCategoria?accion=actualizar'; 
								else return false;"></td>
				</tr>
			</table>
		</form>
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