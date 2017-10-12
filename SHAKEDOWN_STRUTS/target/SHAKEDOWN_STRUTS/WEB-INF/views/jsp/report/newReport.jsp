<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Report</title>
<sj:head/>
<sb:head/>
</head>
<body>
	<jsp:include page="../header.jsp"/>
		<div class="container">
			<div class="jumbotron">
				<h1>Shakedown ::: New Reports</h1>
				<p>These are the users currently in the system.</p>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					New Report
				</div>
				<div class="panel-body">
				<s:form theme="bootstrap" cssClass="well form-vertical">
				    <s:textfield
				    		placeholder="Name Report"
				            label="Name Report"
				            name="name"
				            cssClass="form-control"
				            inputPrependIcon="list-alt"
				            helpText="Enter your Name Report here."
				            tooltip="Enter your Name Report here"/>
				            
				    <sj:datepicker
				    		placeholder="MM/DD/AAAA"
	                        id="datepicker"
	                        parentTheme="bootstrap"
	                        label="Datepicker"
	                        tooltip="This Textfield has an Help Text"
	                        helpText="This Textfield has an Help Text."
	                        cssClass="form-control"
	                        showOn="focus"
	                        inputPrependIcon="calendar"
	                />
				
					<%--
					elementCssClass="col-sm-5" colspan
					inputAppendIcon="calendar" Agrega Icono a la derecha  
					pull-right alinear elementos
					
				    <s:textfield
				    		placeholder="Textfield with prepended text"
				            label="Textfield with prepended text"
				            inputPrepend="@"
				            name="prepend"/>
				
				    <s:textfield
				    		placeholder="Textfield with appended text"
				            label="Textfield with appended text"
				            inputAppend="$"
				            name="append"/>
				    --%>
				
				    <s:submit cssClass="btn btn-primary"/>
				    <s:submit cssClass="btn btn-danger"/>
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				</s:form>
				
				
				
				</div>
			</div>
	</div>
		
	<jsp:include page="../footer.jsp"/>
	
</body>
</html>