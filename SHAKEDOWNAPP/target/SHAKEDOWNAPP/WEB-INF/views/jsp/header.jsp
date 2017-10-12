<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Users app</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href='<s:url value="/assignments/" />' title="View Users">View assigments</a>
				</li>
				<li class="active">
					<a href='<s:url value="/eventos"/>' title="Eventos">Eventos</a>
				</li>
				<li>
					<a href="javascript: document.logoutForm.submit()">
						Cerrar sesi&oacute;n
					</a>
					<!--  <a href='<c:url value="/logout"/>'>Cerrar sesi&oacute;n</a>-->
				</li>
			</ul>
			<form name="logoutForm" action='<c:url value="/logout"/>' method="post">
				<input hidden="true" type="submit" value="Sign Out" />
			</form>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>