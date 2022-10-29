<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="../comunes/cabecera.jsp" />
<!-- HEADER -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario del nuevo
			servicio</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
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
					//document.getElementById("myVAR").innerHTML = d;
					document.getElementById("myVAR2").value = d.trim();
					console.log(d);
				}
			</script>
		</div>
		<!--  -->
		<form
			action="${pageContext.request.contextPath}/ServletServicio?accion=insertar"
			method="POST" class="was-validated">
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Categoría:</td>
						<td><input type="text" id="myVAR2" name="idcat" required
							style="background-color: transparent; background-color: #00BBA8; pointer-events: none;"></td>
						<!-- <td><input type="text" value="myVAR" name="idcat"></td> -->
					</tr>
					<tr>
						<td>Título Servicio:</td>
						<td><input type="text" name="nomservicio" required
							placeholder="nuevo titulo del servicio"></td>
					</tr>
					<tr>
						<td>Precio(S/.):</td>
						<td><input type="number" name="precioservicio" min="0.00"
							max="10000.00" step="0.01" placeholder="0.00" required></td>
					</tr>
				</table>
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Peso(Kg.):</td>
						<td><input type="number" name="pesoreq" min="0.00"
							max="10000.00" step="0.01" placeholder="0.00" required></td>
					</tr>
					<tr>
						<td>Cantidad:</td>
						<td><input type="number" name="cantreq" min="0" max="10000"
							step="1" placeholder="0" required></td>
					</tr>
					<tr>
						<td>Dias de lavado:</td>
						<td><input type="number" name="diasest" min="0" max="10000"
							step="1" placeholder="0" required></td>
					</tr>
					<tr>
						<td>Estado:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							value="chckestado"
							style="position: relative; left: 6px; top: -4px;"> <input
							type="text" name="estadostring" id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%; background-color: #EAB008;pointer-events: none;" required></td>
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