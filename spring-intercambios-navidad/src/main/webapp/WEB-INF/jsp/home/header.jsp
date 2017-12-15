<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate var="now" value="${date}" pattern="yyyy-MM-dd"/>
<c:set var="dateLimit" value="2017-12-18"/>

<nav class="navbar navbar-custom navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">
				<span class="glyphicon glyphicon-gift"></span>
				Navidad app
			</a>
		</div>
		<security:authorize access="isAnonymous()">
			<a class="navbar-brand navbar-right" href="#">
				<span class="glyphicon glyphicon-tree-conifer"></span>
				Sistema Intercambios Navidad
			</a>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
		      			<a href='<c:url value="/login"/>'>
		      				<span class="glyphicon glyphicon-log-in"></span> 
		      				login
		      			</a>
		      		</li>
				</ul>
			</div>
		</security:authorize>
		<div id="navbar" class="collapse navbar-collapse">
			<security:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav">
				<li>
					<a href='<c:url value="/welcome" />' title="Home">
						<span class="glyphicon glyphicon-home"></span>
						Home
					</a></li>
				<li class="dropdown">
			    	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
			    		<span class="glyphicon glyphicon-tree-conifer"></span>
			    		Intercambios
			        	<span class="caret"></span>
			        </a>
			        	<ul class="dropdown-menu">
			          		<li>
			          			
			          			<a href='<c:url value="/intercambio/showUserIntercambios"/>'>
			          				<span class="glyphicon glyphicon-gift"></span>
			          				Mis Intercambios
			          				<span class="badge">${userIntercambios}</span>
			          			</a>
			          		</li>
			          		<li class="${now lt dateLimit ? '' : 'disabled'}">
			          			<a href="${now lt dateLimit ? '/spring-intercambios-navidad/intercambio' : '#'}">
			          			<span class="glyphicon glyphicon-floppy-saved"></span>
			          				Agregar Intercambio 
			          			</a></li>
			        	</ul>
			    </li>
				<li>
					<a href='<c:url value="/root" />' title="Home">
						<span class="glyphicon glyphicon-eye-open"></span>
						Administrador
					</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
		      <li class="dropdown">
		      	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
		      		<span class="glyphicon glyphicon-user"></span> 
		      		Usuario:
		      		<security:authentication property="principal.username" />
		      		<span class="caret"></span>
		      	</a>
		      	<ul class="dropdown-menu">
	          		<li>
	          			<a href='<c:url value="/cuenta" />'>
	          				<span class="glyphicon glyphicon-cog"></span>
	          				Mi Cuenta
	          			</a>
	          		</li>
	        	</ul>
		      </li>
		      <li>
		      	<a href='<c:url value="/logout"/>'>
		      		<span class="glyphicon glyphicon-log-out"></span> 
		      		logout
		      	</a>
		      </li>
		    </ul>
		    </security:authorize>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>