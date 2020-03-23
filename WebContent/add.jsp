<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add.css">
</head>
<body>
	<div class="container" id="maindiv">
		<form action="AddStudentServlet" method="post" >
			<div class="form-group">
				学号：<input type="text" name="sno" class="form-control"><br>
				姓名：<input type="text" name="sname" class="form-control"><br>
				年龄：<input type="text" name="sage" class="form-control"><br>
				地址：<input type="text" name="saddress" class="form-control"><br>
				<input type="submit" value="增加" class="btn btn-default">
			</div>
			<button class="btn btn-success"><a href="QueryAllStudentServlet">返回</a></button>	
		</form>
	</div>
	
</body>
</html>