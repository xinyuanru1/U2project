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
<title>联系我们 | 星辰</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="百度地图,百度地图API，百度地图自定义工具，百度地图所见即所得工具" />
    <meta name="description" content="百度地图API自定义地图，帮助用户在可视化操作下生成百度地图" />
    <title>百度地图API自定义地图</title>
    <!--引用百度地图API-->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=9ydUGk9IaC6hHodbLs1s7fuQSqbArBAE"></script>
<link href="css/style.css" rel="stylesheet">
<style>
.async-hide { opacity: 0 !important}
</style>
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
		<header>
		<div class="container">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 text-center">
					<h1>
					<small>星辰帮助中心</small>
          联系我们
					</h1>
					<p class="lead">
					</p>
				</div>
			</div>
		</div>
		</header>
		<section class="contact__details">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
					<dl>
						<dt>邮箱地址</dt>
						<dd>customercarecn@xingchen.cn</dd>
						<dt>联系电话</dt>
						<dd>400-820-6998</dd>
						<dt>邮寄地址</dt>
						<dd>上海市桂箐路65号新研大厦B座24楼（邮编 200233）</dd>
						<dt>地图位置</dt>
						<dd>
							<!--百度地图容器-->
  <div style="width:697px;height:550px;border:#ccc solid 1px;" id="dituContent"></div>
</body>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(121.411147,31.178764);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var markerArr = [{title:"我的标记",content:"我的备注",point:"116.362012|39.950786",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
		 ,{title:"位置",content:"我们在这里！",point:"121.411731|31.178239",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
		 ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
			var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				if(!!json.isOpen){
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
</script>
							

							
						</dd>
					</dl>
					<div class="text-small text-muted">
						<p>
							我们的工作时间为：周一至周日 9:00-18:00（节假日除外）
						</p>
					</div>
				</div>
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