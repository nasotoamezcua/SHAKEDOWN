<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHAKEDOWN ::: EVENTOS</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Shakedown ::: Eventos</h1>
			<p>These are the users currently in the system.</p>
		</div>
		
		<c:choose>
			<c:when test="${not empty listaReportesDTO}">
				<c:forEach items="${listaReportesDTO}" var="listaDTO" varStatus="tab">
					<div class="table-responsive">
						<table class="table table-condensed table-hover">
							<thead>
								<tr><th>Zona ${tab.count}</th></tr>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<th>Fecha</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty listaDTO}">
										<c:forEach items="${listaDTO}" var="zona" varStatus="z" >
											<tr>
												<td>${z.count}</td>
												<td>${zona.nombre}</td>
												<td>${zona.fecha }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
											<tr>
												<td colspan="3" align="center"><b>No existen rutas</b></td>
											</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
				</div>
				</c:forEach>
			</c:when>
		</c:choose>
	</div>
	<jsp:include page="footer.jsp"/>

</body>
</html>