package org.Student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.StudentService;

public class QueryStudentByNoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		StudentService studentService=new StudentService();
		Student student=studentService.queryStudentByNo(no);
//		System.out.println(student);
		//将student放入attribute域
		request.setAttribute("student", student);
		//请求转发
		request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
