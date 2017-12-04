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
			<h1>Intercambio Registrado</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-ok"></span> 
							${fn:length(intercambios) gt 1 ?'Intercambios Registrados.':'Intercambio Registrado.'}
							<span class="badge">${sizeInterReg}</span>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed table-hover table-striped">
								<tr>
									<th>#</th>
									<th>Intercambio</th>
									<th>Archivo</th>
									<th>Imagen</th>
									<th>Status</th>
								</tr>
								<c:choose>
									<c:when test="${not empty intercambios}">
										<c:forEach items="${intercambios}" var="intercambio" varStatus="i">
											<tr>
												<td>${i.count}</td>
												<td>${intercambio.opcion}</td>
												<td>
													<div class="text-left">
														${intercambio.nameFile eq 'no-define'? '<span class="glyphicon glyphicon-ban-circle"></span>': intercambio.nameFile }
													</div>
												</td>
												<td>
													<div class="text-left">
														<span class="${intercambio.glyphicon}"></span>
													</div>
												</td>
												<td>
													<div class="text-left">
														<span class="glyphicon glyphicon-ok-sign"></span>
								  					</div>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="5">
											<div class="text-center">
												No se registraron intercambios. 
											</div>
										</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
						<div class="text-center">
							<a href='<c:url value="/intercambio/showUserIntercambios"/>' class="btn btn-sm btn-success">Mis Intercambio.</a>
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