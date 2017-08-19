<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<!-- Google Tag Manager -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	<%--
	function aa(){
		
			var proNum=document.getElementById("proNum"+i);
			var a=parseInt(proNum.value);
			$("#proNum"+i).val(a+1);
			var price=document.getElementById("price");
			var a=parseInt(price.value);
			var b=parseInt(proNum.value);
			$("#proTotalPrice").val(a*b);
			$("#proTotalPricel").val($("#proTotalPrice").val());
		}

	
	function bb(){
		var proNum=document.getElementById("proNum");
		var a=parseInt(proNum.value);
		if(a<=1){
			$("#proNum").val(1);
		}else{
			$("#proNum").val(a-1);
		}
		
		var price=document.getElementById("price");
		var proNum=document.getElementById("proNum");
		var a=parseInt(price.value);
		var b=parseInt(proNum.value);
		$("#proTotalPrice").val(a*b);
	}
	function goShopping(){
		window.location.href="../GouWuCheServlet?flag=gouWuChe2&coffeeNo="+$("#coffeeNo").html()+"&pronum="+$("#proNum").val();
	}
	--%>
	
	$(document).ready(function(){
		for(var i = 0; i < 100; i++){
			$("#"+("bu"+i)).click(function(){
				$("#"+("proNum"+i)).val(parseInt($("#"+("proNum"+i)).val())+1);
			});
		}
	});
</script>

