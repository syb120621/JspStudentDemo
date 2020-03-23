package org.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.StudentService;

//��ʾ���̨
public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		//���ݲ�����javaBean
		Student student=new Student(no,name,age,address);
		
		//����ҵ���߼���
		StudentService studentService=new StudentService();
		boolean result=studentService.addStudent(student);
		//������Ӧ���룬�������������������֮ǰ������PrintWriter��֮ǰ
		response.setContentType("text/html; charset=UTF-8");//���ý�java�����jsp�ı���
		response.setCharacterEncoding("utf-8");//����jsp����
		
		PrintWriter out=response.getWriter();
		if(result) {
//			out.print("���ӳɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("����ʧ�ܣ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
