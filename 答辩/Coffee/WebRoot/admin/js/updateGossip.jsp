<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改订单 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
</head>
<body>
<div id="dcWrap">
 <div id="dcHead">
 <div id="head">
  <div class="nav">
   <ul class="navRight">
    <li class="M noLeft"><a href="JavaScript:void(0);">您好，admin</a>
    </li>
    <li class="noRight"><a href="../UserServlet?flag=logout">退出</a></li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><div id="menu">
 
<ul>
	<li class="cur"><a href="../GossipServlet?flag=getAll"><i class="product"></i><em>留言列表</em></a></li>
  <li class="cur"><a href="../OrderServlet?flag=getAll"><i class="product"></i><em>订单列表</em></a></li>
  <li class="cur"><a href="../CoffeeServlet?flag=getAll"><i class="product"></i><em>咖啡列表</em></a></li>
  <li class="cur"><a href="../UserServlet?flag=getAll"><i class="product"></i><em>顾客列表</em></a></li>
  <li class="cur"><a href="../NewsServlet?flag=getAll"><i class="product"></i><em>新闻列表</em></a></li>
</ul>
</div></div>
 <div id="dcMain">
   <!-- 当前位置 -->
<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="listGossip.jsp" class="actionBtn">订单列表</a>修改订单</h3>
    <form action="../OrderServlet?flag=update&orderNo=${order.orderNo}" method="post">
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
		<tr>
       <td width="100" align="right">姓名</td>
       <td>
        <input type="text" name="orderName" value="${order.orderName}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
     <tr>
       <td width="100" align="right">电话</td>
       <td>
        <input type="text" name="orderPhone" value="${order.orderPhone}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">预定时间</td>
       <td>
        <input type="text" name="orderTime" value="${order.orderTime}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">预定人数</td>
       <td>
        <input type="text" name="orderNum" value="${order.orderNum}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td></td>
       <td>
        <input type="hidden" name="token" value="5a58b748" />
        <input type="submit" name="submit" class="btn" value="确定" />
       <input type="button" name="submit" class="btn" value="返回" onclick="javascript:window.history.go(-1)"/>
       </td>
      </tr>
     </table>
    </form>
 	</div>
 </div>
 <div class="clear"></div>
<div id="dcFooter">
 <div id="footer">
  <div class="line"></div>
 </div>
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>
