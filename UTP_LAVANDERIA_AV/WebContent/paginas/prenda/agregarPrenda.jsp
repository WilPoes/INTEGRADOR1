<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<!--  -->
<link rel="stylesheet" type="text/css"
	href="/UTP_LAVANDERIA_AV/css/templatemo_main.css">

<link rel="stylesheet" type="text/css"
	href="/UTP_LAVANDERIA_AV/css/personal/interfaz.css">

<title>Agregar nueva prenda al pedido</title>
</head>
<body>
	<div align="center">
		<h2>Formulario de prendas para el pedido</h2>
	</div>
	<form
		action="${pageContext.request.contextPath}/AddToCartServlet?accion=agregarACarrito"
		method="POST" class="was-validated">
		<table align="center" style="font-size: 14px; font-weight: bold;">
			<tr>
				<td>ID de Prenda:</td>
				<td><input type="text" name="id_prenda" id="id_prenda"
					style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
			</tr>
			<tr>
				<td>Servicios</td>
				<td><select onchange="escogerID()" id="id_servicios">
						<option>Seleccionar servicio</option>
				</select></td>
			</tr>
		</table>
		<diV>
			<div class="col-sm-6 col-md-2 col-lg-2 col-xl-2">
				<table style="font-size: 14px; font-weight: bold;">
					<hr width="100%">
					<tr>
						<td>ID servicio:</td>
						<td><input type="text" id="myVAR2" name="idserv" required
							style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td><input type="text" id="precio" name="precio"
							style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Peso requerido:</td>
						<td><input type="text" name="pesoreq" id="pesoreq"
							style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Cantidad requerida:</td>
						<td><input type="text" name="cantreq" id="cantreq"
							style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
					</tr>
					<tr>
						<td>Dias estimados:</td>
						<td><input type="text" name="diasesti" id="diasesti"
							style="background-color: transparent; background-color: #EAB008; pointer-events: none;"></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-6 col-md-2 col-lg-2 col-xl-2">
				<table style="font-size: 14px; font-weight: bold;">
					<hr width="100%">
					<tr>
						<td>Nombre de Prenda:</td>
						<td><input type="text" name="nomprenda" id="nomprenda"></td>
					</tr>
					<tr>
						<td>Descripcion de Prenda:</td>
						<td><input type="text" name="descprenda" id="descprenda"></td>
					</tr>
					<tr>
						<td>Peso de Prenda:</td>
						<td><input type="number" name="pesoprenda" min="0.00"
							max="10000.00" step="0.01" placeholder="0.00" required></td>
					</tr>
					<tr>
						<td>Cantidad:</td>
						<td><input type="number" name="cantprenda" min="0"
							max="100000" step="1" placeholder="0" required></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="btn btn-primary btn-sm"
							value="Enviar prenda al pedido"></td>
						</form>
						<td><input type="submit" class="btn btn-primary btn-sm"
							value="Regresar" onclick="RefreshParent2()"></td>
					</tr>
				</table>
			</div>
		</diV>
</body>
<script>
//*
function escogerID() {
	var d = document.getElementById("id_servicios").value;
	n = d.length;
	d = d.substring(n, d.lastIndexOf(' '));
	document.getElementById("myVAR2").value = d.trim();
	rellenarInputs(d.trim());
}
function dividirCadena(cadenaADividir,separador) {
	var arrayDeCadenas = cadenaADividir.split(separador);
	return arrayDeCadenas;
}
//*}
	var idprenda = sessionStorage.getItem("send");
	//console.log(idprenda);
	var idnomservicios = sessionStorage.getItem("send2");
	//console.log(idnomservicios);
	var detallesservicios = sessionStorage.getItem("send3");
	//console.log(iddetallesservicios);
	var idIDservicios = sessionStorage.getItem("send4");
	//console.log(idIDservicios);
	//*
	document.getElementById("id_prenda").value = idprenda;
	var coma = ",";
	var espacio = " ";
	var guion = "-";
	//*
	var arrayIDservicio = dividirCadena(idIDservicios, coma);
	console.log(arrayIDservicio.length);
	//
	var arrayCadenaIdNombreservicio = dividirCadena(idnomservicios, coma);
	console.log(arrayCadenaIdNombreservicio.length);
	//
	var arrayDetalles =	dividirCadena(detallesservicios, coma);
	console.log(arrayDetalles[1]);
	var arrayDetalles2 = dividirCadena(arrayDetalles[1], guion);
	console.log(arrayDetalles2);
	//*
	//console.log(".....");
	function rellenarInputs(id){		
		for(var i = 0; i < arrayIDservicio.length; i++){
			if(i == id){
				var string = dividirCadena(arrayDetalles[i], guion);
				//array.push(); precio pesoreq cant diasestimados
				console.log(string);
				var precio = string[0];
				document.getElementById("precio").value = precio.trim();
				var pesoreq = string[1];
				document.getElementById("pesoreq").value = pesoreq.trim();
				var cant = string[2];
				document.getElementById("cantreq").value = cant.trim();
				var diasestimados = string[3];
				document.getElementById("diasesti").value = diasestimados.trim();
				console.log("variables");
				console.log(precio + pesoreq + cant + diasestimados);
			}
		}
	}
	//*
	function redirect() {
		window.location = "${pageContext.request.contextPath}/ServletServicio?accion=insertar";
	}
	//*
	var id_servicios = document.getElementById("id_servicios");
	//*
	for (var i = 0; i < arrayCadenaIdNombreservicio.length; i++) {
		var option = document.createElement("OPTION"), txt = document
				.createTextNode(arrayCadenaIdNombreservicio[i]);
		option.appendChild(txt);
		option.setAttribute("value", arrayCadenaIdNombreservicio[i]);
		id_servicios.insertBefore(option, id_servicios.lastChild);
	}
</script>
</html>