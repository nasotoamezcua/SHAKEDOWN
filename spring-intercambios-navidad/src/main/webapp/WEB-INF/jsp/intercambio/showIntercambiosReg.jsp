<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>NAVIDAD ::: INTERCAMBIO REGISTRADO</title>
</head>
<body>
	
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Intercambios</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-gift"></span> 
							Intercambios
							<span class="badge">${userIntercambios}</span>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed table-hover table-striped">
								<tr>
									<th>#</th>
									<th>Intercambio</th>
									<th>Imagen</th>
									<th>Eliminar</th>
								</tr>
								<c:choose>
									<c:when test="${not empty listIntercambios}">
										<c:forEach items="${listIntercambios}" var="intercambio" varStatus="i">
											<tr>
												<td>${i.count}</td>
												<td>${intercambio.opcion}</td>
												<td>
													<div class="text-left">
														<c:choose>
															<c:when test="${intercambio.img eq 'no-define'}">
																<span class="glyphicon glyphicon-ban-circle"></span>
															</c:when>
															<c:otherwise>
																<c:url value="/resources/img/intercambios/${usuCap}/${intercambio.img}" var="imgLink"></c:url>
																
																<a  href="${imgLink}" target="_blank" title="Imagen" data-toggle="popover" data-placement="right"
																	data-trigger="hover" data-content="${intercambio.img}" class="btn btn-success btn-sl">
																	<span class="glyphicon glyphicon-picture"></span>
														</a>
															</c:otherwise>
														</c:choose>
													</div>
												</td>
												<td>
													<div class="text-left">
														<a href='<c:url value="/intercambio/deleteIntercambio/${intercambio.id}"/>' class="btn btn-sl btn-danger">
															<span class="glyphicon glyphicon-floppy-remove"></span>
														</a>
								  					</div>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="4">
												<div class="text-center">
													No tienes intercambios registrados
												</div>
											</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
						<div class="text-center">
							<a href='<c:url value="/welcome"/>' class="btn btn-sm btn-primary">OK</a>
							<a href="${now lt dateLimit ? '/spring-intercambios-navidad/intercambio' : '#'}" 
								class="btn btn-sm btn-success ${now lt dateLimit ? '' : 'disabled'}">Registar Intercambio</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<jsp:include page="../home/footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
</body>
</html>