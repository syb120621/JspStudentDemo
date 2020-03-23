package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Login;
import org.Student.service.StudentService;
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name=request.getParameter("uname");
		String pwd=request.getParameter("newpwd");
		Login login=new Login(name,pwd);
		StudentService studentService=new StudentService();
		boolean result = studentService.changePwd(login);
		PrintWriter out = response.getWriter();
		if(result) {
			out.write("true");
		}else {
			out.write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
