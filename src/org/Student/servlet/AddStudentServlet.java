package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.StudentService;

//表示层后台
public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		//传递参数给javaBean
		Student student=new Student(no,name,age,address);
		
		//调用业务逻辑层
		StudentService studentService=new StudentService();
		boolean result=studentService.addStudent(student);
		//设置响应编码，，，编码必须设置在流之前，即（PrintWriter）之前
		response.setContentType("text/html; charset=UTF-8");//设置将java编译成jsp的编码
		response.setCharacterEncoding("utf-8");//设置jsp编码
		
		PrintWriter out=response.getWriter();
		if(result) {
//			out.print("增加成功！");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("增加失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
