<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function register1(){
		var name=$("#username").val()
		var passwd=$("#userpasswd").val()
		$.ajax({
			url:"RegisterServlet",
			type:"post",
			data:{
				"uname":name,
				"upwd":passwd
			},
			dataType:"json",
			success:function(result){
				if(result==true){
					alert("注册成功，请前往登录！")
				}else{
					alert("注册失败，该账户已存在!")
				}
			},
			complete:function(){
				$("#username").val('')
				$("#userpasswd").val('')
			},
			error:function(){
				console.log("系统异常！")
			}
		})
	}
</script>
</head>
<body>
	<div class="register_div">
		<form action="">
			<div class="form-group">
				用户名：<input type="text" name="uname" class="form-control" id="username"><br>
				密码：<input type="text" name="upwd" class="form-control" id="userpasswd"><br>
				<input type="button" class="btn btn-success" onclick="register1()" value="注册"></input>
				<button class="btn btn-default"><a href="Login.jsp">返回</a></button>
			</div>
		</form>
	</div>
</body>
</html>