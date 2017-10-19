<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
	
	<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
	
	<s:iterator begin="1" end="2" var="ijs" status="js">
		<script type="text/javascript">
			$(document).ready(function() {
				$('#idTable<s:property value="#js.count"/>').DataTable({
					"aLengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
			        "iDisplayLength": 5
				});
			} );
		</script>
	</s:iterator>
	

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHAKEDOWN ::: EVENTOS</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Shakedown ::: Eventos</h1>
			<p>These are the users currently in the system.</p>
		</div>
		<s:if test="%{listaReportesDTO != null}">
			<s:iterator var="listaDTO" value="listaReportesDTO" status="tab">
			
				<s:if test="%{#tab.count == 1}">
					<s:set var="fondoRuta">success</s:set>
				</s:if>
				<s:else>
					<s:set var="fondoRuta">warning</s:set>
				</s:else>
				
				<!-- PANEL DE LA TABLA -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						New Report
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table id="idTable<s:property value='#tab.count'/>" class="table table-condensed table-hover table-striped">
								<thead>
									<tr class="<s:property value='#fondoRuta'/>">
										<td colspan="7" align="center">
											<b>Zona <s:property value="#tab.count"/></b>
										</td>
									</tr>
									<tr>
										<th>#</th>
										<th>Nombre</th>
										<th>Complete</th>
										<th>Fail</th>
										<th>Drop</th>
										<th>Semana</th>
										<th>Fecha</th>
									</tr>
								</thead>
								<tbody>
									<s:if test="%{#listaDTO != null}">
										<s:iterator value="#listaDTO" var="zona" status="z">
											<tr>
												<td><s:property value="#z.count" /></td>
												<td><s:property value="#zona.nombre" /></td>
												<td><s:property value="#zona.complete" /></td>
												<td><s:property value="#zona.fails" /></td>
												<td><s:property value="#zona.drops" /></td>
												<td><s:property value="#zona.semana" /></td>
												<td><s:date name="#zona.fecha" format="dd/MM/yyyy"/></td>
											</tr>
										<s:else>
											<tr>
												<td colspan="3" align="center"><b>No existen rutas</b></td>
											</tr>
										</s:else>
										</s:iterator>
									</s:if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- PANEL DE LA TABLA -->
			</s:iterator>
		</s:if>
	</div>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>