<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
	function login(){
		var name=$("#username").val()
		var passwd=$("#userpasswd").val()
		$.ajax({
			url:"LoginServlet",
			type:"post",
			data:{
				"uname":name,
				"upwd":passwd
			},
			dataType:"json",
			success:function(result){
				if(result==true){
					window.location.href = "QueryAllStudentServlet"
				}else{
					alert("账户密码错误！")
				}
			},
			complete:function(){
				$("#username").val('')
				$("#userpasswd").val('')
			},
			error:function(){
				console.log("系统异常")
			}
		})
	}
</script>
</head>
<body>
	<div class="login_div">
		<form action="">
			<div class="form-group">
				用户名：<input type="text" name="uname" class="form-control" id="username"><br>
				密码：<input type="text" name="upwd" class="form-control" id="userpasswd"><br>
				<input type="button" class="btn btn-success" value="登录" onclick="login()"></input>
				<button class="btn btn-default"><a href="register.jsp">注册</a></button>
				<button class="btn btn-info"><a href="FindPwd.jsp">忘记密码</a></button>
			</div>
		</form>
	</div>
</body>
</html>