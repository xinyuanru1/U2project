<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<strong>登陆</strong>
			</div>
		
			<div class="login_form">
				<form action="../UserServlet?flag=userLogin" method="post">
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label> 
						<input name="userName" id="userName" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" name="password" type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
					</div>
					<c:if test="${msg!=null}">
						<span style="color:red;">${msg}</span>
						<%session.invalidate(); %>
					</c:if>
					<div class="form-group space">
						<label class="t"></label>　　　
						<input type="submit" 
						class="btn btn-primary btn-lg" id="submit_btn" value="&nbsp;登&nbsp;录&nbsp"> </input>
						<a href="../register/userRegister.jsp" ><input type="button" value="&nbsp;注&nbsp;册&nbsp;" class="btn btn-default btn-lg"></a>
					</div>
				</form>
			</div>
		</div>
		
	</div>
</div>

<!-- Javascript -->

<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<script src="js/scripts.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>