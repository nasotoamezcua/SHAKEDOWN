<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Users app</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href='<s:url value="/assignments" />' title="View Users">View assigments</a>
				</li>
				<li class="active">
					<a href='<s:url value="/users/" />' title="View users">View users</a>
				</li>
				<li>
					<a href='<s:url value="/users/new" />' title="New user">New	user</a>
				</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>