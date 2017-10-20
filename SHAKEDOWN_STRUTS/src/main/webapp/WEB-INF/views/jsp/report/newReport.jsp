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
			<div class="col-md-12 col-md-offset">
			<div class="panel panel-primary">
				<div class="panel-heading">
					New Report
				</div>
				<div class="panel-body">
						<s:form theme="bootstrap" cssClass="well form-vertical">
							<div class="row">
								<div class="col-md-6">
									<s:textfield
							    		placeholder="Name Report"
							            label="Name Report"
							            name="name"
							            cssClass="form-control"
							            inputPrependIcon="list-alt"
							            helpText="Enter your Name Report here."
							            tooltip="Enter your Name Report here"/>
								</div>
								
								<div class="col-md-6">
									<sj:datepicker
							    		placeholder="DD/MM/AAAA"
							    		displayFormat="dd/mm/yy"
				                        id="datepicker"
				                        parentTheme="bootstrap"
				                        label="Datepicker"
				                        tooltip="This Textfield has an Help Text"
				                        helpText="This Textfield has an Help Text."
				                        cssClass="form-control"
				                        showOn="focus"
				                        inputPrependIcon="calendar" />
								</div>
								
							</div>
							<!-- Complete - Fail - Drop -->
							<div class="row">
								<div class="col-md-4">
									<s:textfield
							    		placeholder="Complete"
							            label="Complete"
							            name="name"
							            cssClass="form-control"
							            inputPrependIcon="ok"
							            helpText="Enter your Complete here."
							            tooltip="Enter your Complete here."/>
								</div>
								<div class="col-md-4">
									<s:textfield
							    		placeholder="Fail"
							            label="Fail"
							            name="name"
							            cssClass="form-control"
							            inputPrependIcon="star"
							            helpText="Enter your Fail here."
							            tooltip="Enter your Fail here."/>
								</div>
								<div class="col-md-4">
									<s:textfield
							    		placeholder="Drop"
							            label="Drop"
							            name="name"
							            cssClass="form-control"
							            inputPrependIcon="asterisk"
							            helpText="Enter your Drop here."
							            tooltip="Enter your Drop here."/>
								</div>
							</div>  
						    <!-- Medicion - Semana - Ruta -->
			                <div class="row">
				                <div class="col-md-4">
			                        <s:select
		                                label="Tipo de Medicion"
		                                name="genger"
		                                list="#{'BM':'Benchmarking', 'DT':'Drive Test'}"
		                                headerKey="-1"
		                                headerValue="----- Selecciona una Medicion -----"
		                                cssClass="form-control"
		                                tooltip="This Textfield has an Help Text"
				                        helpText="This Textfield has an Help Text."
		                                elementCssClass=""
		                                labelCssClass="" />
			                    </div>
			                    <div class="col-md-4">
			                        <s:select
			                                label="Semana"
			                                name="genger"
			                                list="{'male', 'female'}"
			                                cssClass="form-control"
			                                tooltip="This Textfield has an Help Text"
					                        helpText="This Textfield has an Help Text."
			                                elementCssClass=""
			                                labelCssClass="" />
			                    </div>
			                    <div class="col-md-4">
			                        <s:select
			                                label="Ruta"
			                                name="genger"
			                                list="{'male', 'female'}"
			                                cssClass="form-control"
			                                tooltip="This Textfield has an Help Text"
					                        helpText="This Textfield has an Help Text."
			                                elementCssClass=""
			                                labelCssClass="" />
			                    </div>
		                    </div>
		                    <div class="row">
		                    	<div class="col-md-6">
		                    		<s:submit cssClass="btn btn-primary pull-right"/>
		                    	</div>
		                    	<div class="col-md-6">
		                    		 <s:submit cssClass="btn btn-danger pull-left"/>
		                    	</div>
		                    </div>
		                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						   
						    
						
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
						</s:form>
					
					
					
				</div> <!-- Panel Body -->
				
			</div> <!-- Panel primary -->
			</div>
	</div>
		
	<jsp:include page="../footer.jsp"/>
	
</body>
</html>