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
	
	<s:iterator begin="1" end="2" var="3" status="js">
		<script type="text/javascript">
			$(document).ready(function() {
				$('#idTable%{#js.count}').DataTable({
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
					<s:set var="fondoRuta" value="success" />
				</s:if>
				<s:elseif test="%{#tab.count == 2}">
					<s:set var="fondoRuta" value="info" />
				</s:elseif>
				<s:else>
					<s:set var="fondoRuta" value="warning" />
				</s:else>
				
				<div class="table-responsive">
					<table id="idTable#tab.count" class="table table-condensed table-hover table-striped">
						<thead>
							<tr class="#fondoRuta">
								<td colspan="3" align="center">
									<b>Zona #tab.count</b>
								</td>
							</tr>
							<tr>
								<th>#</th>
								<th>Nombre</th>
								<th>Fecha</th>
							</tr>
						</thead>
						<tbody>
							<s:if test="%{#listaDTO != null}">
								<s:iterator value="#listaDTO" var="zona" status="z">
									<tr>
										<td>#z.count</td>
										<td>#zona.nombre</td>
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
				
			</s:iterator>
		</s:if>
	</div>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>