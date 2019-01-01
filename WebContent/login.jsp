<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>      
<%@ taglib prefix="c" uri="http://displaytag.sf.net" %>  
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/jquery-1.9.1.min.js"></script>  
<script src="resource/assets/js/bootstrap.min.js"></script>
<style  type="text/css">

body{ 
background:url(resource/images/bg.jpg);
background-position:center;
background-repeat:no-repeat;
background-size:cover;/*让背景基于容器*/
background-attachment:fixed;/*当内容高度大雨图片高度，背景图像的位置相对viewport固定*/
margin-left:auto;
margin-right:auto;
margin-top:200px;
width:20em;
}

</style>


<script>

var info='${info}';
if(info.length>0){
	
	
	alert(info);
}


</script>


</head>

<body>
<form action="loginServlet" method="post">
	<div class="form-group">
    	<label class="sr-only" for="userId">帐号</label>
        <div class="input-group">
        	<div class="input-group-addon">帐号</div>
        	<input type="text" class="form-control" id="userId" name="userId" placeholder="请输入帐号"/>
         </div>
    </div>
	<div class="form-group">
    	<label class="sr-only" for="userId">密码</label>
        <div class="input-group">
        	<div class="input-group-addon">密码</div>
        	<input type="text" class="form-control" id="userId" name="userPw"  placeholder="请输入密码"/>
         </div>
    </div>
	<!-- 按钮-->
    <input type="submit" style="width:280px;" value="登 录" class="btn btn-success"/>
</form>


</body>
</html>
