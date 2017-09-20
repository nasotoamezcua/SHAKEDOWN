<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
	
	<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
	
	<c:forEach begin="1" end="3" varStatus="js">
		<script type="text/javascript">
			$(document).ready(function() {
				$('#idTable${js.count}').DataTable({
					"aLengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
			        "iDisplayLength": 5
				});
			} );
		</script>
	</c:forEach>
	

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
					<c:choose>
						<c:when test="${tab.count eq 1}">
							<c:set var="fondoRuta" value="success"/>
						</c:when>
						<c:when test="${tab.count eq 2}">
							<c:set var="fondoRuta" value="info"/>
						</c:when>
						<c:otherwise>
							<c:set var="fondoRuta" value="warning"/>
						</c:otherwise>
					</c:choose>
					<div class="table-responsive">
						<table id="idTable${tab.count}" class="table table-condensed table-hover table-striped">
							<thead>
								<tr class="${fondoRuta}">
									<td colspan="3" align="center">
										<b>Zona ${tab.count}</b>
									</td>
								</tr>
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
												<td>
													<fmt:formatDate value="${zona.fecha}" type="date" dateStyle="short"/>
												</td>
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
						<hr>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
		</div>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>