<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>NAVIDAD ::: MI CUENTA</title>
</head>
<body>
	<c:choose>
		<c:when test="${userCuenta.genero eq 'Masculino'}">
			<c:set var="avatar" value="img_avatar2.png"/>
		</c:when>
		<c:otherwise>
			<c:set var="avatar" value="img_avatar6.png"/>
		</c:otherwise>
	</c:choose>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Mi Cuenta</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-cog"></span>
						Mi cuenta.
					</div>
					<div class="imgcontainer">
						<a href="#" title="${userCuenta.user}" data-toggle="popover" data-placement="right"
								data-trigger="hover" data-content="${userCuenta.nombre}">
							<img alt="Avatar" class="avatarUser" src='<c:url value="/resources/img/avatares/${avatar}"/>'/>
						</a>
  					</div>
					<div class="panel-body">
					
						<div class="table-responsive">
							<table class="table table-condensed table-hover table-striped">
								<tr>
									<th>Nombre</th>
									<th>E-Mail</th>
									<th>Usuario</th>
									<th>Password</th>
									<th>Genero</th>
									<th>Actualizar</th>
								</tr>
								<c:choose>
									<c:when test="${not empty userCuenta}">
										<tr>
											<td>${userCuenta.nombre}</td>
											<td>${userCuenta.mail}</td>
											<td>${userCuenta.user}</td>
											<td>${userCuenta.password}</td>
											<td>${userCuenta.genero}</td>
											<td>
												<div class="text-center">
													<a href='<c:url value="/cuenta/update"/>' class="btn btn-sm btn-info">
														Actualizar
													</a>
												</div>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr><td colspan="5">Usuario no encontrado</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
						<div class="text-center">
							<a href='<c:url value="/welcome"/>' class="btn btn-sm btn-success">OK</a>
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