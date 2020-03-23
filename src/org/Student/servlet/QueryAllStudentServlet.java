package org.Student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.StudentService;

public class QueryAllStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentService studentService=new StudentService();
		List<Student> students=studentService.queryAllStudents();
//		System.out.println(students);
		//将students放入request域
		request.setAttribute("students", students);
		//请求转发将学生信息传到index
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
