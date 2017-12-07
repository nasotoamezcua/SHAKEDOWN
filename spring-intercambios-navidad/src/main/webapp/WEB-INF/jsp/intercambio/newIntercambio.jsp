<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>NAVIDAD ::: AGREGAR INTERCAMBIO</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Agregar Intercambio</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-floppy-saved"></span>
						Agregar Intercambio.
					</div>
					<div class="panel-body">
						<form:form cssClass="well form-vertical" enctype="multipart/form-data" method="POST" commandName="newInter">
							<div class="alert alert-info alert-dismissable fade in">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong><span class="glyphicon glyphicon-info-sign"></span> Instrucciones:</strong>
								<br>
								<c:forEach var="inst" items="${instrucciones}">
									${inst}<br />
								</c:forEach>
							</div>
							<div class="">
								<spring:hasBindErrors name="newInter">
									<div class="alert alert-danger alert-dismissable fade in">
				    					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    				
											<c:forEach var="error" items="${errors.allErrors}">
												<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
												<spring:message message="${error}" />
												<br />
											</c:forEach>
									</div>
								</spring:hasBindErrors>

							</div>
							<%--Validar Formulario con filas multiples [List<IntercambioForm>] --%>
							<c:forEach items="${newInter.intercambiosForms}" var="valor" varStatus="i" >
								<div class="row">
									<div class="col-md-6">
										<spring:bind path="intercambiosForms[${i.index}].opcion">
											<div class="input-group ${status.error ? 'has-error' : ''}">
												<span class="input-group-addon"><i class="glyphicon glyphicon-gift"></i></span>
										 		<input type="text" class="form-control"  placeholder="Opcion ${i.count}" 
										 			name="${status.expression}" value="${status.value}">
											</div>
											<c:if test="${status.error}">
												<div class="alert alert-danger alert-dismissable fade in">
				    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
				    								${status.errorMessage }
				 		 						</div>
			 		 						</c:if>
										</spring:bind>
									</div>
									<div class="col-md-6">
										<spring:bind path="intercambiosForms[${i.index}].file">
											<div class="input-group ${status.error ? 'has-error' : ''}">
									  			<span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
								      			<input type="file" class="form-control" name="${status.expression}">
								    		</div>
								    		<c:if test="${status.error}">
												<div class="alert alert-danger alert-dismissable fade in">
				    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
				    								${status.errorMessage }
				 		 						</div>
			 		 						</c:if>
							    		</spring:bind>
							    	</div>
								</div>
								<br>
							</c:forEach>
								<div class="row">
									<div class="col-md-12">
										<div class="text-center">
											<button type="submit" class="btn btn-sm btn-success">Agregar</button>
											<a href='<c:url value="/welcome"/>' class="btn btn-sm btn-danger">Cancelar</a>
										</div>
									</div>
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../home/footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
</body>
</html>