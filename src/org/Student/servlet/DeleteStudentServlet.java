package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.service.StudentService;

public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ɾ��
		request.setCharacterEncoding("utf-8");
		//����ǰ�˴�����ѧ��
		int no=Integer.parseInt(request.getParameter("sno"));
		
		StudentService studentService=new StudentService();
		boolean result=studentService.deleteStudentByNo(no);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");//����jsp����
		PrintWriter out=response.getWriter();
		if(result) {
//			out.print("ɾ���ɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("ɾ��ʧ�ܣ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
