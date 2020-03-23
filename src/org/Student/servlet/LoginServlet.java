package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Student.entity.Login;
import org.Student.service.StudentService;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		Login login=new Login(name,pwd);
		StudentService studentService=new StudentService();
		boolean result=studentService.login(login);
		PrintWriter out = response.getWriter();
		if(result) {
			//设置session
			HttpSession session = request.getSession();
			//编码是为了在cookie中存储汉字
	        String nameCode = URLEncoder.encode(name, "utf-8");
			Cookie usernameCookie = new Cookie("username",nameCode);
	        Cookie passwordCookie = new Cookie("password",pwd);
	        //设置持久化时间
	        usernameCookie.setMaxAge(60*60);
	        passwordCookie.setMaxAge(60*60);
	        //设置cookie携带路径
	        usernameCookie.setPath(request.getContextPath());
	        passwordCookie.setPath(request.getContextPath());
	        //发送cookie
	        response.addCookie(usernameCookie);
	        response.addCookie(passwordCookie);
	        session.setAttribute("username", name);
	        session.setAttribute("password", pwd);
			out.write("true");
		}else {
			out.write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
