package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Login;
import org.Student.service.StudentService;
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		Login login=new Login(name,pwd);
		StudentService studentService=new StudentService();
		boolean result=studentService.register(login);
		PrintWriter out = response.getWriter();
//		System.out.println(result);
		if(result) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
