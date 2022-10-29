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
					<ul class="nav navbar-nav">
						<li><i class="fa fa-calendar-plus-o"> <a
								href="./paginas/cliente/agregarCliente.jsp"
								class="w3-amber  w3-btn w3-round-small w3-medium">Agregar Cliente</a>
						</i></li>
						<li>
							<form
								action="${pageContext.request.contextPath}/ServletCliente?accion=listar"
								method="POST">
								<i class="fa fa-bars"> <input
									class="w3-amber fa fa-calendar-plus-o w3-btn w3-round-small w3-medium"
									type="submit" name="accion" value="Listar clientes"></i>
							</form>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<hr width="100%">
		<div class="w3-row">
			<div class="col-md-12">
				<div id="tablas">
					<h4 class="margin-bottom-15" align="center">Listas de
						Clientes registrados</h4>
					<table class="table table-sm table-dark table-hover">
						<tr>
							<th>CODCliente</th>
							<th>Nombres</th>
							<th>Apellidos</th>
							<th>Direccion</th>
							<th>Correo</th>
							<th>Telefono</th>
						</tr>
						<c:forEach var="dato" items="${datos}">
							<tr>
								<td>${dato.getCod_cliente()}</td>
								<td>${dato.getNombres()}</td>
								<td>${dato.getApellidos()}</td>
								<td>${dato.getCorreo()}</td>
								<td>${dato.getTelefono()}</td>
								<td>
									<form
										action="${pageContext.request.contextPath}/ServletCliente?accion=modificar"
										method="post">
										<input type="hidden" name="cod_cliente"
											value="${dato.getCod_cliente()}"><input
											class="fa fa-pencil-square-o fa-lg w3-btn w3-amber w3-round"
											type="submit" value="modificar">
									</form>
								</td>

								<td>
									<form
										action="${pageContext.request.contextPath}/ServletCliente?accion=eliminar"
										method="post">
										<input type="hidden" name="cod_cliente"
											value="${dato.getCod_cliente()}"><input
											class="fa fa-crosshairs fa-lg w3-btn w3-amber w3-round"
											type="submit" value="eliminar">
										<input type="hidden" name="cod_cliente"
											value="${dato.getCod_cliente()}">
										<input type="submit" value="eliminar" 
										onclick="
										if (confirm('Are you sure you want to delete?')) 
											form.action='${pageContext.request.contextPath}/ServletCliente?accion=eliminar'; 
										else return false;"/>
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
	<p>Total Categorias: ${totalCategorias}</p>
	</div>
</body>

<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>