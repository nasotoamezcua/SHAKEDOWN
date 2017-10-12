<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>SHAKEDOWN ::: LOGIN</title>

    <!-- Bootstrap Core CSS -->
    <link href='<s:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css" />
    <!-- MetisMenu CSS -->
    <link href="<s:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom CSS -->
    <link href="<s:url value="/resources/dist/css/sb-admin-2.css"/>" rel="stylesheet" type="text/css" />
    <!-- Custom Fonts -->
    <link href="<s:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style>
		.imgcontainer {
		    text-align: center;
		    margin: 24px 0 12px 0;
		}
		img.avatar {
		    width: 30%;
		    border-radius: 50%;
		}
	</style>

</head>

<body>
	<c:choose>
		<c:when test="${valFalse}">
			<c:set value="login-panel panel panel-danger" var="panel"/>
			<c:set value="Login Error" var="title"/>
		</c:when>
		<c:otherwise>
			<c:set value="login-panel panel panel-primary" var="panel"/>
			<c:set value="Login" var="title"/>
		</c:otherwise>
	</c:choose>
	

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="${panel}">
                    <div class="panel-heading">
                        <h3 class="panel-title">${title}</h3>
                    </div>
                    <div class="imgcontainer">
    					<img src="<s:url value="/resources/img/avatares/img_avatar2.png"/>" alt="Avatar" class="avatar" />
  					</div>
                    <div class="panel-body">
                        <form role="form" action="<s:url value="/j_spring_security_check"/>" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuario" name="username" autofocus="true" />
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="" />
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"/>
                                        <p>Remember  me</p>
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <input type="submit" value="Ingresar" class="btn btn-lg btn-success btn-block" />
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="<s:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<s:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<s:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<s:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
</body>
</html>