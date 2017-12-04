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
    <title>NAVIDAD ::: REGISTAR</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Registrar Usuario</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
		
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-md-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">Registar Usuario.</div>
					<c:url value="/registrar" var="urlForm"/>
					<div class="panel-body">
						<form:form cssClass="well form-vertical" action="${urlForm}" method="POST" commandName="userForm">
						<form:hidden path="flagSaveUpdate" value="save"/>
						<div class="row">
							<div class="col-md-6">
								<spring:bind path="nombre">
								<div class="input-group ${status.error ? 'has-error' : ''}">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							 		<form:input path="nombre" class="form-control" placeholder="Nombre"/>
								</div>
								<c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong> 
	    								<form:errors path="nombre"/>
	 		 						</div>
 		 						</c:if>
								</spring:bind>
							</div>
							<div class="col-md-6">
								<spring:bind path="mail">
								<div class="input-group ${status.error ? 'has-error' : ''}">
						  			<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
					      			<form:input path="mail" class="form-control" placeholder="Email"/>
					    		</div>
					    		<c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
	    								<form:errors path="mail"/>
	 		 						</div>
 		 						</c:if>
					    		</spring:bind>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-4">
								<spring:bind path="user">
								<div class="input-group ${status.error ? 'has-error' : ''}">
						  			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					      			<form:input path="user" class="form-control" placeholder="Usuario"/>
					    		</div>
					    		<c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
	    								<form:errors path="user"/>
	 		 						</div>
 		 						</c:if>
					    		</spring:bind>
							</div>
							<div class="col-md-4">
								<spring:bind path="password">
								<div class="input-group ${status.error ? 'has-error' : ''}">
					      			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
					      			<form:password path="password"  class="form-control" showPassword="true" placeholder="Password"/>
					    		</div>
					    		<c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
	    								<form:errors path="password"/>
	 		 						</div>
 		 						</c:if>
					    		</spring:bind>
							</div>
							<div class="col-md-4">
								<spring:bind path="confirPassword">
								<div class="input-group ${status.error ? 'has-error' : ''}">
							      	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							      	<form:password path="confirPassword" class="form-control" showPassword="true" placeholder="Confirmar Password"/>
							     </div>
							     <c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
	    								<form:errors path="confirPassword"/>
	 		 						</div>
 		 						</c:if>
 		 						</spring:bind>
							</div>
						</div>
						
					    <br>
					    <div class="row">
					    	<div class="col-md-8">
					    		<spring:bind path="genero">
					    		<div class="input-group ${status.error ? 'has-error' : ''}">
							      	<span class="input-group-addon">Genero</span>
							      	<form:radiobuttons path="genero" items="${genders}" />
							     </div>
							     <c:if test="${status.error}">
									<div class="alert alert-danger alert-dismissable fade in">
	    								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    								<strong><span class="glyphicon glyphicon-warning-sign"></span></strong>
	    								<form:errors path="genero"/>
	 		 						</div>
 		 						</c:if>
							     </spring:bind>
					    	</div>
					    	<div class="col-md-2">
					    		<div class="input-group">
							      	<input type="submit" value="Registrar" class="btn btn-sm btn-success" />
							     </div>
					    	</div>
					    	<div class="col-md-2">
					    		<div class="input-group">
							      	<a href='<c:url value="/login"/>' class="btn btn-sm btn-danger">Cancelar</a>
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