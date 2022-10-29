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
							action="${pageContext.request.contextPath}/ServletProvisita?accion=listarusuarios"
							method="POST">
							<i class="fa fa-plus-square"> <input
								class="fa fa-crosshairs fa-lg w3-btn w3-amber w3-round"
								type="submit" value="Agregar visita">
							</i>
						</form>
					</div>
					<div>
						<form
							action="${pageContext.request.contextPath}/ServletProvisita?accion=buscar"
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
					<h2 class="margin-bottom-15" align="center">Listas de Visitas</h2>
					<table class="table table-sm table-dark table-hover">
						<tr>
							<th>ID</th>
							<th>Conductor</th>
							<th>Detalles</th>
							<th>Fecha de Pedido</th>
							<th>Fecha de Entrega</th>
							<th>Placa</th>
							<th>Estado</th>
							<th>x</th>
							<th>x</th>
						</tr>
						<c:forEach var="dato" items="${datos}">
							<tr>
								<td>${dato.getIdprovisitas()}</td>
								<td>${dato.getNomusuario_conductor()}</td>
								<td>${dato.getDetalles()}</td>
								<td>${dato.getFechapedido()}</td>
								<td>${dato.getFechaentrega()}</td>
								<td>${dato.getPlacavehiculo()}</td>
								<td>${dato.getEstado()}</td>
								<td>
									<form
										action="${pageContext.request.contextPath}/ServletProvisita?accion=escoger"
										method="post">
										<input type="hidden" name="idProvisita" value="${dato.getIdprovisitas()}"><input
											class="w3-btn w3-amber w3-round btn-sm" type="submit"
											value="modificar">
									</form>
								</td>

								<td>
									<form
										action="${pageContext.request.contextPath}/ServletProvisita?accion=eliminar"
										method="post">
										<input type="hidden" name="idProvisita" value="${dato.getIdprovisitas()}"><input
											type="submit" class="w3-btn w3-amber w3-round btn-sm"
											value="eliminar"
											onclick="
										if (confirm('Desea eliminar el servicio??')) 
											form.action='${pageContext.request.contextPath}/ServletProvisita?accion=eliminar'; 
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