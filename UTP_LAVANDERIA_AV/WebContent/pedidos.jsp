<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:directive.include file="/paginas/comunes/cabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.scrollit {
	overflow: scroll;
	height: 280px;
	width: 580px;
	background-color: white;
	border: 1px solid;
}
</style>
<html>
<body>
	<!-- AGREGAR CLIENTE -->
	<hr width="100%">
	<div align="center">
		<div align="center">
			<h2>
				<p class="w3-amber">NUEVO PEDIDO</p>
			</h2>
		</div>
	</div>
	<hr>
	<br>
	<div align="center" >
		<div class="col-sm-12 col-md-2 col-lg-6 col-xl-2" style="font-size: 16px; font-weight: bold;">
			<div id="texto" style="font-size: 16px; font-weight: bold;">
				<p>
					Cliente* <select onchange="val()" id="selectIdCliente" style="position: relative; left: 4px; top: -4px; background-color: #EAB008;">
						<option>Seleccionar Cliente</option>

						<c:forEach var="datocliente" items="${datoscliente}">
							<option>${datocliente.getNombres()}-${datocliente.getApellidos()}-${datocliente.getCod_cliente()}</option>
						</c:forEach>
					</select>
				</p>
			</div>
		</div>

		<div class="col-sm-12 col-md-2 col-lg-4 col-xl-2">
			<!-- AGREGAR PRENDA CON SERVICIO-->

				<div class="d-grid gap-6" style="padding-left: 22px; font-size: 16px; font-weight: bold;" id="texto">
					<div class="p-2 bg-light border">
						<li><i class="fa fa-calendar-plus-o"> <a
								href="./paginas/prenda/agregarPrenda.jsp"
								class="w3-amber w3-btn w3-round-small w3-medium"
								onClick="window.open(this.href,'targetWindow',
					`toolbar=no,
					location=no,
					status=no,
					menubar=no,
					scrollbars=yes,
					resizable=yes,
					width=860,
					height=480`);
					return false;">
									Agregar prenda</a> <input type="text" value="${id_prenda}"
								id="id_prenda" onclick="checkServicios()" style="display: none;">
						</i></li>
						<table align="center" style="font-size: 14px; font-weight: bold;">
							<tr>
								<c:forEach var="datosservicio" items="${datosservicio}">
									<td><input type="text" name="array[]"
										value="${datosservicio.getNomservicio()} ${datosservicio.getId()}"
										style="display: none;" /><br></td>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach var="datosservicio" items="${datosservicio}">
									<td><input type="text" name="array3[]"
										value="${datosservicio.getId()}"
										style="display: none;" /><br></td>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach var="datosservicio" items="${datosservicio}">
									<td><input type="text" name="array2[]"
										value="${datosservicio.getPrecioservicio()}-${datosservicio.getPesorequeridoservicio()}-${datosservicio.getCantrequeridaservicio()}-${datosservicio.getDiasestimados()}"
										style="display: none;" /><br></td>
								</c:forEach>
							</tr>
						</table>
					</div>
				</div>
		</div>
	</div>
	<!-- PRENDAS AGREGADAS -->
	<DIV align="center">
		<div class="col-sm-6 col-md-2 col-lg-6 col-xl-2">
			<div style="padding-left: 2px;" align="center">
				<table style="font-size: 12px; font-weight: bold;">
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td style="max-width: 350px;">
							<h4 class="w3-amber">DETALLES DE LA ORDEN DEL PEDIDO</h4>
						</td>
						<td></td>
						<td style="left: 5px; padding-left: 15px;"><input
							placeholder="buscar prenda . . ."
							style="padding-left: 4px; width: 120px;"></td>
						<td></td>
						<td style="left: 5px; padding-left: 15px;"><input
							type="submit" value="buscar"></td>
					</tr>
					<hr>
				</table>
				<hr>
			</div>
		</div>

		<div class="col-sm-6 col-md-2 col-lg-4 col-xl-2">
			<div class="scrollit">
				<table class="table table-sm table-dark table-hover"
					style="font-size: 13px; font-weight: bold;">
					<tr>
						<th>ID.</th>
						<th>Nombre de Prenda</th>
						<th>Descripcion</th>
						<th>Peso</th>
						<th>Cantidad</th>
						<th>Servicio</th>
					</tr>
					<c:forEach var="dato" items="${datos}">
						<tr>
							<td style="line-height: 8px;">${dato.getIdprenda()}</td>
							<td style="line-height: 8px;">${dato.getNomprenda()}</td>
							<td style="line-height: 8px;">${dato.getDescprenda()}</td>
							<td style="line-height: 8px;">${dato.getPesoprenda()}</td>
							<td style="line-height: 8px;">${dato.getCantidadprenda()}</td>
							<td style="line-height: 8px;"></td>
							<td>
								<form
									action="${pageContext.request.contextPath}/ServletPrenda?accion=eliminar"
									method="post">

									<input type="hidden" name="idCategoria"
										value="${dato.getIdprenda()}"><input type="submit"
										class="w3-btn w3-amber w3-round btn-sm" value="quitar"
										style="padding: 2px 2px; line-height: 6px;"
										onclick="
										if (confirm('Desea quitar la prenda??')) 
											form.action='${pageContext.request.contextPath}/ServletPrenda?accion=eliminar'; 
										else return false;" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</DIV>
	<!-- TOTAL -->
	<div>
		<div class="d-grid gap-6" style="width: 30%; padding-left: 22px;"
			align="center">
			<div class="p-2 bg-black border">
				<h4>EL CARGO DEL SERVICIO / TOTAL</h4>
				<table class="table table-sm table-dark table-hover">
					<tr>
						<th>IDPedDetalles</th>
						<th>IdPedido</th>
						<th>Cantidad Total de Prendas</th>
						<th>Peso Total</th>
						<th>Precio Total</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script>
//*
var var1;
var1 = document.getElementById("id_prenda").value;
console.log(var1);
//*****
var input = document.getElementsByName('array[]');
var arrayServs =[];
capturarEnArray(input, arrayServs);
//*
var input2 = document.getElementsByName('array2[]');
var arrayDetallesServicios =[];
capturarEnArray(input2, arrayDetallesServicios);
//*
var input3 = document.getElementsByName('array3[]');
var arrayIDServicios =[];
capturarEnArray(input3, arrayIDServicios);
//*
function capturarEnArray(input, array){
	for (var i = 0; i < input.length; i++) {
	    var a = input[i].value;
	    array.push(a);
	    console.log(array[i]);
	}
}
//*
sessionStorage.setItem("send", var1);
sessionStorage.setItem("send2", arrayServs);
sessionStorage.setItem("send3", arrayDetallesServicios);
sessionStorage.setItem("send4", arrayIDServicios);
</script>
<jsp:directive.include file="/paginas/comunes/piedepagina.jsp" />
</html>