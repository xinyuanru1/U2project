<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改咖啡 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
<script type="text/javascript">
	function isNull(){
			var inval = $(".inpMain").val();
			if($("#proName").val().length==0||$("#proType").val().length==0||$("#proPrice").val().length==0){
				$("#msg").html("不能有空值");
				return false;
			}
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
            <h3>修改咖啡</h3>
    <form action="../CoffeeServlet?flag=updateCoffee" method="post" onsubmit="return isNull()" enctype="multipart/form-data">
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic"  id="tableid">
     <tr>
       <td>
        <input type="hidden" name="coffeeNo" value="${coffee.coffeeNo}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
		<tr>
       <td width="100" align="right">产品名称</td>
       <td>
        <input id="proName" type="text" name="coffeeName" value="${coffee.coffeeName}" size="20" class="inpMain" style="height:30px"/>
       </td>
      </tr>
      <tr>
       <td width="100" align="right">产品类别</td>
       <td>
		  <select name="coffeeType">
			<option value="早咖啡">早咖啡</option>
			<option value="午咖啡">午咖啡</option>
			<option value="晚咖啡">晚咖啡</option>
       	</select>     	
       </td>
      </tr>
      <tr>
       <td width="100" align="right">产品单价</td>
       <td>
        <input id="proPrice" type="text" name="coffeePrice" value="${coffee.coffeePrice}" size="20" class="inpMain" style="height:30px" />
       </td>
      </tr>
     <tr>
       <td width="100" align="right">图片</td>
       <td  class="noNull">
        <input value="${coffee.picPath}" type="file" name="picPath" size="20" class="inpMain" style="height:30px" id="proPic"/>
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
