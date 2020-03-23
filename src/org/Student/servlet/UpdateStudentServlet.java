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
		//�޸�
		//��ȡҪ�޸��˵�ѧ��
		int no=Integer.parseInt(request.getParameter("sno"));
		//��ȡ�޸ĺ������
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		//���޸ĺ�����ݷ�װ��javabean��
		Student student=new Student(name,age,address);
		//����service��
		StudentService studentService=new StudentService();
		boolean result= studentService.updateStudentByNo(no, student);
		//�޸ı���
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");//����jsp����
		PrintWriter out=response.getWriter();
		if(result) {
//			out.print("�޸ĳɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("�޸�ʧ�ܣ�");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
