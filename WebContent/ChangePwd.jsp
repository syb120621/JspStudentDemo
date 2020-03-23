<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changepwd.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
	function change(){
		var name=$("#username").val()
		var passwd=$("#newpwd").val()
		var cfpasswd=$("#cfpwd").val()
		if(name==""){
			alert("用户名不能为空")
		}else if(passwd==""){
			alert("密码不能为空")
		}else if(cfpasswd!=passwd){
			alert("两次输入密码不一致")
		}else{
			$.ajax({
				url:"ChangePwdServlet",
				type:"post",
				data:{
					"uname":name,
					"newpwd":passwd
				},
				dataType:"json",
				success:function(result){
					if(result==true){
						alert("修改成功，请重新登录")
						window.location.href = "Login.jsp"
					}else{
						alert("没有此用户，请输入正确的用户名！")
					}
				},
				complete:function(){
					$("#username").val('')
					$("#newpwd").val('')
					$("#cfpwd").val('')
				},
				error:function(){
					console.log("系统异常")
				}
			})
		}
	}
</script>
</head>
<body>
	<div class="Change_div">
		<form action="">
			<div class="form-group">
				用户名：<input type="text" name="uname" class="form-control" id="username"><br>
				新密码：<input type="password" name="newpwd" id="newpwd" class="form-control"><br>
				确认密码：<input type="password" name="" id="cfpwd" class="form-control"><br>
				<input type="button" class="btn btn-success" value="确定修改" onclick="change()"></input>
				<button class="btn btn-default"><a href="QueryAllStudentServlet">返回</a></button>
			</div>
		</form>
	</div>
</body>
</html>