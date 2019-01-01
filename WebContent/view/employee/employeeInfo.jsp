<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/jquery-1.9.1.min.js"></script>  
<script src="resource/assets/js/bootstrap.min.js"></script>
</head>

<body>

<script>

alert("${info}");

//添加完成后出查询数据
//跳转回查询页面，绝对路径是项目路径
window.location="<%=basePath%>employeeServlet";




</script>
</body>
</html>