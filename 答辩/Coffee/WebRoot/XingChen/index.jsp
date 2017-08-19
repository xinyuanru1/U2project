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
<meta charset="utf-8"/>
<title>首页 | 星辰咖啡</title>
<meta name="keywords" content="星巴克，首页，主页，预览，"/>
<meta property="og:site_name" content="星巴克"/>
<meta property="og:locale" content="zh_CN"/>
<meta property="og:type" content="article"/>
<meta property="og:url" content="https://www.starbucks.cn/"/>
<meta property="og:title" content="首页 | 星巴克"/>
<meta property="og:description" content="欢迎访问星巴克首页"/>
<meta name="description" content="欢迎访问星巴克首页"/>
<meta property="og:image" content="https://www.starbucks.cnimg/logo.png"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico?v=20161028"/>
<link rel="apple-touch-icon" href="img/touch-icon-iphone.png"/>
<link rel="apple-touch-icon" sizes="72x72" href="img/touch-icon-ipad.png"/>
<link rel="apple-touch-icon" sizes="114x114" href="img/touch-icon-iphone4.png"/>
<link href="css/style.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">
<link type="text/css" href="css/Untitled-2.css" rel="stylesheet" />

<!-- Google Analytics Content Experiment code -->
<script>function utmx_section(){}function utmx(){}(function(){var
k='118442932-5',d=document,l=d.location,c=d.cookie;
if(l.search.indexOf('utm_expid='+k)>0)return;
function f(n){if(c){var i=c.indexOf(n+'=');if(i>-1){var j=c.
indexOf(';',i);return escape(c.substring(i+n.length+1,j<0?c.
length:j))}}}var x=f('__utmx'),xx=f('__utmxx'),h=l.hash;d.write(
'<sc'+'ript async src="'+'http'+(l.protocol=='https:'?'s://ssl':
'://www')+'.google-analytics.com/ga_exp.js?'+'utmxkey='+k+
'&utmx='+(x?x:'')+'&utmxx='+(xx?xx:'')+'&utmxtime='+new Date().
valueOf()+(h?'&utmxhash='+escape(h.substr(1)):'')+
'" type="text/javascript" charset="utf-8"><\/sc'+'ript>')})();
</script>
<!-- End of Google Analytics Content Experiment code -->
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
<div style="margin:0 auto;width:0px;height:0px;overflow:hidden;">
	<img id='thumbnail' src="picture/logo.png" width='350' height='350'/>
