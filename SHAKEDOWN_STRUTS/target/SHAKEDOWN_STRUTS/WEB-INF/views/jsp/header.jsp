<%@ taglib prefix="s" uri="/struts-tags"%>
<link href='<s:url value="/resources/vendor/bootstrap/css/bootstrapCustomer.css"/>' rel="stylesheet" type="text/css" />
<nav class="navbar navbar-custom navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Users app</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href='<s:url value="/home/homeAction" />' title="Home">Home</a>
				</li>
				<li>
					<a href='<s:url value="/eventos/eventosAction" />' title="View Reports">View Reports</a>
				</li>
				<li>
					<a href='<s:url value="/reports/newReportsAction" />' title="New Reports">New Reports</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
		      <li>
		      	<a href="javascript: document.logoutForm.submit()">
		      		<span class="glyphicon glyphicon-user"></span> Sign Up
		      	</a>
		      </li>
		      <li>
		      	<a href="#"><span class="glyphicon glyphicon-log-in"></span> 
		      		Login
		      	</a>
		      </li>
		    </ul>
			<form name="logoutForm" action='<s:url value="/logout"/>' method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>