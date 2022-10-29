<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="/paginas/comunes/cabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>
	<hr width="100%">
	<br>
	<div class="container">
		<div class="navbar" role="navigation">
			<div class="container-fluid" align="center">
				<div class="navbar-collapse collapse">
					<div class="col-sm-6">
						<form
							action="${pageContext.request.contextPath}/UsuarioServlet?accion=prepararusuario"
							method="post">
							<ul class="nav navbar-nav">
								<li><i class="fa fa-plus-square" style="position: relative; top: -12px;"> <input
										class="w3-btn w3-amber w3-round-small w3-medium" type="submit"
										value="Agregar Nuevo Usuario">
								</i></li>
							</ul>
						</form>
					</div>
					<div>

						<form
							action="${pageContext.request.contextPath}/UsuarioServlet?accion=buscar"
							method="POST">
							<table>
								<tr>
									<th></th>
									<th></th>
								</tr>
								<tr>
									<td><i class="fa fa-bars"> <input
											class="w3-btn w3-amber fa fa-calendar-plus-o w3-round-small w3-medium"
											type="submit" name="accion" value="Buscar usuario"
											style="position: relative; top: -2px;"></i></td>
									<td><input type="text" name="buscar"
										placeholder="ingrese busqueda . . ."
										style="height: 28px; width =200%; position: relative; left: 35px; top: 2px;">
									</td>
								</tr>
							</table>
						</form>
					</div>

				</div>
			</div>
		</div>
		<hr width="100%">
		<div class="w3-row">
			<div class="col-md-12">
				<div id="tablas">
					<h4 class="margin-bottom-15" align="center">Lista de
						Usuarios/Clientes registrados</h4>
					<table class="table table-sm table-dark table-hover">
						<tr>
							<th>Codigos</th>
							<th>Usuarios</th>
							<th>Nombres</th>
							<th>Apellidos</th>
							<th>Distrito</th>
							<th>Direccion</th>
							<th>Correo</th>
							<th>Telefono</th>
							<th>Cargo</th>
							<th>Estado</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="dato" items="${datos}">
							<tr>
								<td>${dato.getIdusuario()}</td>
								<td>${dato.getNombreusuario()}</td>
								<td>${dato.getNombres()}</td>
								<td>${dato.getApellidos()}</td>
								<td>${dato.getNomdistrito()}</td>
								<td>${dato.getDireccion()}</td>
								<td>${dato.getCorreo()}</td>
								<td>${dato.getTelefono()}</td>
								<td>${dato.getCargo()}</td>
								<td>${dato.getEstado()}</td>
								<td>
									<form
										action="${pageContext.request.contextPath}/UsuarioServlet?accion=escoger"
										method="post">
										<input type="hidden" name="cod_usuario"
											value="${dato.getIdusuario()}"><input
											class="w3-btn w3-amber w3-round btn-sm" type="submit"
											value="modificar">
									</form>
								</td>

								<td>
									<form
										action="${pageContext.request.contextPath}/UsuarioServlet?accion=eliminar"
										method="post">
										<input type="hidden" name="cod_usuario"
											value="${dato.getIdusuario()}"><input type="submit"
											class="w3-btn w3-amber w3-round btn-sm" value="eliminar"
											onclick="
										if (confirm('Desea eliminar el usuario??')) 
											form.action='${pageContext.request.contextPath}/UsuarioServlet?accion=eliminar'; 
										else return false;" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div>
		<p>Total Usuarios: ${totalUsuarios}</p>
	</div>
</body>

<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>