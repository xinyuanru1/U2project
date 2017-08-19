<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
<script type="text/javascript">
	function condelete(){
		var isdelete = confirm('请确认是否删除');
		var asdf=$("#GossipId").html();
		if(isdelete){
			$("#delId").attr("href","../NewsServlet?flag=delete&newsNo="+asdf);
		}else{
			$("#delId").attr("href","../NewsServlet?flag=getAll");
		}
	}
</script>
</head>
<body>
<%@include file="common.jsp" %>
<div id="dcWrap">
 <div id="dcHead">
 <div id="head">
  <div class="logo"></div>
  <div class="nav">
   <ul class="navRight">
    <li class="M noLeft">您好，admin</a>
     <div class="drop mUser">
     </div>
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
</div>
</div>
 <div id="dcMain">
   <!-- 当前位置 -->   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="../admin/addNews.jsp" class="actionBtn add">添加新闻</a>新闻列表</h3>
    <div class="filter">
    </div>
        <div id="list">
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <tr>
        <th align="center">编号</th>
        <th align="left">标题</th>
        <th align="center">内容</th>
        <th align="center">操作</th>
      </tr>
      <c:forEach items="${newss}" var="news">
      		<tr>
		        <td align="center" id="GossipId">${news.newsNo}</td>
		        <td><a href="../NewsServlet?flag=detail&newsNo=${news.newsNo}">${news.newsTitle}</a></td>
		        <td align="center">${news.newsContent}</td>
		        <td align="center"><a href="../NewsServlet?flag=getNewsForUpd&newsNo=${news.newsNo}">编辑</a> | <a id="delId" href="NewsServlet?flag=delete&newsNo=${news.newsNo}" onclick="condelete()">删除</a></td>
		     </tr>
      </c:forEach>
	</table>
    </div>
    <div class="clear"></div>
	<div class="pager">共 ${pageCount}  页，当前第 ${pageIndex }页 | 
    <c:if test="${pageIndex>1}">
    	<a href="../NewsServlet?flag=getAll">第一页</a>
    	<a href="../NewsServlet?flag=getAll&pageIndex=${pageIndex-1}">上一页</a> 
    </c:if>
   	<c:if test="${pageIndex<pageCount}">
   		<a href="../NewsServlet?flag=getAll&pageIndex=${pageIndex+1}">下一页 </a> 
   		<a href="../NewsServlet?flag=getAll&pageIndex=${pageCount}">最末页</a>
   	</c:if> 
   </div>               
   </div>
 </div>
 <div class="clear"></div>
<div id="dcFooter">
 <div id="footer">
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
<script type="text/javascript">

onload = function()
{
 document.forms['action'].reset();
}

function douAction()
{
 var frm = document.forms['action'];
 frm.elements['new_cat_id'].style.display = frm.elements['action'].value == 'category_move' ? '' : 'none';
}

</script>
<img src="admin/images/${coffe.picPath}"/>
</body>
</html>
