<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>#</td>
			<td>Nombre</td>
			<td>Status</td>
			<td>NameFile</td>
			<td>PathFile</td>
			<td>IMG</td>
		</tr>
		
		<c:forEach items="${listIntercambios}"  var="intercambio" varStatus="i">
		<tr>	
				<td>${i.count}</td>
				<td>${intercambio.name}</td>
				<td>${intercambio.status}</td>
				<td>${intercambio.nameFile}</td>
				<td>${intercambio.pathFile}</td>
				<td>
					<img src="<s:url value="/resources/imgIntercambios/imgIntercambios/pdf_1.png"/>" alt="${intercambio.nameFile}"/>
					
				</td>
		</c:forEach>
		
	</table>
</body>
</html>