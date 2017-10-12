<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/dist/css/sb-admin-2.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
    
<title>SHAKEDOWN ::: ERROR: ${param.error} </title>
</head>
<body>
	<c:choose>
		<c:when test="${param.error eq '403' }">
			<c:set var="h3" value="Acceso denegado" />
			<c:set var="p" value="Lo Sentimos: No tienes los permisos requeridos."/>
			<c:set var="panel" value="login-panel panel panel-warning"/>
			<c:set var="iconoGly" value="glyphicon glyphicon-ban-circle"/>
		</c:when>
		<c:otherwise>
			<c:set var="h3" value="Recurso no encontrado"/>
			<c:set var="p" value="Lo sentimos: El recurso que requieres no fue encontrado."/>
			<c:set var="panel" value="login-panel panel panel-danger"/>
			<c:set var="iconoGly" value="glyphicon glyphicon-warning-sign"/>
		</c:otherwise>
	</c:choose>
	
	<c:url var="home" value="/home/homeAction"/>
	
	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="${panel}">
                	<div class="panel-heading">
                		<span class="${iconoGly}"></span>
                		${h3}
                	</div>
      				<div class="panel-body">
      				 	${p} ${pageContext.request.contextPath}
      				 	</br>
      				 	</br>
      				 	<div class="text-center">
      				 		<a href="${home}" class="btn btn-success btn-lg">
				          		<span class="glyphicon glyphicon-home"></span> Home
				        	</a>
      				 	</div>
      				 	
      				 </div>
                </div>
            </div>
        </div>
    </div>
     <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

</body>
</html>