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
		<h2 class="margin-bottom-15" align="center">Formulario Actualizaciones de Visitas</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;"
		align="center">
		<div class="col-sm-12 col-md-4 col-lg-2 col-xl-2">
			<p class="sm">Usuarios</p>
			<select onchange="val()" id="selectIdUsuario">

				<option>Seleccionar Usuario</option>
				<c:forEach var="dato" items="${datos}">
					<option>${dato.getNombreusuario()}- ${dato.getIdusuario()}</option>
				</c:forEach>
			</select>
			<!-- js -->
			<script type="text/javascript">
				function val() {
					var d = document.getElementById("selectIdUsuario").value;
					n = d.length;
					d = d.substring(n, d.lastIndexOf(' '));
					document.getElementById("myVAR2").value = d.trim();
				}
			</script>
		</div>
		<form
			action="${pageContext.request.contextPath}/ServletProvisita?accion=actualizar"
			method="post">
			<div class="col-sm-12 col-md-4 col-lg-2 col-xl-2">
				<p>Usuario Actual:</p>
				<input type="text" value="${provisita.getIdusuario_conductor()}"
					style="width: 30px;" disabled="disabled">
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table align="center" class="tablas">
					<tr>
						<td>Id Visita:</td>
						<td><input type="text" name="idprovisitas"
							value="${provisita.getIdprovisitas()}"></td>
					</tr>
					<tr>
						<td>Conductor Nuevo: </td>
						<td id="myVAR" style="display: none;"></td>
						<td><input type="text" id="myVAR2" name="idusuario_conductor"></td>
					</tr>
					<tr>
						<td>Detalles:</td>
						<td><input type="text" name="detalles"
							value="${provisita.getDetalles()}"></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Fecha del Pedido:</td>
						<td><input type="text" name="fechapedido"
							value="${provisita.getFechapedido()}"></td>
					</tr>
					<tr>
						<td>Fecha de la Entrega:</td>
						<td><input type="text" name="fechaentrega"
							value="${provisita.getFechaentrega()}"></td>
					</tr>
					<tr>
						<td>Placa de Vehiculo:</td>
						<td><input type="text" name="placavehiculo"
							value="${provisita.getPlacavehiculo()}"></td>
					</tr>
					<tr>
						<td>Estado actual actual:</td>
						<td><input type="text" value="${provisita.getEstado()}"
							disabled="disabled"></td>
					</tr>
					<tr>
						<td>Estado nuevo:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							name="estado" value="chckestado"
							style="position: relative; left: 4px; top: -4px;"> <input
							type="text" class="non" name="estadostring" id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%;"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="accion"
							value="Actualizar servicio" class="btn btn-primary btn-sm"></td>
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