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
			actualizar al Usuario o Cliente</h2>
		<hr>
	</div>
	<br>
	<br>
	<div class="container" style="font-size: 14px; font-weight: bold;">
		<form
			action="${pageContext.request.contextPath}/UsuarioServlet?accion=actualizar"
			method="post">
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table align="center" class="tablas">
					<tr>
						<td>Id. usuario:</td>
						<td><input type="text" name="cod_usuario"
							value="${usuario.getIdusuario()}"
							style="background-color: #EAB008; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Nombres:</td>
						<td><input type="text" name="nombres"
							value="${usuario.getNombres()}" required></td>
					</tr>
					<tr>
						<td>Apellidos:</td>
						<td><input type="text" name="apellidos"
							value="${usuario.getApellidos()}" required></td>
					</tr>
					<tr>
						<td>Distritos:</td>
						<td><select onchange="val()" id="selectIdCat"
							style="background-color: transparent; background-color: #EAB008; min-height: 8px; max-width: 95%; right: 7px; text-transform: uppercase;">
								<option>Seleccionar distrito</option>
								<c:forEach var="datosdistrito" items="${datosdistrito}">
									<option>${datosdistrito.getNomdistrito()}-
										${datosdistrito.getIddistrito()}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Direccion</td>
						<td><input type="text" name="direccion"
							value="${usuario.getDireccion()}" required></td>
					</tr>
					<tr>
						<td>Correo:</td>
						<td><input type="text" name="correo"
							value="${usuario.getCorreo()}" required></td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td><input type="text" name="telefono"
							value="${usuario.getTelefono()}" required></td>
					</tr>
				</table>
			</div>

			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td>ID Distrito nuevo:</td>
						<td><input type="text" id="myVAR2" name="iddistrito" required
							style="background-color: transparent; background-color: #00BBA8; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Login de usuario actual:</td>
						<td><input type="text" value="${usuario.getNombreusuario()}"
							disabled="disabled" style="background-color: #00BBA8;"></td>
					</tr>
					<tr>
						<td>Cargo Actual:</td>
						<td><input type="text" value="${usuario.getCargo()}"
							disabled="disabled" style="background-color: #EAB008;"></td>
					</tr>
					<tr>
						<td>Estado actual actual:</td>
						<td><input type="text" value="${usuario.getEstado()}"
							disabled="disabled" style="background-color: #EAB008;"></td>
					</tr>
					<tr>
						<td>Estado nuevo:</td>
						<td><input type="checkbox"
							onchange="matchEstadoBool(this.checked)" id="estado"
							value="chckestado"
							style="position: relative; left: 4px; top: -4px; background-color: #EAB008;">
							<input type="text" class="non" name="estadostring"
							id="estadostring"
							style="position: relative; left: 6px; top: 2px; max-width: 85%; background-color: #EAB008; pointer-events: none;"
							required></td>
					</tr>
					<tr>
						<td>Es usuario?</td>
						<td><input type="checkbox" id="chckusuario"
							onchange="showHide(this.checked)" value="chckusuario"
							style="position: relative; left: 4px; top: -4px;"></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 col-xl-2">
				<table>
					<tr>
						<td id="lblidusuario" style="display: none;">Id. de Usuario:</td>
						<td style="position: relative; left: 5px;"><input type="text"
							id="txtidusuario" name="nomusuario"
							style="backgroud-color: #EAB008; display: none;"></td>
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
					<tr>
						<td id="lblcargousuario" style="display: none; top: -20px;">Cargo
							Nuevo del usuario:</td>
						<td id="txtcargousuario"
							style="position: relative; left: 5px; top: -8px; display: none;">
							<select name="cargo"
							style="background-color: transparent; background-color: #EAB008; max-height: 2%; max-width: 72%;">
								<option>cliente</option>
								<option>administrador</option>
								<option>conductor</option>
								<option>asistente</option>
						</select>
						</td>
					</tr>
				</table>
			</div>
			<div align="center">
				<input type="submit" class="btn btn-primary btn-sm" name="accion"
					value="Actualizar nuevo usuario/cliente"
					onclick="
								if (confirm('Desea modificar al usuario')) 
									form.action='${pageContext.request.contextPath}/UsuarioServlet?accion=actualizar'; 
								else return false;">
				<input type="reset" class="btn btn-primary btn-sm" value="Limpiar">
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
				document.getElementById("myVAR2").value = d.trim();
			}
		</script>
		</form>

	</div>
</body>
<!-- FOOTER -->
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>