<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改预购单 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function isNull(){
			var inval = $(".inpMain").val();
			if($("#proName").val().length==0||$("#proPhone").val().length==0||$("#proTime").val().length==0||$("#proNum").val().length==0
			||$("#userPhone").val().length==0||$("#userAddress").val().length==0){
				$("#msg").html("不能有空值");
				return false;
			}
			return true;
	}
</script>
</head>
<body>
<%@include file="common.jsp" %>
<div id="dcWrap">
 <div id="dcHead">
 <div id="head">
  <div class="nav">
   <ul class="navRight">
    <li class="M noLeft">您好，admin</a>
    </li>
    <li class="noRight"><a href="../UserServlet?flag=logout">退出</a></li>
    <li><a href="../XingChen/index.jsp">返回前台</a></li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><div id="menu">
 
<ul>
	<li class="cur"><a href="../GossipServlet?flag=getAll"><i class="product"></i><em>留言列表</em></a></li>
  <li class="cur"><a href="../OrderServlet?flag=getAll"><i class="product"></i><em>预定列表</em></a></li>
  <li class="cur"><a href="../CoffeeServlet?flag=getAll"><i class="product"></i><em>咖啡列表</em></a></li>
  <li class="cur"><a href="../UserServlet?flag=getAll"><i class="product"></i><em>顾客列表</em></a></li>
  <li class="cur"><a href="../NewsServlet?flag=getAll"><i class="product"></i><em>新闻列表</em></a></li>
  <li class="cur"><a href="../MenuServlet?flag=getAll"><i class="product"></i><em>订单列表</em></a></li>
</ul>
</div></div>
 <div id="dcMain">
   <!-- 当前位置 -->
<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3>修改订单</h3>
    <form action="../MenuServlet?flag=update&menuNo=${menu.menuNo}" method="post" onsubmit="return isNull()">
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
		<tr>
       <td width="100" align="right">用户名</td>
       <td>
        <input id="proName" type="text" name="userName" value="${menu.userName}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
     <tr>
       <td width="100" align="right">产品名称</td>
       <td>
        <input id="proPhone" type="text" name="proName" value="${menu.proName}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">单价</td>
       <td>
        <input id="proTime" type="text" name="proPrice" value="${menu.proPrice}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">数量</td>
       <td>
        <input id="proTime" type="text" name="proPrice" value="${menu.proNum}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">总价</td>
       <td>
        <input id="proTime" type="text" name="proPrice" value="${menu.proTotalPrice}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td align="right">用户电话</td>
       <td>
        <input type="text" name="userPhone" size="20" value="${menu.userPhone}" class="inpMain" id="userPhone"/>
       </td>
      </tr>
      <tr>
       <td align="right">送餐地址</td>
       <td>
        <input id="userAddress" type="text" name="userAddress" value="${menu.userAddress}" class="inpMain"/>
       </td>
      </tr>
      <tr>
       <td align="right">预定状态</td>
       <td>
        <select name="menuStatu">
        	<option value="未支付">未支付</option>
        	<option value="已支付">已支付</option>
        	<option value="已完成">已完成</option>
        </select>
       </td>
      </tr>
      <tr>
       <td id="msg"></td>
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
