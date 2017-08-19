<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function isNull(){
			var inval = $(".inpMain").val();
			if($("#proName").val().length==0||$("#proPhone").val().length==0||$("#d11").val().length==0||$("#proNum").val().length==0){
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
            <h3>添加预定</h3>
    <form action="../OrderServlet?flag=add" method="post" onsubmit="return isNull()">
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <tr>
       <td align="right">姓名</td>
       <td>
        <input type="text" name="orderName" value="" size="50" class="inpMain" id="proName"/>
       </td>
      </tr>
      <tr>
       <td align="right">电话</td>
       <td>
        <input type="text" name="orderPhone" value="" size="50" class="inpMain" id="proPhone"/>
       </td>
      </tr>
      <tr>
       <td align="right">预定时间</td>
       <td>
        <input id="d11" type="text" name="orderTime" class="inpMain" onClick="WdatePicker()"/>
       </td>
      </tr>
      <tr>
       <td align="right">预订人数</td>
       <td>
        <input type="text" name="orderNum" value="" size="50" class="inpMain" id="proNum"/>
       </td>
      </tr>
      <tr>
       <td id="msg"></td>
       <td>
        <input type="hidden" name="token" value="21307217" />
        <input type="hidden" name="id" value="">
        <input class="btn" type="submit" value="提交" />
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
