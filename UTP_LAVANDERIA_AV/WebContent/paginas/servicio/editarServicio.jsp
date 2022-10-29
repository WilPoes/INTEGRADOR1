<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- HEADER-->
<jsp:directive.include file="../comunes/cabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>
.non {
	pointer-events: none;
}
</style>
<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario para
			actualizar el servicio</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;"
		align="center">
		<div class="col-sm-12 col-md-4 col-lg-2 col-xl-2">
			<p class="sm">Categorías</p>
			<select onchange="val()" id="selectIdCat" style="background-color: #EAB008;">

				<option>Seleccionar categoria</option>
				<c:forEach var="dato" items="${datos}">
					<option>${dato.getTitulo()}- ${dato.getId()}</option>
				</c:forEach>
			</select>
			<!-- js -->
			<script type="text/javascript">
				function val() {
					var d = document.getElementById("selectIdCat").value;
					n = d.length;
					d = d.substring(n, d.lastIndexOf(' '));
					document.getElementById("myVAR2").value = d.trim();
				}
			</script>
		</div>
		<form
			action="${pageContext.request.contextPath}/ServletServicio?accion=actualizar"
			method="post">
			<div class="col-sm-12 col-md-4 col-lg-2 col-xl-2">
				<p>Categoría actual:</p>
				<input type="text" value="${servicio.getIdcat()}"
					style="width: 30px; background-color: #00BBA8;" disabled="disabled">
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table align="center" class="tablas">
					<tr>
						<td>Id Servicio:</td>
						<td><input type="text" name="idServicio"
							style="pointer-events: none; background-color: #00BBA8;" value="${servicio.getId()}"></td>
					</tr>
					<tr>
						<td>Categoría nueva:</td>
						<td id="myVAR" style="display: none;"></td>
						<td><input type="text" id="myVAR2" name="idCategoria" style="pointer-events: none; background-color: #EAB008;" required></td>
					</tr>
					<tr>
						<td>Título Servicio:</td>
						<td><input type="text" name="nomservicio"
							value="${servicio.getNomservicio()}"></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Precio(S/.):</td>
						<td><input type="number" name="precioservicio"
							value="${servicio.getPrecioservicio()}"></td>
					</tr>
					<tr>
						<td>Peso(Kg.):</td>
						<td><input type="number" name="pesoreq"
							value="${servicio.getPesorequeridoservicio()}"></td>
					</tr>
					<tr>
						<td>Cantidad:</td>
						<td><input type="number" name="cantrequerida"
							value="${servicio.getCantrequeridaservicio()}"></td>
					</tr>
					<tr>
						<td>Dias de lavado:</td>
						<td><input type="number" name="diasestimados"
							value="${servicio.getDiasestimados()}"></td>
					</tr>
					<tr>
						<td>Estado actual actual:</td>
						<td><input type="text" value="${servicio.getEstado()}"
							disabled="disabled" style="background-color: #00BBA8;"></td>
					</tr>
					<tr>
						<td>Estado nuevo:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							name="estado" value="chckestado"
							style="position: relative; left: 4px; top: -4px;"> <input
							type="text" class="non" name="estadostring" id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%; background-color: #EAB008; pointer-events: none;" required></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="accion"
							value="Actualizar servicio" class="btn btn-primary btn-sm"
							onclick="
								if (confirm('Desea modificar el servicio??')) 
									form.action='${pageContext.request.contextPath}/ServletServicio?accion=actualizar'; 
								else return false;"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>

</body>
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

<!-- FOOTER -->
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />

</html>