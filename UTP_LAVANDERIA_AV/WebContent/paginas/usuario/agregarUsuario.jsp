<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- HEADER -->
<jsp:directive.include file="/paginas/comunes/cabecera.jsp" />
<!--  -->
<style>
input[type=checkbox]+label {
	display: circle;
	cursor: pointer;
}
</style>

<body>
	<div>
		<hr>
		<h2 class="margin-bottom-15" align="center">Formulario del Nuevo
			Usuario/Cliente</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<form
			action="${pageContext.request.contextPath}/UsuarioServlet?accion=insertar"
			method="POST" class="was-validated">
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table align="center">
					<tr>
						<td>Nombres:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							name="nombres" required></td>
					</tr>
					<tr>
						<td>Apellidos:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							name="apellidos" required></td>
					</tr>
					<tr>
						<td>Distritos:</td>
						<td><select onchange="val()" id="selectIdCat"
							style="background-color: transparent; background-color: #EAB008; min-height: 8px; max-width: 95%; right: 7px; text-transform: uppercase;">
								<option>Seleccionar distrito</option>
								<c:forEach var="datosdistrito" items="${datosdistrito}">
									<option>${datosdistrito.getNomdistrito()}- ${datosdistrito.getIddistrito()}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>ID Distrito</td>
						<td><input type="text" id="myVAR2" name="iddistrito" required
							style="background-color: transparent; background-color: #00BBA8;  pointer-events: none;" ></td>
					</tr>
					<tr>
						<td>Direccion:</td>
						<td style="position: relative; left: 5px; top: 4px;"><input
							type="text" name="direccion" required></td>
					</tr>
				</table>
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>Correo:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							name="correo" required></td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							name="telefono" required></td>
					</tr>
					<tr>
						<td>Estado:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							value="chckestado"
							style="position: relative; left: 6px; top: -4px;"> <input
							type="text" name="estadostring" id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%; pointer-events: none; background-color: #EAB008;" required></td>
					</tr>
					<tr>
						<td>Es trabajador?</td>
						<td><input type="checkbox" id="chckusuario"
							onchange="showHide(this.checked)" value="chckusuario"
							style="position: relative; left: 6px; top: -4px;" /></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td id="lblcargousuario" style="display: none; top: -20px;">Cargo
							del usuario:</td>
						<td id="txtcargousuario"
							style="position: relative; left: 5px; top: -8px; display: none;">
							<select name="cargo"
							style="background-color: transparent; background-color: #ffffff93; max-height: 2%; max-width: 72%;">
								<option>cliente</option>
								<option>administrador</option>
								<option>conductor</option>
								<option>asistente</option>
						</select>
						</td>
					</tr>
					<tr>
						<td id="lblidusuario" style="display: none;">Id. de Usuario:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							id="txtidusuario" name="nomusuario" style="display: none;"></td>
					</tr>
					<tr>
						<td id="lblpassusuario" style="display: none;">Contraseña:</td>
						<td style="position: relative; left: 5px;"><input
							type="password" id="txtpassusuario" name="pass"
							style="display: none;"></td>
					</tr>
					<tr>
						<td id="lblpassusuario2" style="display: none;">Verificar
							contraseña:</td>
						<td style="position: relative; left: 5px;"><input
							type="password" id="txtpassusuario2" name="pass2"
							style="display: none;"></td>
					</tr>
				</table>
			</div>
			<div align="center">
				<input type="submit" class="btn btn-primary btn-sm"
					value="Agregar nuevo usuario/cliente"> <input type="reset"
					class="btn btn-primary btn-sm" value="Limpiar">
			</div>
		</form>
		<script>
			function showHide(checked) {
				if (checked == true) {
					$("#lblcargousuario").fadeIn();
					$("#txtcargousuario").fadeIn();
					$("#lblidusuario").fadeIn();
					$("#txtidusuario").fadeIn();
					$("#lblpassusuario").fadeIn();
					$("#txtpassusuario").fadeIn();
					$("#lblpassusuario2").fadeIn();
					$("#txtpassusuario2").fadeIn();

					const txtidusuario = document
							.getElementById('txtidusuario');
					const txtpassusuario = document
							.getElementById('txtpassusuario');

					txtidusuario.setAttribute('required', '');
					txtpassusuario.setAttribute('required', '');
				} else {
					$("#lblcargousuario").fadeOut();
					$("#txtcargousuario").fadeOut();
					$("#lblidusuario").fadeOut();
					$("#txtidusuario").fadeOut();
					$("#lblpassusuario").fadeOut();
					$("#txtpassusuario").fadeOut();
					$("#lblpassusuario2").fadeOut();
					$("#txtpassusuario2").fadeOut();

					txtidusuario.removeAttribute('required');
					txtpassusuario.removeAttribute('required');
				}
			}
			//similar pwd
			function matchPassword() {
				var pass = document.getElementById("pass");
				var pass2 = document.getElementById("pass2");
				if (pass != pass2) {
					alert("Contraseñas no son similares");
				} else {
					alert("Contraseñas son similares / Usuario creado exitosamente");
				}
			}
			function matchEstadoBool(checked) {
				const valorestado = document.getElementById('estadostring');
				if (checked == true) {
					valorestado.setAttribute('value', 'activo');
				} else {
					valorestado.setAttribute('value', 'inactivo');
				}
			}
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
</body>
<!-- FOOTER -->
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>