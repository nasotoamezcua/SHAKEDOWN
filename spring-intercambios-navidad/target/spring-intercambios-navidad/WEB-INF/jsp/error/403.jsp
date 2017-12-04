<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>NAVIDAD ::: ERROR</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<span class="glyphicon glyphicon-remove"></span>
				ERROR ${rre.status } 
			</h1>
			<p>Sistema Intercambios Navidad</p>
		</div>
        <div class="row">
            <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                <div class="panel panel-danger">
                	<div class="panel-heading">
                		<span class="glyphicon glyphicon-remove-circle"></span>
                		Error ${rre.status }:
                	</div>
      				<div class="panel-body">
      					<div class="text-left">
      						Mensaje Error: ${rre.message }
      				 		<br>
      				 		Exception: ${rre.exception }
      					</div>
      					<br>
      					
      				 	 <div class="text-center">
      				 		<a href="<c:url value="/welcome"/>" class="btn btn-sm btn-danger">Home</a>
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