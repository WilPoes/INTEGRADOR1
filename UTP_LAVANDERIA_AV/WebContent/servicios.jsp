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
			<div class="container-20%" align="center">
				<div class="navbar-collapse collapse">
					<div class="col-sm-6">
						<form
							action="${pageContext.request.contextPath}/ServletServicio?accion=listarcategorias"
							method="POST">
							<i class="fa fa-plus-square"> <input
								class="fa fa-crosshairs fa-lg w3-btn w3-amber w3-round"
								type="submit" value="Agregar servicio">
							</i>
						</form>
					</div>
					<div>
						<form
							action="${pageContext.request.contextPath}/ServletServicio?accion=buscar"
							method="POST">
							<table>
								<tr>
									<th></th>
									<th></th>
								</tr>
								<tr>
									<td><i class="fa fa-bars"> <input
											class="w3-amber fa fa-calendar-plus-o w3-btn w3-round-small w3-medium"
											type="submit" name="accion" value="Buscar servicios"
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
					<h2 class="margin-bottom-15" align="center">Listas de
						Servicios</h2>
					<table class="table table-sm table-dark table-hover">
						<tr>
							<th>ID</th>
							<th>Categoría</th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Peso Requerido</th>
							<th>Cantidad Requerida</th>
							<th>Dias estimados</th>
							<th>Estado</th>
							<th>x</th>
							<th>x</th>
						</tr>
						<c:forEach var="dato" items="${datos}">
							<tr>
								<td>${dato.getId()}</td>
								<td>${dato.getNomidcat()}</td>
								<td>${dato.getNomservicio()}</td>
								<td>${dato.getPrecioservicio()}</td>
								<td>${dato.getPesorequeridoservicio()}</td>
								<td>${dato.getCantrequeridaservicio()}</td>
								<td>${dato.getDiasestimados()}</td>
								<td>${dato.getEstado()}</td>
								<td>
									<form
										action="${pageContext.request.contextPath}/ServletServicio?accion=escoger"
										method="post">
										<input type="hidden" name="idServicio" value="${dato.getId()}"><input
											class="w3-btn w3-amber w3-round btn-sm" type="submit"
											value="modificar">
									</form>
								</td>

								<td>
									<form
										action="${pageContext.request.contextPath}/ServletServicio?accion=eliminar"
										method="post">
										<input type="hidden" name="idServicio" value="${dato.getId()}"><input
											type="submit" class="w3-btn w3-amber w3-round btn-sm"
											value="eliminar"
											onclick="
										if (confirm('Desea eliminar el servicio??')) 
											form.action='${pageContext.request.contextPath}/ServletServicio?accion=eliminar'; 
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
</body>
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>