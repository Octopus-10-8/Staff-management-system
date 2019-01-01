<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/jquery-1.9.1.min.js"></script>
<script src="resource/assets/js/bootstrap.min.js"></script>
<script src="resource/My97DatePicker/WdatePicker.js"></script>


</head>

<body>

	<form  class="form-horizontal" action="employeeAddServlet" method="post">
		<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
        </h5>
        
        <!-- 111 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工姓名</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="employeeName" placeholder="请输入员工姓名"/> 
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工年龄</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="employeeAge" placeholder="请输入员工年龄"/> 
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 111 -->
        <!-- 222 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工生日</label>
                	<div  class="col-sm-5">
                    	<input type="text"  readonly="readonly"     class="form-control"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="employeeTIme" placeholder="请输入员工生日"/> 
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">电话号码</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="employeePhone" placeholder="请输入电话号码"/> 
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 2222 -->
               <!-- 3333 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工性别</label>
                	<div  class="col-sm-3">
                    	<select class="form-control" name="employeeSex">
                        	<option>保密</option>
                        	<option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                </div>
            </div>
      	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工部门</label>
                	<div  class="col-sm-7">
                    	<select name="departmentId" class="form-control">
                    		<c:forEach items="${list }" var="de">
                    		  	<option value="${de.departmentId }">${de.departmentName }</option>
                    		</c:forEach>
                        </select>
                    </div>
                </div>
            </div>
 
        </div>
       <!-- 3333 -->
         
       	<h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        账户信息
        </h5>
                <!-- 222 -->
        <div class="row">
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工帐号</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="userId" placeholder="请输入员工帐号"/> 
                    </div>
                </div>
            </div>
        	<div class="col-sm-5"> 
            	<div class="form-group">
                	<label class="col-sm-3 control-label">员工密码</label>
                	<div  class="col-sm-9">
                    	<input type="text" class="form-control" name="userPw" placeholder="请输入员工密码"/> 
                    
                    </div>
                </div>
            </div>
        </div>
       <!-- 2222 -->
        
        <div class="row">
        	<div class="col-sm-3 col-sm-offset-4">
            	<input type="submit" class="btn btn-success" value="添加员工">
                <input type="reset" class="btn  btn-danger" value="重置信息">
            </div>
        </div>
  

</form>

</body>
</html>
