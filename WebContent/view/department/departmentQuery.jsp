<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://displaytag.sf.net" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<form class="form-inline" action="DepartmentQuery" method="post">
		<div class="row alert alert-info"
			style="margin: 0px; padding: 0px; padding-left: 50px;">
			<div class="form-group">
				<label>部门名称</label> <input type="text" class="form-control" name="departmentId"
					placeholder="请输入部门编号">
			</div>
				<div class="form-group">
				<label>部门名称</label> <input type="text" class="form-control" name="departmentName"
					placeholder="请输入部门名称">
			</div>
			<input type="submit" class="btn btn-danger" value="查询">
			 <a href="view/department/departmentAdd.jsp" class="btn btn-success">添加部门信息</a>
		</div>
		
		<!-- 分页 -->
		<div class="row" style="padding:15px;">
		<c:table class="table" name="list" pagesize="5"  requestURI="DepartmentQuery">
		
		<c:column property="departmentId" title="部门编号"></c:column>
		<c:column property="departmentName" title="部门名称"></c:column>
		<c:column property="departmentDesc" title="部门描述"></c:column>
		<c:column value="修改"  title="修改" href="departmentUpdateServlet" paramId="departmentId" paramProperty="departmentId"></c:column>
		<c:column value="删除"  title="删除" href="departmentDeleteServlet" paramId="departmentId" paramProperty="departmentId"></c:column>
		</c:table>
		</div>
	</form>

</body>
</html>
