<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="dateFooter" class="java.util.Date" />
<fmt:formatDate var="nowFooter" value="${dateFooter}" pattern="yyyy"/>
<footer class="footer">
	<div class="container">
		<p class="text-muted">
			<span class="glyphicon glyphicon-gift"></span> 
			Sistema Intercambios Navidad V3+ :: &copy; ${nowFooter} 
			<a href="mailto:nasotoamezcua@gmail.com" 
				title="Nestor Alejandro Soto Amezcua" 
				data-toggle="popover" data-trigger="hover" 
				data-content="nasotoamezcua@gmail.com">
				Nestor Soto 
				<span class="glyphicon glyphicon-envelope"></span>
			</a> 
		</p>
		<p class="text-muted">
			<span class="glyphicon glyphicon-leaf"></span>
			Java SE 8 + Java EE 7 + Spring 4 + Spring MVC 4 + Spring Security 3 + Hibernate 4 + MySQL 5 + Bootstrap 3 + Tomcat 8
			<span class="glyphicon glyphicon-leaf"></span>
		</p>
	</div>
</footer>