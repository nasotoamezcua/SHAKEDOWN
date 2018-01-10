<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
	<title>NAVIDAD ::: ADMIN - BLOQUEOS</title>
	
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Administrar Bloqueos</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-eye-open"></span> 
						Bloqueos.
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="idTableUser" class="table table-condensed">
								<tr>
									<th>#</th>
									<th>Bloqueo</th>
									<th>Descripci&oacute;n</th>
									<th>Activar / Desactivar</th>
								</tr>
								<c:choose>
									<c:when test="${not empty listBlocks}">
										<c:forEach items="${listBlocks}" var="block" varStatus="b">
											<tr>
												<td>${b.count}</td>
												<td>${block.bloqueo}</td>
												<td>${block.descrip}</td>
												<td>
												<div class="text-center">
													<c:choose>
														<c:when test="${block.active eq 0}">
															<a href='<c:url value="/root/blocks/desactive/${block.id}"/>' class="btn btn-sl btn-success"
																title="Activar Bloqueo" data-toggle="popover" data-placement="right" 
																data-trigger="hover" data-content="REGISTRO DE ${block.bloqueo}">
																<span class="glyphicon glyphicon-eye-open"></span>
															</a>
														</c:when>
														<c:otherwise>
															<a href='<c:url value="/root/blocks/active/${block.id}"/>' class="btn btn-sl btn-danger"
																title="Desactivar Bloqueo" data-toggle="popover" data-placement="right" 
																data-trigger="hover" data-content="REGISTRO DE ${block.bloqueo}">
																<span class="glyphicon glyphicon-eye-close"></span>
															</a>
														</c:otherwise>
													</c:choose>
													</div>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="4">
												<div class="text-center">No existen Bloqueos registrados</div>									
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