</div>
<div id="wrapper">
	<div id="content">
		<nav class="navbar togglefree" id="mainNav" role="navigation">
		<div class="container-fluid" >
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
					<div class="col-xs-2" >
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
		
		<div id="homePage">
			<div data-ride="carousel" class="carousel slide" id="carousel-generic">
				<div role="listbox" class="carousel-inner">
					<div class="item active">
						<a href="#" onclick="ga_download('HP','kv','top_kv');">
						<img border="0" src="images/a1.jpg" class='big desktop' data-holder-rendered="true"/>
						</a>
					</div>
				</div>
			</div>
			<div class='rewards'>
				<img src="picture/rewards.jpg" class='big'/>
				<div class='container'>
					<h2>舌尖上的星辰</h2>
					<p>
						星辰咖啡，开启您的星享之旅，快快选取您的美味吧！！
					</p>
					<div class='buttons'>
						<a href="../CoffeeServlet?flag=getAllCoffeeQian" class="btn btn1 btn-lg btn-primary" type="button" onclick="gas('HP', 'msr', 'register_btn_');">去购物</a>
		<!-- 预定功能没写 -->
						<a href="addOrder.jsp" class="btn btn2 btn-lg btn-primary" type="button" onclick="gas('HP', 'msr', 'login_btn_');">去预定</a>
						<div class='fix'>
						</div>
					</div>
				</div>
			</div>
			
			
			<!-- 商品图片 -->
			<div class='barista'>
				<div class='container'>
					<h3>星辰经典</h3>
					<h2>咖啡师的最爱</h2>
					<hr class='h2'>
					<p>
						回溯多年历史，星辰的技巧纯熟的咖啡师一直用心制作星辰的经典与饮品。
					</p>
				</div>
				
			<div class="border-left">
               	<div class="border-right">
                  	<div id="photo-list1">  
                  		<ul id="scroll1">  
                  			<c:forEach items="${coffees}" var="coffee">
								<li><a href="../CoffeeServlet?flag=QgetDetail&coffeeNo=${coffee.coffeeNo}"><img src="<%=request.getContextPath() %>/upload/${coffee.picPath}" width="210px" height="200px" alt="${coffee.coffeeName}"/></a></li>
							</c:forEach>
						</ul>
						<script  type="text/javascript">
							var id = function(el) {          
							return document.getElementById(el);        }
						       c = id("photo-list1");
							   
						   if(c!="") {
						       var ul = id("scroll1");
							  
						           lis = ul.getElementsByTagName("li");
						           itemCount = lis.length;
						           width = lis[0].offsetWidth; //获得每个img容器的宽度
						           marquee = function() {
						               c.scrollLeft += 2;
						               if(c.scrollLeft % width <= 1){  //当 c.scrollLeft 和 width 相等时，把第一个img追加到最后面
						                   ul.appendChild(ul.getElementsByTagName('li')[0]);
						                   c.scrollLeft = 0;
						               }
						           }
						           speed = 50; //数值越大越慢
						       ul.style.width = width*itemCount + 'px'; //加载完后设置容器长度        
						       var timer = setInterval(marquee, speed);
						       c.onmouseover = function() {
						           clearInterval(timer);
						       }
						       c.onmouseout = function() {
						           timer = setInterval(marquee, speed);
						       }
							   
						   }
						</script>
					</div>
                  </div>
               </div>
			
			
				<div class='barslider-mobile-cont'>
					<div class='barslider-mobile'>
					</div>
				</div>
			</div>
			
			<div class='app'>
				<div class='container'>
					<div class='mytable'>
						<div class='cell'>
							<h3>星辰咖啡官方APP</h3>
							<p>
								更新或下载全新星辰咖啡官方APP，开启更便捷的星辰体验，同时凭借手机客户端进店将享受9折优惠。快快体验吧！
							</p>
							<div class="buttons last-buttons">
								<a href="#" type="button" class="btn btn-lg btn-primary" onclick="alert('本功能正在开发，敬请期待')">下载地址</a>
								<a href="contact.jsp" type="button" class="btn btn-lg btn-primary" onclick="ga_download('HP','app','download_btn');">关于我们</a>
							</div>
						</div>
					</div>
				</div>
				<img src="picture/mobile-app-20160705111504.png" class='big'/>
				<div class='fix'>
				</div>
				<div class='container mobile'>
					<a href="#" data-url="/" type="button" class="btn btn-lg btn-primary" onclick="ga_download('HP','app','download_btn');">下载应用</a>
				</div>
			</div>
		
			
			<div class='reserve'>
				<div class='container'>
					<div class='mytable'>
						<div class='cell cell1'>
							<img src="picture/homepage-reserve.png"/>
						</div>
						<div class='cell'>
							<h3>我们优质的咖啡产品</h3>
							<p>
								我们持续在全世界各地寻找优质而稀少的咖啡豆，我们喜爱与您分享我们的新发现。我们在星辰位于总部西雅图的星辰臻选™咖啡烘焙工坊及品鉴馆为您精心烘焙星巴克臻选™咖啡。
							</p>
							<div class="buttons">
								<a href="../GossipServlet?flag=gossip" type="button" class="btn btn-lg btn-primary">点击查看留言 </a> 
								<a href="../CoffeeServlet?flag=getAllCoffeeQian" type="button" class="btn btn-lg btn-primary">在这里购买</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer--1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a id="wechat_icon" onclick="$('#wechat_qrcode').toggle();ga('send', 'event', 'social icons', 'footer', 'weixin');" style="position: relative; float: right; display: inline-block; width: 40px; height: 40px; border-radius: 20px; background: url('images/wechat.svg') no-repeat;background-size: contain; margin-right: 20px; cursor: pointer;">
					<div id="wechat_qrcode" style="display: none; position: absolute; z-index: 1000; top: -200px; left: -200px; width: 200px; height: 200px; background: url('images/qrcode.svg') no-repeat;background-size: contain;">
					</div>
					</a>
              &copy; 2016 Starbucks Corporation.
					<br/>All rights reserved. 沪ICP备09020061号 <br/><a target="_self" href="#" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="picture/icpicon.png" style="float:left;"/>
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
<script src="js/home.min.js"></script>
</body>
</html>