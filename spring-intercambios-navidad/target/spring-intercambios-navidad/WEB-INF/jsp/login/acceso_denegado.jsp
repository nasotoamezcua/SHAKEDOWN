<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
    <link href='<s:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css" />
    <!-- MetisMenu CSS -->
    <link href="<s:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom CSS -->
    <link href="<s:url value="/resources/dist/css/sb-admin-2.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom Fonts -->
    <link href="<s:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
    
<title>SHAKEDOWN ::: ERROR: ${param.error}</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.error eq 403}">
			<c:set var="h3" value="Acceso denegado: "/>
			<c:set var="p" value="No tienes los permisos requeridos."></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="h3" value="Recurso no encontrado: "/>
			<c:set var="p" value="Lo sentimos el recurso que requieres no fue encontrado."></c:set>
		</c:otherwise>
	</c:choose>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                    	<h3 class="panel-title">Lo sentimos, no tienes permiso para ver esta página</h3>
                    	<h3 class="panel-title">P&oacute;ngase en contacto con su administrador de sistema.</h3>
                        <h3 class="panel-title">${h3} ${pageContext.request.contextPath}</h3>
                        <p>${p}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../home/footer.jsp"/>
    
     <!-- jQuery -->
    <script src="<s:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<s:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<s:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<s:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

</body>
</html>