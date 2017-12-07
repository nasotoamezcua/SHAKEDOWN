<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="scriptsandcss.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NAVIDAD ::: HOME</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>HOME</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-tree-conifer"></span> 
						Lista de Usuarios.
					</div>
					<div class="panel-body">
						<div class="alert alert-success alert-dismissable fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong><span class="glyphicon glyphicon-info-sign"></span> Informaci&oacute;n:</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Cantidad: <span class="glyphicon glyphicon-usd"></span> <strong>500.00 pesos.</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Fecha de Intercambio: <strong>22-Diciembre-2017</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Horario: <strong>10:00 AM - 05:00 PM</strong>
							<br>
						</div>
					
						<div class="table-responsive">
							<table class="table table-condensed">
								<tr>
									<th>#</th>
									<th>Avatar</th>
									<th>Usuario</th>
									<th>Nombre</th>
									<th>Intercambios</th>
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
															data-trigger="hover" data-content="${userform.nombre}">
															<img alt="Avatar"  class="avatarUser" src='<c:url value="/resources/img/avatares/${avatar}"/>'/>
														</a>
  													</div>
												</td>
												<td>${userform.user}</td>
												<td>${userform.nombre}</td>
												<td>
													<c:choose>
														<c:when test="${fn:length(userform.intercambios) gt 0}">
															<button data-toggle="collapse" data-target="#inter${userform.idUsuario}" 
																class="btn btn-info btn-sm">
															<span class="glyphicon glyphicon-gift"></span>
															<span class="badge">${fn:length(userform.intercambios)}</span>
													</button>
														</c:when>
														<c:otherwise>
															<span class="glyphicon glyphicon-gift"></span>
															<span class="badge">${fn:length(userform.intercambios)}</span>
														</c:otherwise>
													</c:choose>
													
												</td>
											</tr>
											<tr>
												<td colspan="5">
													<div id="inter${userform.idUsuario}" class="collapse">
														<div class="panel panel-success">
															<div class="panel-heading">
																<span class="glyphicon glyphicon-gift"></span> 
																${userform.user} ::: Lista de Intercambios: 
																<span class="badge">${fn:length(userform.intercambios)}</span>
															</div>
														</div>
														<div class="panel-body">
															<div class="table-responsive">
																<table class="table table-condensed table-hover table-striped">
																	<tr>
																		<th>#</th>
																		<th>Intercambio</th>
																		<th>Imagen</th>
																	</tr>
																	<c:forEach items="${userform.intercambios}" var="intercambio" varStatus="i">
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
																						<c:url value="/resources/img/intercambios/${userform.user}/${intercambio.img}" var="imgLink"></c:url>
																						<a href="${imgLink}" target="_blank" title="Imagen" data-toggle="popover" data-placement="right"
																							data-trigger="hover" data-content="${intercambio.img}" class="btn btn-success btn-sl">
																							<span class="glyphicon glyphicon-picture"></span>
																						</a>
																					</c:otherwise>
																				</c:choose>
																			</div>
																		</td>
																	</tr>
																	</c:forEach>
																</table>
															</div>
														</div>
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
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
</body>
</html>