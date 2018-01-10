<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
	<title>NAVIDAD ::: ADMIN - USUARIOS</title>
	
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Administrar Usuarios</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span> 
						Lista de Usuarios.
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="idTableUser" class="table table-condensed">
								<tr>
									<th>#</th>
									<th>Avatar</th>
									<th>Nombre</th>
									<th>Usuario</th>
									<th>Password</th>
									<th>E-Mail</th>
									<th>Intercambios</th>
									<th>Eliminar</th>
								</tr>
								<c:choose>
									<c:when test="${not empty userFormsAll}">
										<c:forEach items="${userFormsAll}" var="userform" varStatus="i">
											<c:choose>
												<c:when test="${userform.genero eq 'Masculino'}">
													<c:set var="avatar" value="img_avatar2.png"/>
												</c:when>
												<c:otherwise>
													<c:set var="avatar" value="img_avatar6.png"/>
												</c:otherwise>
											</c:choose>
											<tr>
												<td>${i.count}</td>
												<td>
													<div class="text-left">
														<a href="#" title="${userform.user}" data-toggle="popover" data-placement="right"
															data-trigger="hover" data-content="${userform.password}">
															<img alt="Avatar"  class="avatarUser" src='<c:url value="/resources/img/avatares/${avatar}"/>'/>
														</a>
  													</div>
												</td>
												<td>${userform.nombre}</td>
												<td>${userform.user}</td>
												<td>${userform.password}</td>
												<td>${userform.mail}</td>
												<td>
													<c:choose>
														<c:when test="${fn:length(userform.intercambios) gt 0}">
															<span class="label label-info">
																<span class="glyphicon glyphicon-gift"></span>
																<span class="badge">${fn:length(userform.intercambios)}</span>
															</span>
														</c:when>
														<c:otherwise>
															<span class="glyphicon glyphicon-gift"></span>
																<span class="badge">${fn:length(userform.intercambios)}</span>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<div class="text-left">
														<a href='<c:url value="/root/deleteUser/${userform.idUsuario}"/>' class="btn btn-sl btn-danger">
															<span class="glyphicon glyphicon-floppy-remove"></span>
														</a>
								  					</div>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="5">
												<div class="text-center">No existen Usuarios registrados</div>									
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table>
							<div class="text-center">
								<a href='<c:url value="/welcome"/>' class="btn btn-sm btn-success">OK</a>
							</div>
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