<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example Multipart</title>
</head>
<body>
	<c:set var="list" value="{1,2,3}"></c:set>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="intercambioForm">
		 
		<c:forEach items="${list}" var="valor" varStatus="i" >
		<div class="form-group">
	        <label for="name${valor}">Intercambio ${valor}</label>
	        <input type="text" name="intercambios[${i.index}].name" id="name${valor}">
	    </div>
	    <div class="form-group">
	        <label for="file${valor}">File Input ${valor}</label>
	        <input type="file" name="intercambios[${i.index}].file" id="file${valor}">
	    </div>
		</c:forEach>
	    
	    
	    <button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</body>
</html>