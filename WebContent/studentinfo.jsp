<%@page import="org.Student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/update.css">
</head>
<body>
<!-- 	获取attribute中的数据 -->
	<% Student student=(Student)request.getAttribute("student"); %>
<!-- 	使用表单展示 -->
	<div class="container" id="maindiv">
		<form action="UpdateStudentServlet" method="post">
			<div class="form-group">
				学号：<input type="text" name="sno" value="<%=student.getNo() %>" readonly="readonly" class="form-control"><br/>
				姓名：<input type="text" name="sname" value="<%=student.getName() %>" class="form-control"><br/>
				年龄：<input type="text" name="sage" value="<%=student.getAge() %>" class="form-control"><br/>
				地址：<input type="text" name="saddress" value="<%=student.getAddress() %>" class="form-control"><br/>
				<input type="submit" value="修改" class="btn btn-default">
			</div>
			<button class="btn btn-success"><a href="QueryAllStudentServlet">返回</a></button>
		</form>
	</div>

</body>
</html>