<!-- End Google Tag Manager -->
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
		<nav class="navbar togglefree" id="mainNav" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<div class="row">
					<div class="col-xs-5">
						<div class="navbar-toggle-holder">
							<div class="navbar-toggle navbar-left collapsed toggler" data-totoggle="#sideBar" id="sidebarToggle" onclick="ga_menu()">
								<input type="image" src="images/menu_icon.svg" id="sidebarToggleImage"/>
						<span>菜单</span>
							</div>
						</div>
					</div>
					<div class="col-xs-2" style="padding: 0;" style="background-image:url('images/logoo.png')">
					<!--抬头修改 -->
					<h2  style="color:#C90;font:bold '行楷';">星辰咖啡</h2>
					</div>
					<div class="col-xs-5">
						<div class="navbar-toggle-holder">
							<div class="navbar-toggle collapsed right-gear">
								<div id="my-account" style="display:none;">
									<a class="nav-word toggler-dropdown" data-totoggle="#settings" onclick="gas('Nav', 'right', 'account_lk_');"/>我的帐户<img src="picture/menu_icon_right.png"/></a>
								</div>
								<div id="msr_callout_div" style="display:none;">
									<c:choose>
						           		<c:when test="${user==null}">
							           		<ul class="top-links">
								               <li><a href="../login/login.jsp">登录</a></li>
								               <li><a href="../register/userRegister.jsp">注册</a></li>
								            </ul>
						           		</c:when>
						           		<c:when test="${user.userName eq 'admin'}">
							           		<ul class="top-links">
								               <li><a href="../login/login.jsp">欢迎您,${user.userName}</a></li>
								               <li><a href="../UserServlet?flag=logout">注销</a></li>
								               <li><a href="../GossipServlet?flag=getAll&pageIndex=1">进入后台管理</a></li>
								            </ul>
						           		</c:when>
						           		<c:otherwise>
						           			<ul class="top-links">
								               <li><a href="../login/login.jsp">欢迎您,${user.userName}</a></li>
								               <li><a href="../UserServlet?flag=logout">注销</a></li>
								            </ul>
						           		</c:otherwise>
						           </c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</nav>
		<div id="screen" style="display: none;">
		</div>
		<div class="navmenu" id="sideBar">
			<div class="navInternal specialScroll">
				<ul class="nav navmenu-nav top">
					<li class="" style="padding-bottom: 10px;">
					<a href="#" onclick="gas('Nav', 'left', 'store_lk_');">星辰咖啡馆</a>
					</li>
				</ul>
				<ul class="nav navmenu-nav" style="padding-top: 10px;">
					<li><a href="first.jsp" onclick="gas('Nav', 'left', '首页_lk_');">首页</a></li>
					<li class="">
					</li>
					<li class="">
					<a href="../NewsServlet?flag=reGetAll" onclick="gas('Nav', 'left', '星享俱乐部_lk_');">星辰新闻</a>
					</li>
					<li class="">
					<div class="hasChildren">
						<span class="caret showAfter" style="display: none;"></span>产品展示
					</div>
					<ul class="children">
						<li class=""><a href="../CoffeeServlet?flag=getByType&type=早咖啡" onclick="gas('Nav', 'left', '咖啡文化_lk_');">早咖啡</a></li>
						<li class=""><a href="../CoffeeServlet?flag=getByType&type=午咖啡" onclick="gas('Nav', 'left', '咖啡文化_lk_');">午咖啡</a></li>
						<li class=""><a href="../CoffeeServlet?flag=getByType&type=晚咖啡" onclick="gas('Nav', 'left', '咖啡文化_lk_');">晚咖啡</a></li>
					</ul>
					</li>
					<li class="">
					<div class="hasChildren">
						<span class="caret showAfter" style="display: none;"></span>会员中心
					</div>
					<ul class="children">
						<li class="userMassage.jsp"><a href="userMassage.jsp" onclick="gas('Nav', 'left', '饮品_lk_');">个人信息</a></li>
						<li class="payment.jsp"><a href="../MenuServlet?flag=list" onclick="gas('Nav', 'left', '星巴克美食_lk_');">订单管理</a></li>
						<li class="addOrder.jsp"><a href="addOrder.jsp" onclick="gas('Nav', 'left', '星巴克咖啡_lk_');">预定管理</a></li>
						<li class="shopping.jsp"><a href="../GouWuCheServlet?flag=list" onclick="gas('Nav', 'left', '星巴克VIA® 免煮咖啡_lk_');">购物车</a></li>
						<li class="../GossipServlet?flag=gossip"><a href="../GossipServlet?flag=gossip" onclick="gas('Nav', 'left', '茶瓦纳™_lk_');">留言板</a></li>
					</ul>
					</li>
					<li class="">
					<a href="contact.jsp" onclick="gas('Nav', 'left', '星享俱乐部_lk_');">联系我们</a>
					</li>
				</ul>
			</div>
		</div>
		<header class="header--image" style="background-image: url(images/a2.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>
					
      			 购物车
					</h1>
				</div>
			</div>
		</div>
		<p class='banner'>
			欢迎查看购物车！
		</p>
		</header>
		<section class="section news__listing">
       购物车商品：
    <table width="80%" border="1" cellpadding="8" cellspacing="0" class="tableBasic">
		    <tr>
		        <td align="center"><strong>编号</strong></td>
		        <td align="center"><strong>用户名</strong></a></td>
		        <td align="center"><strong>产品名称</strong></td>
		        <td align="center"><strong>数量</strong></td>
		        <td align="center"><strong>单价（元）</strong></td>

		       
		         <td align="center"><strong>操作</strong></td>
		    </tr>
		    <c:forEach items="${car}" var="coffee" varStatus="statu">
		    <c:if test="${coffee.value.buyerId==user.id}">
		    	<tr id="tr${statu.index}">
			        <td id="coffeeNo" align="center">${coffee.value.coffeeNo}</td>
			        <td align="center">${user.userName}</a></td>
			        <td align="center" name="coffeeName">${coffee.value.coffeeName}</td>
			        <td  size="5" class="inpMain" align="center" > 
			              bu${statu.index}
			              proNum${statu.index}
			        	<input type="button" value="+" id="bu${statu.index}" ><input type="text" style="width:20px" id="proNum${statu.index}" value="1" name="aaaaa"/><input type="button" value="-" onclick="bb()"  >
			       
			        </td>
			        <td align="center" name="coffeePrice" id="price">${coffee.value.coffeePrice}</td>
			        <td align="center">
			        <a href="../GouWuCheServlet?flag=delete&coffeeNo=${coffee.value.coffeeNo}" onclick="alert('确认删除？')">删除</a>
			        <a href="javascript:goShopping()" >下单</a>
			        </td>
		   		</tr>
		    </c:if>
		    </c:forEach>
	</table>
 </div>
		</div>
		</section>
	</div>
	<div class="footer--1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a id="wechat_icon" onclick="$('#wechat_qrcode').toggle();ga('send', 'event', 'social icons', 'footer', 'weixin');" style="position: relative; float: right; display: inline-block; width: 40px; height: 40px; border-radius: 20px; background: url('images/wechat.svg') no-repeat;background-size: contain; margin-right: 20px; cursor: pointer;">
					<div id="wechat_qrcode" style="display: none; position: absolute; z-index: 1000; top: -200px; left: -200px; width: 200px; height: 200px; background: url('images/qrcode.svg') no-repeat;background-size: contain;">
					</div>
					</a>
              &copy; 2017 Starbucks Corporation.
					<br/>All rights reserved. 沪ICP备17003747号 <br/><a target="_blank" href="#" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="picture/icpicon.png" style="float:left;"/>
					<p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 0px; color:#A3A3A3;">
						沪公网安备 31010402000253号
					</p>
					</a>
				</div>
			</div>
		</div>
	</div>
	</footer>
</div>
<script src="js/scripts.min.js"></script>
</body>
</html>