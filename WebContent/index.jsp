<%@page import="org.Student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 使用绝对路径引入bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
$(function(){
	$("#Out").click(function(){
		var flag=window.confirm("你真的要退出吗？")
		if(flag){
			window.location.href="LoginOut.jsp"
		}
	})
})
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">学生信息管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">欢迎光临<%= request.getSession().getAttribute("username")%></a></li>
            <li><a href="ChangePwd.jsp">修改密码</a></li>
            <li><a href="javascript:void(0)" id="Out">注销</a></li>
          </ul>
        </div>
      </div>
    </nav>
	<table class="table table-striped table-bordered table-hover mid">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<%
			//获取request域中的数据
			List<Student> students=(List<Student>)request.getAttribute("students");
			for(Student student:students){
		%>
			<tr>
				<td><a href="QueryStudentByNoServlet?sno=<%=student.getNo() %>"><%=student.getNo() %></a></td>
				<td><%=student.getName() %></td>
				<td><%=student.getAge() %></td>
				<td><%=student.getAddress() %></td>
				<td><a href="DeleteStudentServlet?sno=<%=student.getNo() %> ">删除</a></td>
			</tr>
		<%
			}
		%>
	</table>
	<button class="btn btn-default"><a href="add.jsp">新增</a></button>
</body>
</html>