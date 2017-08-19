<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7">
<![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8">
<![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9">
<![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8"/>
<title>订单管理 |星辰</title>
<link href="css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/respond.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<script src="js/excanvas.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body class="lang_cn">
<%@include file="common.jsp" %>
<!-- Google Tag Manager (noscript) -->
<noscript>
<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-WRMKNTT" height="0" width="0" style="display:none;visibility:hidden">
</iframe>
</noscript>
<!-- End Google Tag Manager (noscript) -->
<div style="margin:0 auto;width:0px;height:0px;overflow:hidden;">
	<img id='thumbnail' src="picture/logo.png" width='350' height='350'/>
</div>
<div id="wrapper">
	<div id="content">
		<header class="header--image" style="background-image: url(images/a2.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>
					
      			修改成功！请重新登录！
					</h1>
				</div>
			</div>
		</div>
		<p class='banner'>
			<a href="../login/login.jsp">点击登录</a>
		</p>
		</header>
	</div>
</div>
<script src="js/scripts.min.js"></script>
</body>
</html>