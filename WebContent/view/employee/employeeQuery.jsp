<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
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

	<form class="form-inline" action="employeeServlet" method="post">
	
		<div class="row alert alert-info"
			style="margin: 0px; padding: 0px; padding-left: 50px;">
			<div class="form-group">
				<label>员工编号</label> <input type="text" class="form-control"
					name="employeeId" value="${emp.employeeId==0?'':mp.employeeId }"
					placeholder="请输入员工编号"> <label>员工姓名</label> <input
					type="text" class="form-control" name="employeeName"
					value="${emp.employeeName }" placeholder="请输入员工姓名"> <label>员工帐号</label>
				<input type="text" class="form-control" name="userId"
					value="${emp.userId }" placeholder="请输入员工帐号">
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="employeeAddServlet" class="btn btn-success">添加员工</a>
		</div>
		<div class="row" style="padding: 15px;">

			<!-- 员工管理信息分页 -->
			<d:table class="table" name="list" pagesize="5"
				requestURI="DepartmentQuery">


				<d:column property="employeeId" title="员工编号"></d:column>
				<d:column property="employeeName" title="员工姓名"></d:column>
				<d:column property="employeeSex" title="员工性别"></d:column>
				<d:column property="departmentName" title="部门名称"></d:column>
				<d:column property="employeeAge" title="员工年龄"></d:column>
				<d:column property="employeeTIme" format="{0,date,yyyy-MM-dd}"
					title="员工生日"></d:column>
				<d:column property="employeePhone" title="电话号码"></d:column>
				<d:column property="userId" title="员工帐号"></d:column>

				<d:column value="修改" title="修改" href="employeeUpdateServlet"
					paramId="employeeId" paramProperty="employeeId"></d:column>
				<d:column value="删除" title="删除" href="employeeDeleteServlet"
					paramId="employeeId" paramProperty="employeeId"></d:column>
			</d:table>




		</div>
	</form>

</body>
</html>
