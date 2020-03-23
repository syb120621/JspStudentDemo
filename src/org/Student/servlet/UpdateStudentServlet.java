package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.StudentService;
public class UpdateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//修改
		//获取要修改人的学号
		int no=Integer.parseInt(request.getParameter("sno"));
		//获取修改后的内容
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		//将修改后的内容封装到javabean中
		Student student=new Student(name,age,address);
		//调用service层
		StudentService studentService=new StudentService();
		boolean result= studentService.updateStudentByNo(no, student);
		//修改编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");//设置jsp编码
		PrintWriter out=response.getWriter();
		if(result) {
//			out.print("修改成功！");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("修改失败！");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
