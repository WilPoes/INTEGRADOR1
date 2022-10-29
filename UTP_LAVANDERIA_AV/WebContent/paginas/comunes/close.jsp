<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body onLoad="RefreshParent2()">
	<script type="text/javascript">
		function RefreshParent2() {
			if (window.opener != null && !window.opener.closed) {
				window.opener.location.reload();
			}
		}
		window.onbeforeunload = RefreshParent;
	</script>
	<form action="/UTP_LAVANDERIA_AV/index.jsp">
		<input class="w3-amber fa fa-sign-out w3-round-large" type="submit"
			value="Inicio" style="font-size: 13px; margin-top: 13px;">
	</form>

</body>
</html>