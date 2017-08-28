<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$(function(){
			$.getJSON("getAll.do",callback);
			function callback(data){
				$("#tb").append("<tr><td>供应商编码</td><td>供应商名称</td></tr>")
				$(data).each(function(){
					$("#tb").append("<tr><td>"+this.proCode+"</td><td>"+this.proName+"</td></tr>");
				});
				$("#tb").css("margin","0 auto");
				$("#tb tr td").css("text-align","center").css("background","grey");
				$("#tb tr td:odd").css("color","yellow");
				$("#tb tr td:even").css("color","white");
				$("#tb tr:first td").css("background","green").css("color","white");
			}
		});
	</script>
  </head>
  <body>
	<table border="0" id="tb" cellpadding="" cellspacing="2"></table>
  </body>
</html>
