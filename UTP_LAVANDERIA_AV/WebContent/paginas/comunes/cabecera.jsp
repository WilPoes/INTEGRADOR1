<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>UTP SIS Lavandería</title>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

</head>
<body>
	<div class="navbar navbar-default" role="navigation"
		style="padding-top: 8px;">
		<div class="container-fluid">
			<div class="navbar-collapse collapse">
				<nav class="navbar-nav mr-auto">
					<i class="w3-dark-grey w3-hover-light-green fa fa-home w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form action="/UTP_LAVANDERIA_AV/index.jsp">
							<input class="w3-amber fa fa-sign-out w3-round-large"
								type="submit" value="Inicio"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-shopping-basket w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form
							action="${pageContext.request.contextPath}/ServletPrenda?accion=contartodos"
							method="POST">
							<input class="w3-amber fa fa-pencil-square-o w3-round-large"
								type="submit" name="accion" value="Pedidos"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i class="w3-dark-grey w3-hover-light-green fa fa-car w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form
							action="${pageContext.request.contextPath}/ServletProvisita?accion=listarprovisitatodos"
							method="POST">
							<input class="w3-amber fa fa-car w3-round-large" type="submit"
								name="accion" value="Visitas"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-pencil-square-o w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form
							action="${pageContext.request.contextPath}/ServletServicio?accion=listarserviciocategoria"
							method="POST">
							<input class="w3-amber fa fa-pencil-square-o w3-round-large"
								type="submit" name="accion" value="Servicios"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-object-group w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form
							action="${pageContext.request.contextPath}/ServletCategoria?accion=listar"
							method="POST">
							<input class="w3-amber fa fa-object-group w3-round-large"
								type="submit" name="accion" value="Categorias"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-address-book w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form
							action="${pageContext.request.contextPath}/UsuarioServlet?accion=listar"
							method="POST">
							<input class="w3-amber fa fa-address-book w3-round-large"
								type="submit" name="accion" value="Usuarios"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-file-pdf-o w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form action="/UTP_LAVANDERIA_AV/reportes.jsp">
							<input class="w3-amber fa fa-file-pdf-o w3-round-large"
								type="submit" name="accion" value="Reportes"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-id-card-o w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form action="/UTP_LAVANDERIA_AV/login.jsp">
							<input class="w3-amber fa fa-id-card-o w3-round-large"
								type="submit" name="accion" value="Ingresar"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i> <i
						class="w3-dark-grey w3-hover-light-green fa fa-sign-out w3-xlarge"
						style="line-height: 1px; color: green; border: 1px solid green; border-radius: 20px; width: 110px; padding-top: 24px;">
						<form action="/UTP_LAVANDERIA_AV/login.jsp">
							<input class="w3-amber fa fa-sign-out w3-round-large"
								type="submit" value="Salir"
								style="font-size: 13px; margin-top: 13px;">
						</form>
					</i>
				</nav>
			</div>
		</div>
	</div>
</body>