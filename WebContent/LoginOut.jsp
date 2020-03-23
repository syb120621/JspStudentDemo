<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//销毁会话
		session.invalidate();
	%>
	<h1>注销成功</h1>
	<a href="Login.jsp">重新登录</a>
</body>
</html>