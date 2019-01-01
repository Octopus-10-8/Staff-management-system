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

<form  class="form-horizontal" action="departmentUpdateServlet" method="post">
		<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        <input type="hidden"  name="departmentId" value="${dep.departmentId }"/>
        <div class="row">
        	<div class="col-sm-7"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门名称</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control"  name="departmentName" value="${dep.departmentName }" placeholder="请输入部门名称"/> 
                    </div>
                </div>
            </div>
        	<div class="col-sm-7"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">部门描述</label>
                	<div  class="col-sm-9">
                    	<textarea  class="form-control" rows="5"  name="departmentDesc" placeholder="请输入部门描述" >${dep.departmentDesc}</textarea>
                    
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-3">
            	<input type="submit" class="btn btn-success" value="修改部门">
                <input type="reset" class="btn  btn-danger" value="重置信息">
            </div>
        </div>
  

</form>

</body>
</html>
