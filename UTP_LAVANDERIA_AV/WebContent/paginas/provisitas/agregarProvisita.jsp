<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="../comunes/cabecera.jsp" />
<!-- HEADER -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario de la Nueva Programacion de Visitas</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
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
					//document.getElementById("myVAR").innerHTML = d;
					document.getElementById("myVAR2").value = d.trim();
					console.log(d);
				}
			</script>
		</div>
		<!--  -->
		<form
			action="${pageContext.request.contextPath}/ServletProvisita?accion=insertar"
			method="POST" class="was-validated">
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Usuario: </td>
						<td id="myVAR" style="display: none;"></td>
						<td><input type="text" id="myVAR2" name="idusuario_conductor" required
							style="background-color: transparent; background-color: #ffffff93;"></td>
						<!-- <td><input type="text" value="myVAR" name="idusario"></td> -->
					</tr>
					<tr>
						<td>Detalles Visita: </td>
						<td><input type="text" name="detalles" required
							placeholder="Nuevos Detalles"></td>
					</tr>
					<tr>
						<td>Fecha Pedido: </td>
						<td><input type="text" name="fechapedido" required
							placeholder="Fecha del Pedido"></td>
					</tr>
				</table>
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Fecha Entrega: </td>
						<td><input type="text" name="fechaentrega" required
							placeholder="Fecha del Pedido"></td>
					</tr>
					<tr>
						<td>Placa del Vehiculo </td>
						<td><input type="text" name="placavehiculo" required
							placeholder="Placa del Vehiculo"></td>
					</tr>
					<tr>
						<td>Estado:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							value="chckestado"
							style="position: relative; left: 6px; top: -4px;"> <input
							type="text" name="estadostring" id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%;"></td>
					</tr>
				</table>
			</div>

			<br> <br> <br> <br> <br>

			<div align="center">
				<table>
					<tr>
						<td></td>
						<td><input type="submit" class="btn btn-primary btn-sm"
							value="Agregar nuevo servicio"></td>
					</tr>
				</table>
			</div>
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